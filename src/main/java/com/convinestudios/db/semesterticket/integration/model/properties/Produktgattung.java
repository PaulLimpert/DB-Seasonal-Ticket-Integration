package com.convinestudios.db.semesterticket.integration.model.properties;

public enum Produktgattung {
    ICE("ICE"),
    EC_IC("EC_IC"),
    IR("IR"),
    REGIONAL("REGIONAL"),
    SBAHN("SBAHN"),
    BUS("BUS"),
    SCHIFF("SCHIFF"),
    UBAHN("UBAHN"),
    TRAM("TRAM"),
    ANRUFPFLICHTIG("ANRUFPFLICHTIG");

    private String stringRep;

    Produktgattung(String stringRep){
        this.stringRep = stringRep;
    }

    public String getStringRep() {
        return stringRep;
    }
}
