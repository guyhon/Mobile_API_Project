package com.example.fruitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.appsflyer.AppsFlyerLib;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.google.android.material.textview.MaterialTextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    FruitController fruitController;
    Button resetButton;
    Button sugarButton;
    Button proteinButton;
    Button caloriesButton;
   MaterialTextView sortBy;
    public static final String LOG_TAG = "AppsFlyerOneLinkSimApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AppsFlyerLib.getInstance().init("fb8Q2zo9PAxeMYGSwXo6Bo", null, this);
//        AppsFlyerLib.getInstance().start(this);
//        AppsFlyerLib.getInstance().setDebugLog(true);
        resetButton = findViewById(R.id.button_reset);
        sugarButton = findViewById(R.id.button_sugar);
        proteinButton = findViewById(R.id.button_protein);
        caloriesButton = findViewById(R.id.button_calories);
        recyclerView = findViewById(R.id.fruit_list);
        sortBy = findViewById(R.id.text_sort);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        fruitController = new FruitController(this, recyclerView);
        fruitController.fetchAllFruits();


//        Map<String, Object> eventValue = new HashMap<String, Object>();
//        eventValue.put("Sugar", sugarButton);
//        eventValue.put("Protein", proteinButton);
//        eventValue.put("Calories", caloriesButton);
//        eventValue.put("Reset", resetButton);
//        AppsFlyerLib.getInstance().logEvent(getApplicationContext(), "Button Clicked", eventValue);
//
//
//        AppsFlyerLib.getInstance().start(getApplicationContext(), "fb8Q2zo9PAxeMYGSwXo6Bo", new AppsFlyerRequestListener() {
//            @Override
//            public void onSuccess() {
//                Log.d(LOG_TAG, "Launch sent successfully, got 200 response code from server");
//            }
//
//            @Override
//            public void onError(int i, @NonNull String s) {
//                Log.d(LOG_TAG, "Launch failed to be sent:\n" +
//                        "Error code: " + i + "\n"
//                        + "Error description: " + s);
//            }
//        });




        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortBy.setText("Sort by: None");
                fruitController.fetchAllFruits();
            }
        });

        sugarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortBy.setText("Sort by: Sugar");
                fruitController.sort(1);
            }
        });

        proteinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortBy.setText("Sort by: Protein");
                fruitController.sort(2);
            }
        });

        caloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortBy.setText("Sort by: Calories");
                fruitController.sort(3);
            }
        });
    }

}