package com.convinestudios.db.semesterticket.integration.validation.ticket.semesterticket;


import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;

public interface TransitPass {
    boolean validateStop(String station, Produktgattung type);          // Tests if the given Station is within the valid Area of the Semesterticket
}
