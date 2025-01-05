package com.convinestudios.db.semesterticket.integration.model.internal.properties;

import java.util.List;

public class Passenger {
    private Typ typ;
    private List<Discount> ermaessigungen;
    private List<String> alter;
    private int anzahl;

    // Getter and Setter
    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public List<Discount> getErmaessigungen() {
        return ermaessigungen;
    }

    public void setErmaessigungen(List<Discount> ermaessigungen) {
        this.ermaessigungen = ermaessigungen;
    }

    public List<String> getAlter() {
        return alter;
    }

    public void setAlter(List<String> alter) {
        this.alter = alter;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    // Default Constructor
    public Passenger(Typ typ, List<Discount> ermaessigungen, List<String> alter, int anzahl) {
        this.typ = typ;
        this.ermaessigungen = ermaessigungen;
        this.alter = alter;
        this.anzahl = anzahl;
    }

    @Override
    public String toString() {
        return "Reisender{" +
                "typ=" + typ +
                ", ermaessigungen=" + ermaessigungen +
                ", alter=" + alter +
                ", anzahl=" + anzahl +
                '}';
    }
}
