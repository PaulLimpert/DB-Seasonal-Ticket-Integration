package com.convinestudios.db.semesterticket.integration.model.external;

public class HeaderModel {
    private String name;
    private String value;

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // Default Constructor

    public HeaderModel(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
