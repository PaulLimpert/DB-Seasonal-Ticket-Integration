package com.convinestudios.db.semesterticket.integration.model.internal.properties;

public enum Typ {
    KLEINKIND("KLEINKIND"),         // Kind (0-5)
    FAMILIENKIND("FAMILIENKIND"),   // Kind (6-14)
    JUGENDLICHER("JUGENDLICHER"),   // Person (15-26)
    ERWACHSENER("ERWACHSENER"),     // Person (27-64)
    SENIOR("SENIOR");               // Person (ab 65)

    private String stringRep;

    Typ(String stringRep){
        this.stringRep = stringRep;
    }

    public String getStringRep() {
        return stringRep;
    }
}
