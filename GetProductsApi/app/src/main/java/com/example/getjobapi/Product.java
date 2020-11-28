package com.example.getjobapi;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("ocpc")
    String ocpc;

    @SerializedName("name")
    String name;
}
