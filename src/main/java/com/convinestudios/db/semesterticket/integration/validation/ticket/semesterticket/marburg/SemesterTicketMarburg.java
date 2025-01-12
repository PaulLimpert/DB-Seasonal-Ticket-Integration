package com.convinestudios.db.semesterticket.integration.validation.ticket.semesterticket.marburg;

import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;
import com.convinestudios.db.semesterticket.integration.validation.ticket.semesterticket.TransitPass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

// todo retrieve the current stops from a database
public class SemesterTicketMarburg implements TransitPass {
    private static final String PATH = "src/main/resources/tickets/umr/ticketsstations_hessen_plus.json";
    private Map<String, List<Produktgattung>> stations;

    private static final boolean DE_TICKET = true;

    // Constructor
    public SemesterTicketMarburg(){
        loadStations();
    }

    /**
     * Helper method for loading the stations information from the associated json
     */
    private void loadStations(){
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<Produktgattung>>>(){}.getType();

        try {
            FileReader reader = new FileReader(PATH);
            stations = gson.fromJson(reader, mapType);
        } catch (FileNotFoundException e) {
            System.err.println("Problem with loading the semesterticket information: " + e.getMessage());
        }
    }

    @Override
    public boolean validateStop(String station, Produktgattung type) {
        if (DE_TICKET && (type == Produktgattung.REGIONAL || type == Produktgattung.BUS || type == Produktgattung.SBAHN || type == Produktgattung.UBAHN || type == Produktgattung.IR))
            return true;
        return stations.containsKey(station) && stations.get(station).contains(type) ? true : false;
    }
}
