package com.example.getjobapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductList {
    @SerializedName("data")
    List<Product> products;
}
