package com.convinestudios.db.semesterticket.integration.model.internal;

import com.convinestudios.db.semesterticket.integration.model.StandardRequest;
import com.convinestudios.db.semesterticket.integration.model.properties.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SearchRequest {

    // HTTP-Request specific data
    @NotNull(message = "API-Key is required for using this application and therefore cant be null")
    @JsonProperty("API_KEY")
    private String API_KEY;

    private LocalDateTime timeOfRequest;

    // Trip specific data
    @NotNull(message = "Search mode cant be null")
    private SearchMode searchMode;

    @NotNull(message = "Origin cant be null")
    private String origin;

    @NotNull(message = "Destination cant be null")
    private String destination;

    // Optional depending on SearchType
    private LocalDateTime specificTime; // For STANDARD-Search
    private LocalDate specificDay;      // For DAILY-Search
    private LocalDate fromDate;         // For PERIODIC-Search
    private LocalDate toDate;           // For PERIODIC-Search

    @NotNull(message = "Klasse cant be null")
    private Klasse klasse;

    @NotNull(message = "schnelleVerbindungen cant be null")
    private boolean schnelleVerbindungen;

    @NotNull(message = "ankunftSuche cant be null")
    private AnkunftSuche ankunftSuche;

    @NotNull(message = "Passengers cant be null")
    private List<Passenger> passengers;

    @NotNull(message = "nurDeutschlandTicketVerbindungen cant be null")
    private boolean nurDeutschlandTicketVerbindungen;

    @NotNull(message = "produktgattungen cant be null")
    private List<Produktgattung> produktgattungen;

    private int maxUmstiege;


    // With maxUmstiege
    public SearchRequest(String API_KEY, LocalDateTime timeOfRequest, SearchMode searchMode, String origin, String destination, LocalDateTime specificTime, LocalDate specificDay, LocalDate fromDate, LocalDate toDate, Klasse klasse, boolean schnelleVerbindungen, AnkunftSuche ankunftSuche, List<Passenger> passengers, boolean nurDeutschlandTicketVerbindungen, List<Produktgattung> produktgattungen, int maxUmstiege) {
        this.API_KEY = API_KEY;
        this.timeOfRequest = timeOfRequest;
        this.searchMode = searchMode;
        this.origin = origin;
        this.destination = destination;
        this.specificTime = specificTime;
        this.specificDay = specificDay;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.klasse = klasse;
        this.schnelleVerbindungen = schnelleVerbindungen;
        this.ankunftSuche = ankunftSuche;
        this.passengers = passengers;
        this.nurDeutschlandTicketVerbindungen = nurDeutschlandTicketVerbindungen;
        this.produktgattungen = produktgattungen;
        this.maxUmstiege = maxUmstiege;
    }

    // Without maxUmstiege
    public SearchRequest(String API_KEY, LocalDateTime timeOfRequest, SearchMode searchMode, String origin, String destination, LocalDateTime specificTime, LocalDate specificDay, LocalDate fromDate, LocalDate toDate, Klasse klasse, boolean schnelleVerbindungen, AnkunftSuche ankunftSuche, List<Passenger> passengers, boolean nurDeutschlandTicketVerbindungen, List<Produktgattung> produktgattungen) {
        this.API_KEY = API_KEY;
        this.timeOfRequest = timeOfRequest;
        this.searchMode = searchMode;
        this.origin = origin;
        this.destination = destination;
        this.specificTime = specificTime;
        this.specificDay = specificDay;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.klasse = klasse;
        this.schnelleVerbindungen = schnelleVerbindungen;
        this.ankunftSuche = ankunftSuche;
        this.passengers = passengers;
        this.nurDeutschlandTicketVerbindungen = nurDeutschlandTicketVerbindungen;
        this.produktgattungen = produktgattungen;
    }

    public SearchRequest() {}

    public StandardRequest extractConnectionData() {
        return new StandardRequest(
                getOrigin(),
                getDestination(),
                getSpecificTime(),
                getAnkunftSuche(),
                getKlasse(),
                getMaxUmstiege(),
                getProduktgattungen(),
                getPassengers(),
                isSchnelleVerbindungen(),
                false,
                false,
                false
        );
    }

    public String getAPI_KEY() {
        return API_KEY;
    }

    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public LocalDateTime getTimeOfRequest() {
        return timeOfRequest;
    }

    public void setTimeOfRequest(LocalDateTime timeOfRequest) {
        this.timeOfRequest = timeOfRequest;
    }

    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = klasse;
    }

    public boolean isSchnelleVerbindungen() {
        return schnelleVerbindungen;
    }

    public void setSchnelleVerbindungen(boolean schnelleVerbindungen) {
        this.schnelleVerbindungen = schnelleVerbindungen;
    }

    public SearchMode getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(SearchMode searchMode) {
        this.searchMode = searchMode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getSpecificTime() {
        return specificTime;
    }

    public void setSpecificTime(LocalDateTime specificTime) {
        this.specificTime = specificTime;
    }

    public LocalDate getSpecificDay() {
        return specificDay;
    }

    public void setSpecificDay(LocalDate specificDay) {
        this.specificDay = specificDay;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public AnkunftSuche getAnkunftSuche() {
        return ankunftSuche;
    }

    public void setAnkunftSuche(AnkunftSuche ankunftSuche) {
        this.ankunftSuche = ankunftSuche;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public boolean isNurDeutschlandTicketVerbindungen() {
        return nurDeutschlandTicketVerbindungen;
    }

    public void setNurDeutschlandTicketVerbindungen(boolean nurDeutschlandTicketVerbindungen) {
        this.nurDeutschlandTicketVerbindungen = nurDeutschlandTicketVerbindungen;
    }

    public List<Produktgattung> getProduktgattungen() {
        return produktgattungen;
    }

    public void setProduktgattungen(List<Produktgattung> produktgattungen) {
        this.produktgattungen = produktgattungen;
    }

    public int getMaxUmstiege() {
        return maxUmstiege;
    }

    public void setMaxUmstiege(int maxUmstiege) {
        this.maxUmstiege = maxUmstiege;
    }
}
