package com.rajendra.retrofittutorial.retrofit;

import com.rajendra.retrofittutorial.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("products.json")
    Call<List<Products>> getAllProduct();

}


