package com.convinestudios.db.semesterticket.integration.model.requests;

import com.convinestudios.db.semesterticket.integration.model.properties.AnkunftSuche;
import com.convinestudios.db.semesterticket.integration.model.properties.Klasse;
import com.convinestudios.db.semesterticket.integration.model.properties.Passenger;
import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;

import java.time.LocalDateTime;
import java.util.List;

public record StandardRequest(String origin,
                              String destination,
                              LocalDateTime time,
                              AnkunftSuche ankunftSuche,
                              Klasse klasse,
                              int maxUmstiege,
                              List<Produktgattung> produktgattungen,
                              List<Passenger> reisende,
                              boolean schnelleVerbindungen,
                              boolean sitzplatzOnly,
                              boolean bikeCarriage,
                              boolean reservierungsKontingenteVorhanden) {

}
