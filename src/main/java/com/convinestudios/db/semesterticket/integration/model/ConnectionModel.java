package com.convinestudios.db.semesterticket.integration.model;

import java.util.List;

public class ConnectionModel {
    private String tripId;
    private List<SectionsModel> verbindungsAbschnitte;
    private int umstiegsAnzahl;
    private int verbindungsDauerInSeconds;
    private PriceModel angebotsPreis;

    // For the Price calculation
    private List<ConnectionModel> tickets;
    private double totalPrice;


    // Getter and Setter
    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public List<SectionsModel> getSections() {
        return verbindungsAbschnitte;
    }

    public void setSections(List<SectionsModel> verbindungsAbschnitte) {
        this.verbindungsAbschnitte = verbindungsAbschnitte;
    }

    public int getUmstiegsAnzahl() {
        return umstiegsAnzahl;
    }

    public void setUmstiegsAnzahl(int umstiegsAnzahl) {
        this.umstiegsAnzahl = umstiegsAnzahl;
    }

    public int getVerbindungsDauerInSeconds() {
        return verbindungsDauerInSeconds;
    }

    public void setVerbindungsDauerInSeconds(int verbindungsDauerInSeconds) {
        this.verbindungsDauerInSeconds = verbindungsDauerInSeconds;
    }

    public PriceModel getAngebotsPreis() {
        return angebotsPreis;
    }

    public void setAngebotsPreis(PriceModel angebotsPreis) {
        this.angebotsPreis = angebotsPreis;
    }

    public List<ConnectionModel> getTickets() {
        return tickets;
    }

    public void setTickets(List<ConnectionModel> tickets) {
        this.tickets = tickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    // Default Constructor
    public ConnectionModel(String tripId, List<SectionsModel> verbindungsAbschnitte, int umstiegsAnzahl, int verbindungsDauerInSeconds, PriceModel angebotsPreis) {
        this.tripId = tripId;
        this.verbindungsAbschnitte = verbindungsAbschnitte;
        this.umstiegsAnzahl = umstiegsAnzahl;
        this.verbindungsDauerInSeconds = verbindungsDauerInSeconds;
        this.angebotsPreis = angebotsPreis;
    }
}
