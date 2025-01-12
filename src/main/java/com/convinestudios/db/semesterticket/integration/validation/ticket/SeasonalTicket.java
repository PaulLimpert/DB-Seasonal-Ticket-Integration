package com.convinestudios.db.semesterticket.integration.validation.ticket;


import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;

public interface SeasonalTicket {
    boolean validateStop(String station, Produktgattung type);          // Tests if the given Station is within the valid Area of the Semesterticket
}
