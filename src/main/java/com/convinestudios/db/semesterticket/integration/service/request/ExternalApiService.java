package com.convinestudios.db.semesterticket.integration.service.request;

import com.convinestudios.db.semesterticket.integration.exception.NoResponseException;
import com.convinestudios.db.semesterticket.integration.model.ConnectionModel;
import com.convinestudios.db.semesterticket.integration.model.StandardRequest;
import com.convinestudios.db.semesterticket.integration.model.external.payload.FahrplanPayload;
import com.convinestudios.db.semesterticket.integration.model.external.response.FahrplanResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

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
     * @param connectionData the data about the requested connection
     * @return a List containing all the matching connections
     * @throws NoResponseException
     */
    public List<ConnectionModel> getConnectionsByTime(StandardRequest connectionData) {

        // todo: add de-ticket

        FahrplanPayload payload = new FahrplanPayload(
                connectionData.origin(),
                connectionData.time(),
                connectionData.destination(),
                connectionData.ankunftSuche(),
                connectionData.klasse(),
                connectionData.maxUmstiege(),
                connectionData.produktgattungen(),
                connectionData.reisende(),
                connectionData.schnelleVerbindungen(),
                connectionData.sitzplatzOnly(),
                connectionData.bikeCarriage(),
                connectionData.reservierungsKontingenteVorhanden()
        );

        try {
            // todo: handle exceptions right (GlobalExceptionHandler)
            String jsonResponse = apiClient.post(payload.toJson())
                    .block(Duration.ofSeconds(10)); // Warte synchron auf die Antwort mit Timeout
            if (jsonResponse == null) {
                throw new NoResponseException("No response received from the API");
            }

            // Mappe die JSON-Antwort auf ConnectionModel
            return FahrplanResponseMapper.mapFromJson(jsonResponse).getConnections();
        } catch (Exception e) {
            throw new NoResponseException("Failed to retrieve connections: " + e.getMessage(), e);
        }
    }

}

