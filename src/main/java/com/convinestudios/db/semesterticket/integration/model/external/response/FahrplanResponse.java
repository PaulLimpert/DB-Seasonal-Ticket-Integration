package com.convinestudios.db.semesterticket.integration.model.external.response;



import com.convinestudios.db.semesterticket.integration.model.ConnectionModel;

import java.util.List;

public class FahrplanResponse {
    private List<ConnectionModel> verbindungen;

    // Getter
    public List<ConnectionModel> getConnections() {
        return verbindungen;
    }
}
