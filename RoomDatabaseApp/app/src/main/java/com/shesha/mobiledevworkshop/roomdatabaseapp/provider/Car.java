package com.shesha.mobiledevworkshop.roomdatabaseapp.provider;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cars")
public class Car {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "maker")
    String maker;

    @ColumnInfo(name = "model")
    String model;

    @ColumnInfo(name = "year")
    int year;

    @ColumnInfo(name = "color")
    String color;

    @ColumnInfo(name = "seats")
    int seats;

    @ColumnInfo(name = "price")
    double price;

    public Car(String maker, String model, int year, String color, int seats, double price) {
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.color = color;
        this.seats = seats;
        this.price = price;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getSeats() {
        return seats;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
