package com.girish.patientintake;

public enum Doctor {
    AVERY("Ralph Avery"),
    JOHNSON("Beth Johnson"),
    MURPHY("Pat Murpy");

    private final String name;

    // Constructor to initialize the doctor's name
    Doctor(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Doctor's name cannot be null or blank.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}