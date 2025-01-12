package com.convinestudios.db.semesterticket.integration.model.requests;

import com.convinestudios.db.semesterticket.integration.model.properties.Klasse;
import com.convinestudios.db.semesterticket.integration.model.properties.Passenger;
import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;

import java.time.LocalDateTime;
import java.util.List;

public record SpecificTrainRequest(String origin,
                                   String destination,
                                   LocalDateTime date,
                                   String name,
                                   Klasse klasse,
                                   List<Produktgattung> produktgattungen,
                                   List<Passenger> reisende,
                                   boolean bikeCarriage
                                   ) {

}
