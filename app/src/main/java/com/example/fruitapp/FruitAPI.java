package com.example.fruitapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FruitAPI {

    @GET("api/fruit/all")
    Call<List<Fruit>> loadFruits();

}
