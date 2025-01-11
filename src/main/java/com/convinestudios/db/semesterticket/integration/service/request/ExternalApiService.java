package com.convinestudios.db.semesterticket.integration.service.request;

import com.convinestudios.db.semesterticket.integration.exception.NoResponseException;
import com.convinestudios.db.semesterticket.integration.model.Stammdaten;
import com.convinestudios.db.semesterticket.integration.model.external.payload.FahrplanPayload;
import com.convinestudios.db.semesterticket.integration.model.external.response.FahrplanResponse;
import com.convinestudios.db.semesterticket.integration.model.external.response.FahrplanResponseMapper;
import com.convinestudios.db.semesterticket.integration.model.properties.AnkunftSuche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ExternalApiService {

    private final ExternalApiClient apiClient;

    @Autowired
    public ExternalApiService(ExternalApiClient defaultClientDB) {
        this.apiClient = defaultClientDB;
    }

    /**
     * A basic API request for a specific search of a Train connection from the Deutsche Bahn for a whole day
     *
     * @param stammdaten the "stammdaten" of the requesting user
     * @param origin point of departure
     * @param destination point of destination
     * @param date the whole day of search
     * @param ankunftSuche defines how date is treated, time of arrival or time of departure
     * @return a List containing all the matching connections
     * @throws NoResponseException
     */
    public FahrplanResponse getConnectionsByTime(Stammdaten stammdaten, String origin, String destination, LocalDateTime date, AnkunftSuche ankunftSuche) throws NoResponseException {

        // todo: add de-ticket

        FahrplanPayload payload = new FahrplanPayload(
                "A=1@O=" + origin,
                date,
                "A=1@O=" + destination,
                ankunftSuche,
                stammdaten.klasse(),
                stammdaten.maxUmstiege(),
                stammdaten.produktgattungen(),
                stammdaten.reisende(),
                stammdaten.schnelleVerbindungen(),
                stammdaten.sitzplatzOnly(),
                stammdaten.bikeCarriage(),
                stammdaten.reservierungsKontingenteVorhanden()
        );

        try {
            String jsonResponse = apiClient.post(payload.toJson())
                    .block(Duration.ofSeconds(10)); // Warte synchron auf die Antwort mit Timeout
            if (jsonResponse == null) {
                throw new NoResponseException("No response received from the API");
            }

            // Mappe die JSON-Antwort auf ConnectionModel
            return FahrplanResponseMapper.mapFromJson(jsonResponse);
        } catch (Exception e) {
            throw new NoResponseException("Failed to retrieve connections: " + e.getMessage(), e);
        }
    }
}

