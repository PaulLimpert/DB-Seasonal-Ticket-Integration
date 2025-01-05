package com.convinestudios.db.semesterticket.integration.model.internal.properties;

public enum Klasse {
    KLASSENLOS("KLASSENLOS"),
    KLASSE_1("KLASSE_1"),
    KLASSE_2("KLASSE_2");

    private String stringRep;

    Klasse(String stringRep){
        this.stringRep = stringRep;
    }

    public String getStringRep() {
        return stringRep;
    }
}
