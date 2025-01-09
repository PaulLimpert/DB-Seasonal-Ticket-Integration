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

    public List<ConnectionModel> getConnectionsByTime(Stammdaten stammdaten, String origin, String destination, LocalDateTime date, AnkunftSuche ankunftSuche) throws NoResponseException {

    }

}
