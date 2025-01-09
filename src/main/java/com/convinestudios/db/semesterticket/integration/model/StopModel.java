package com.convinestudios.db.semesterticket.integration.model;

import java.time.LocalDateTime;

public class StopModel {
    private LocalDateTime abfahrtsZeitpunkt;
    private String gleis;
    private String name;

    // Getter
    public LocalDateTime getAbfahrtsZeitpunkt() {
        return abfahrtsZeitpunkt;
    }

    public String getGleis() {
        return gleis;
    }

    public String getName() {
        return name;
    }
}
