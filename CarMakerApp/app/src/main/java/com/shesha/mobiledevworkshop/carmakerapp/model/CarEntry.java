package com.shesha.mobiledevworkshop.carmakerapp.model;

public class CarEntry {

    private String company;
    private String model;
    private String year;

    public CarEntry() {
    }

    public CarEntry(String company, String model, String year) {
        this.company = company;
        this.model = model;
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
