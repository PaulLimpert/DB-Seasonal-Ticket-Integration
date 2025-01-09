package com.convinestudios.db.semesterticket.integration.model;

public class PriceModel {
    private double betrag;
    private String waehrung;

    // Getter and Setter
    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public String getWaehrung() {
        return waehrung;
    }

    public void setWaehrung(String waehrung) {
        this.waehrung = waehrung;
    }

    // Default Constructor
    public PriceModel(double betrag, String waehrung) {
        this.betrag = betrag;
        this.waehrung = waehrung;
    }
}
