package com.convinestudios.db.semesterticket.integration.model.external.payload;


import com.convinestudios.db.semesterticket.integration.model.properties.AnkunftSuche;
import com.convinestudios.db.semesterticket.integration.model.properties.Klasse;
import com.convinestudios.db.semesterticket.integration.model.properties.Passenger;
import com.convinestudios.db.semesterticket.integration.model.properties.Produktgattung;

import java.time.LocalDateTime;
import java.util.List;

public class FahrplanPayload implements Payload{
    private String abfahrtsHalt;
    private LocalDateTime anfrageZeitpunkt;
    private String ankunftsHalt;
    private AnkunftSuche ankunftSuche;
    private Klasse klasse;
    private int maxUmstiege;
    private List<Produktgattung> produktgattungen;
    private List<Passenger> reisende;
    private boolean schnelleVerbindungen;
    private boolean sitzplatzOnly;
    private boolean bikeCarriage;
    private boolean reservierungsKontingenteVorhanden;

    // Getter and Setter
    public String getAbfahrtsHalt() {
        return abfahrtsHalt;
    }

    public void setAbfahrtsHalt(String abfahrtsHalt) {
        this.abfahrtsHalt = abfahrtsHalt;
    }

    public LocalDateTime getAnfrageZeitpunkt() {
        return anfrageZeitpunkt;
    }

    public void setAnfrageZeitpunkt(LocalDateTime anfrageZeitpunkt) {
        this.anfrageZeitpunkt = anfrageZeitpunkt;
    }

    public String getAnkunftsHalt() {
        return ankunftsHalt;
    }

    public void setAnkunftsHalt(String ankunftsHalt) {
        this.ankunftsHalt = ankunftsHalt;
    }

    public AnkunftSuche getAnkunftSuche() {
        return ankunftSuche;
    }

    public void setAnkunftSuche(AnkunftSuche ankunftSuche) {
        this.ankunftSuche = ankunftSuche;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public int getMaxUmstiege() {
        return maxUmstiege;
    }

    public void setMaxUmstiege(int maxUmstiege) {
        this.maxUmstiege = maxUmstiege;
    }

    public List<Produktgattung> getProduktgattungen() {
        return produktgattungen;
    }

    public void setProduktgattungen(List<Produktgattung> produktgattungen) {
        this.produktgattungen = produktgattungen;
    }

    public List<Passenger> getReisende() {
        return reisende;
    }

    public void setReisende(List<Passenger> reisende) {
        this.reisende = reisende;
    }

    public boolean isSchnelleVerbindungen() {
        return schnelleVerbindungen;
    }

    public void setSchnelleVerbindungen(boolean schnelleVerbindungen) {
        this.schnelleVerbindungen = schnelleVerbindungen;
    }

    public boolean isSitzplatzOnly() {
        return sitzplatzOnly;
    }

    public void setSitzplatzOnly(boolean sitzplatzOnly) {
        this.sitzplatzOnly = sitzplatzOnly;
    }

    public boolean isBikeCarriage() {
        return bikeCarriage;
    }

    public void setBikeCarriage(boolean bikeCarriage) {
        this.bikeCarriage = bikeCarriage;
    }

    public boolean isReservierungsKontingenteVorhanden() {
        return reservierungsKontingenteVorhanden;
    }

    public void setReservierungsKontingenteVorhanden(boolean reservierungsKontingenteVorhanden) {
        this.reservierungsKontingenteVorhanden = reservierungsKontingenteVorhanden;
    }


    // Default Constructor
    public FahrplanPayload(String abfahrtsHalt, LocalDateTime anfrageZeitpunkt, String ankunftsHalt, AnkunftSuche ankunftSuche, Klasse klasse, int maxUmstiege, List<Produktgattung> produktgattungen, List<Passenger> reisende, boolean schnelleVerbindungen, boolean sitzplatzOnly, boolean bikeCarriage, boolean reservierungsKontingenteVorhanden) {
        this.abfahrtsHalt = abfahrtsHalt;
        this.anfrageZeitpunkt = anfrageZeitpunkt;
        this.ankunftsHalt = ankunftsHalt;
        this.ankunftSuche = ankunftSuche;
        this.klasse = klasse;
        this.maxUmstiege = maxUmstiege;
        this.produktgattungen = produktgattungen;
        this.reisende = reisende;
        this.schnelleVerbindungen = schnelleVerbindungen;
        this.sitzplatzOnly = sitzplatzOnly;
        this.bikeCarriage = bikeCarriage;
        this.reservierungsKontingenteVorhanden = reservierungsKontingenteVorhanden;
    }

    @Override
    public String toJson() {
        return FahrplanPayloadMapper.stringRep(this);
    }
}
