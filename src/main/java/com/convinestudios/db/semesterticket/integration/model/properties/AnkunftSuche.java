package com.convinestudios.db.semesterticket.integration.model.properties;

public enum AnkunftSuche {
    ABFAHRT("ABFAHRT"),
    ANKUNFT("ANKUNFT");

    private String stringRep;

    AnkunftSuche(String stringRep){
        this.stringRep = stringRep;
    }

    public String getStringRep() {
        return stringRep;
    }
}