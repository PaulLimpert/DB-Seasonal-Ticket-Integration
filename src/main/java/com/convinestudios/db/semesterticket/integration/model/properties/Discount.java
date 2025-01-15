package com.convinestudios.db.semesterticket.integration.model.properties;

public class Discount {
    private final Bahncard art;
    private final Klasse klasse;

    // Default Constructor
    public Discount(Bahncard art, Klasse klasse) {
        this.art = art;
        this.klasse = klasse;
    }

    public Bahncard getArt() {
        return art;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    @Override
    public String toString() {
        return "Ermaessigung{" +
                "art=" + art +
                ", klasse=" + klasse +
                '}';
    }
}
