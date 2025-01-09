package com.convinestudios.db.semesterticket.integration.model.properties;

public enum Bahncard {
    KEINE_ERMAESSIGUNG("KEINE_ERMAESSIGUNG"),
    BAHNCARD25("BAHNCARD25"),
    BAHNCARDBUSINESS25("BAHNCARDBUSINESS25"),
    BAHNCARD50("BAHNCARD50"),
    BAHNCARDBUSINESS50("BAHNCARDBUSINESS50"),
    BAHNCARD100("BAHNCARD100");

    private String stringRep;

    Bahncard(String stringRep){
        this.stringRep = stringRep;
    }

    public String getStringRep() {
        return stringRep;
    }
}