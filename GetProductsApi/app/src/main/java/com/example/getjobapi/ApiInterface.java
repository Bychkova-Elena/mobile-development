package com.example.getjobapi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("products")
    Observable<ProductList> products();

    @GET("products/{ocpc}")
    Observable<ProductDetail> product(@Path("ocpc") String ocpc);

}
