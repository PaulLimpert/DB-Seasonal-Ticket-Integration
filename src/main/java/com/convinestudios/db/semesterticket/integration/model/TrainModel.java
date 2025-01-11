package com.convinestudios.db.semesterticket.integration.model;

import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;

public class TrainModel {
    private Produktgattung produktGattung;
    private String name;
    private String richtung;

    // Getter and Setter
    public Produktgattung getProduktGattung() {
        return produktGattung;
    }

    public void setProduktGattung(Produktgattung produktGattung) {
        this.produktGattung = produktGattung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRichtung() {
        return richtung;
    }

    public void setRichtung(String richtung) {
        this.richtung = richtung;
    }

    // Default Constructor
    public TrainModel(Produktgattung produktGattung, String name, String richtung) {
        this.produktGattung = produktGattung;
        this.name = name;
        this.richtung = richtung;
    }

    @Override
    public String toString() {
        return "Train{" +
                "produktGattung=" + produktGattung +
                ", name='" + name + '\'' +
                ", richtung='" + richtung + '\'' +
                '}';
    }
}
