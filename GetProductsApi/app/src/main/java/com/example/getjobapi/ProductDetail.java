package com.example.getjobapi;

import com.google.gson.annotations.SerializedName;

public class ProductDetail {
    @SerializedName("ocpc")
    String ocpc;

    @SerializedName("name")
    String name;

    @SerializedName("type")
    String type;

    @SerializedName("description")
    String description;
}
