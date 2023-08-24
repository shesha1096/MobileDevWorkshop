package com.shesha.mobiledevworkshop.sharedpreferencesapp.models;

public class CarEntry {
    private String make;
    private int year;
    private String model;

    // Constructors, getters, setters


    public CarEntry(String make, int year, String model) {
        this.make = make;
        this.year = year;
        this.model = model;
    }

    public CarEntry() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

