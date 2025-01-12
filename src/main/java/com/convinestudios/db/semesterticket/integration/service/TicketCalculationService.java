package com.convinestudios.db.semesterticket.integration.service;

import com.convinestudios.db.semesterticket.integration.model.ConnectionModel;
import com.convinestudios.db.semesterticket.integration.model.internal.SearchRequest;
import com.convinestudios.db.semesterticket.integration.model.internal.SearchResponse;
import com.convinestudios.db.semesterticket.integration.service.request.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        List<ConnectionModel> initialData = getInitialData(searchRequest);

        // walk through all initial connections and calculate the best prices for them
        for (ConnectionModel connection: initialData) {
            findTickets(connection);
        }

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

    private void findTickets(ConnectionModel connection) {

    }

}
