package com.convinestudios.db.semesterticket.integration.model;


import java.time.LocalDateTime;
import java.util.List;

public class SectionsModel {
    private LocalDateTime abfahrtsZeitpunkt;
    private String abfahrtsOrt;
    private int abschnittsDauer;            // In seconds
    private double abschnittsAnteil;        // In percent
    private LocalDateTime ankunftsZeitpunkt;
    private String ankunftsOrt;
    private List<StopModel> halte;
    private TrainModel verkehrsmittel;

    // Getter and Setter
    public LocalDateTime getAbfahrtsZeitpunkt() {
        return abfahrtsZeitpunkt;
    }

    public void setAbfahrtsZeitpunkt(LocalDateTime abfahrtsZeitpunkt) {
        this.abfahrtsZeitpunkt = abfahrtsZeitpunkt;
    }

    public String getAbfahrtsOrt() {
        return abfahrtsOrt;
    }

    public void setAbfahrtsOrt(String abfahrtsOrt) {
        this.abfahrtsOrt = abfahrtsOrt;
    }

    public int getAbschnittsDauer() {
        return abschnittsDauer;
    }

    public void setAbschnittsDauer(int abschnittsDauer) {
        this.abschnittsDauer = abschnittsDauer;
    }

    public double getAbschnittsAnteil() {
        return abschnittsAnteil;
    }

    public void setAbschnittsAnteil(double abschnittsAnteil) {
        this.abschnittsAnteil = abschnittsAnteil;
    }

    public LocalDateTime getAnkunftsZeitpunkt() {
        return ankunftsZeitpunkt;
    }

    public void setAnkunftsZeitpunkt(LocalDateTime ankunftsZeitpunkt) {
        this.ankunftsZeitpunkt = ankunftsZeitpunkt;
    }

    public String getAnkunftsOrt() {
        return ankunftsOrt;
    }

    public void setAnkunftsOrt(String ankunftsOrt) {
        this.ankunftsOrt = ankunftsOrt;
    }

    public List<StopModel> getStops() {
        return halte;
    }

    public void setStops(List<StopModel> halte) {
        this.halte = halte;
    }

    public TrainModel getVerkehrsmittel() {
        return verkehrsmittel;
    }

    public void setVerkehrsmittel(TrainModel verkehrsmittel) {
        this.verkehrsmittel = verkehrsmittel;
    }

    // Default Constructor
    public SectionsModel(LocalDateTime abfahrtsZeitpunkt, String abfahrtsOrt, int abschnittsDauer, double abschnittsAnteil, LocalDateTime ankunftsZeitpunkt, String ankunftsOrt, List<StopModel> halte, TrainModel verkehrsmittel) {
        this.abfahrtsZeitpunkt = abfahrtsZeitpunkt;
        this.abfahrtsOrt = abfahrtsOrt;
        this.abschnittsDauer = abschnittsDauer;
        this.abschnittsAnteil = abschnittsAnteil;
        this.ankunftsZeitpunkt = ankunftsZeitpunkt;
        this.ankunftsOrt = ankunftsOrt;
        this.halte = halte;
        this.verkehrsmittel = verkehrsmittel;
    }

    @Override
    public String toString() {
        return "SectionsModel{" +
                "abfahrtsZeitpunkt=" + abfahrtsZeitpunkt +
                ", abfahrtsOrt='" + abfahrtsOrt + '\'' +
                ", abschnittsDauer=" + abschnittsDauer +
                ", abschnittsAnteil=" + abschnittsAnteil +
                ", ankunftsZeitpunkt=" + ankunftsZeitpunkt +
                ", ankunftsOrt='" + ankunftsOrt + '\'' +
                ", halte=" + halte +
                ", verkehrsmittel=" + verkehrsmittel +
                '}';
    }
}
