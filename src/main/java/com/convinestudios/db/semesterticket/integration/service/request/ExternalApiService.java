package com.convinestudios.db.semesterticket.integration.service.request;

import com.convinestudios.db.semesterticket.integration.exception.NoResponseException;
import com.convinestudios.db.semesterticket.integration.model.ConnectionModel;
import com.convinestudios.db.semesterticket.integration.model.Stammdaten;
import com.convinestudios.db.semesterticket.integration.model.properties.AnkunftSuche;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExternalApiService {

    // todo: use ExternalApiClient bean with the api credentials from the resources

    /**
     * A basic API request for a specific search of an Train connection from the Deutsche Bahn for a whole day
     *
     * @param stammdaten the "stammdaten" of the requesting user
     * @param origin point of departure
     * @param destination point of destination
     * @param date the whole day of search
     * @param ankunftSuche defines how date is treated, time of arrival or time of departure
     * @return a List containing all the matching connections
     * @throws NoResponseException
     */
    public List<ConnectionModel> getConnectionsByTime(Stammdaten stammdaten, String origin, String destination, LocalDateTime date, AnkunftSuche ankunftSuche) throws NoResponseException {

    }

}
