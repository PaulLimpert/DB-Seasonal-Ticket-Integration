package com.convinestudios.db.semesterticket.integration.validation.ticket;

import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;

public class DeutschlandTicket implements SeasonalTicket {
    @Override
    public boolean validateStop(String station, Produktgattung type) {
        if (type != Produktgattung.ICE && type != Produktgattung.EC_IC)
            return true;
        return false;
    }
}
