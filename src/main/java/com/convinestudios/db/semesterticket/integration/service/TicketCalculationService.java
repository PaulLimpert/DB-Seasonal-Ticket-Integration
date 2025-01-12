package com.convinestudios.db.semesterticket.integration.service;

import com.convinestudios.db.semesterticket.integration.exception.TrainNotFoundException;
import com.convinestudios.db.semesterticket.integration.model.ConnectionModel;
import com.convinestudios.db.semesterticket.integration.model.PriceModel;
import com.convinestudios.db.semesterticket.integration.model.SectionsModel;
import com.convinestudios.db.semesterticket.integration.model.StopModel;
import com.convinestudios.db.semesterticket.integration.model.internal.SearchRequest;
import com.convinestudios.db.semesterticket.integration.model.internal.SearchResponse;
import com.convinestudios.db.semesterticket.integration.model.requests.SpecificTrainRequest;
import com.convinestudios.db.semesterticket.integration.service.request.ExternalApiService;
import com.convinestudios.db.semesterticket.integration.validation.ticket.SeasonalTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * This class defines the algorithm that is required to find the tickets the user needs to buy under the condition of a semester ticket
 * and calculates the price for these tickets
 */
@Service
public class TicketCalculationService {

    private final ExternalApiService apiService;

    @Autowired
    public TicketCalculationService(ExternalApiService apiService) {
        this.apiService = apiService;
    }

    public SearchResponse investigate(SearchRequest searchRequest) {

        System.out.println("requesting initial data...");
        List<ConnectionModel> initialData = getInitialData(searchRequest);

        // walk through all initial connections (in parallel) and calculate the best prices for them
        Flux.fromIterable(initialData)
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .doOnNext(connection -> {
                    System.out.println("Checking: " + connection.getTripId());
                    findTickets(connection, searchRequest.getSeasonalTickets(), searchRequest);
                })
                .sequential()
                .blockLast();

        return new SearchResponse(searchRequest.getTimeOfRequest(), LocalDateTime.now(), initialData);
    }

    private List<ConnectionModel> getInitialData(SearchRequest searchRequest) {
        switch (searchRequest.getSearchMode()) {
            // todo: add cases for advanced searches
            case PERIODIC:
                // todo
                return null;
            case DAILY:
                // todo
                return null;
            default:
                return apiService.getConnectionsByTime(searchRequest.extractConnectionData());
        }
    }

    private void findTickets(ConnectionModel connection, List<SeasonalTicket> seasonalTickets, SearchRequest searchRequest) {

        List<SpecificTrainRequest> ticketsToRequest = new ArrayList<>();
        String origin = null;
        LocalDateTime timeOfDeparture = null;

        for (SectionsModel section: connection.getSections()) {
            for (StopModel stop: section.getStops()) {
                // check weather the stop is included within one of the owned seasonal tickets
                boolean isCoveredBySeasonalTicket = seasonalTickets.stream().anyMatch(ticket -> ticket.validateStop(stop.getName(), section.getVerkehrsmittel().getProduktGattung()));

                if (isCoveredBySeasonalTicket) {
                    // stop is covered: if there is an origin -> add to the required tickets
                    if (origin != null && !origin.equals(stop.getName())) {
                        ticketsToRequest.add(createTicketRequest(origin, stop.getName(), timeOfDeparture, section, searchRequest));
                        origin = null;
                    }
                } else {
                    // stop is not covered:
                    if (origin == null) {
                        origin = stop.getName();
                        timeOfDeparture = stop.getAbfahrtsZeitpunkt();
                    }
                }

            }

            // handling of the last segment
            if (origin != null && !origin.equals(section.getStops().getLast().getName())) {
                ticketsToRequest.add(createTicketRequest(origin, section.getStops().getLast().getName(), timeOfDeparture, section, searchRequest));
            }
            origin = null;
        }

        System.out.println("fetching potential " + ticketsToRequest.size() + " tickets...");

        if (!ticketsToRequest.isEmpty())
            fetchAndSetTickets(connection, ticketsToRequest);


    }

    private SpecificTrainRequest createTicketRequest(String origin, String destination, LocalDateTime timeOfDeparture, SectionsModel section, SearchRequest searchRequest) {
        return new SpecificTrainRequest(
                origin,
                destination,
                timeOfDeparture,
                section.getVerkehrsmittel().getName(),
                searchRequest.getKlasse(),
                List.of(section.getVerkehrsmittel().getProduktGattung()),
                searchRequest.getPassengers(),
                searchRequest.isBikeCarriage()
        );
    }

    private void fetchAndSetTickets(ConnectionModel connection, List<SpecificTrainRequest> ticketsToRequest) {
        List<ConnectionModel> potentialTickets = apiService
                .getSpecificTrains(Flux.fromIterable(ticketsToRequest))
                .onErrorResume(TrainNotFoundException.class, e -> Mono.empty())
                .collectList()
                .blockOptional()
                .orElse(List.of());

        System.out.println("Success on " + potentialTickets.size() + " tickets");

        double newPrice = potentialTickets.stream()
                .map(ConnectionModel::getAngebotsPreis)
                .mapToDouble(PriceModel::getBetrag)
                .sum();

        if (potentialTickets.size() == ticketsToRequest.size() && newPrice < connection.getAngebotsPreis().getBetrag()) {
            connection.setTickets(potentialTickets);
            connection.setTotalPrice(newPrice);
        }
    }

}
