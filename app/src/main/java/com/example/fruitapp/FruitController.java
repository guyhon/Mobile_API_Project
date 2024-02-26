package com.example.fruitapp;

import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FruitController implements Callback<List<Fruit>> {

    static final String BASE_URL = "https://www.fruityvice.com/";

    Context context;
    RecyclerView recyclerView;

    List<Fruit> fruitList;

    FruitAdapter fruitAdapter;



    public FruitController(Context context, RecyclerView recyclerView){
        this.context = context;
        this.recyclerView = recyclerView;
    }
    public void fetchAllFruits() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FruitAPI fruitAPI = retrofit.create(FruitAPI.class);

        Call<List<Fruit>> call = fruitAPI.loadFruits();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Fruit>> call, Response<List<Fruit>> response) {
        if (response.isSuccessful()) {
            fruitList = response.body();
            fruitAdapter = new FruitAdapter(context, fruitList, 0);
            recyclerView.setAdapter(fruitAdapter);
            int x = 0;
        } else {
            Log.d("pttt", "" + response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Fruit>> call, Throwable t) {
        t.printStackTrace();
    }

    public void sort(int typeSort) {
        if(typeSort == 1){
            fruitList.sort((a1, a2) -> {
                return a1.compareTo(1, a2);
            });
        } else if (typeSort == 2) {
            fruitList.sort((a1, a2) -> {
                return a1.compareTo(2, a2);
            });
        } else if (typeSort == 3) {
        fruitList.sort((a1, a2) -> {
            return a1.compareTo(3, a2);
        });
    }
        fruitAdapter = new FruitAdapter(context, fruitList, typeSort);
        recyclerView.setAdapter(fruitAdapter);
    }
}




