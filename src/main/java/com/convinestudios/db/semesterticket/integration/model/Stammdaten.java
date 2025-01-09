package com.convinestudios.db.semesterticket.integration.model;

import com.convinestudios.db.semesterticket.integration.model.properties.Klasse;
import com.convinestudios.db.semesterticket.integration.model.properties.Passenger;
import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;

import java.util.List;

public record Stammdaten(Klasse klasse,
                         int maxUmstiege,
                         List<Produktgattung> produktgattungen,
                         List<Passenger> reisende,
                         boolean schnelleVerbindungen,
                         boolean sitzplatzOnly,
                         boolean bikeCarriage,
                         boolean reservierungsKontingenteVorhanden) {
}
