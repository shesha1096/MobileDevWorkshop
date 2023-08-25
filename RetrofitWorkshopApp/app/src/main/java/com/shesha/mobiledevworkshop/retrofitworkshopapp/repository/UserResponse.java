package com.shesha.mobiledevworkshop.retrofitworkshopapp.repository;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;
}
