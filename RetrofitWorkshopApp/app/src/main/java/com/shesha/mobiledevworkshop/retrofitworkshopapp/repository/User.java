package com.shesha.mobiledevworkshop.retrofitworkshopapp.repository;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("name")
    private String name;

    @SerializedName("job")
    private String job;

    @SerializedName("id")
    private String id;

    @SerializedName("createdAt")
    private String createdAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
