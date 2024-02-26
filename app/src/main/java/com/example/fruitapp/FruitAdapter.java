package com.example.fruitapp;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.fruitViewHolder> {

    List<Fruit> fruitList;

    Context context;

    int sortType;

    public FruitAdapter(Context context, List<Fruit> fruitList, int sortType) {
        this.context = context;
        this.fruitList = fruitList;
        this.sortType = sortType;
    }

    @NonNull
    @Override
    public FruitAdapter.fruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false);
        return new fruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.fruitViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.name.setText(fruit.getName());
        holder.sugar.setText("Sugar: " + fruit.getNutritions().getSugar());
        holder.protein.setText("Protein: " + fruit.getNutritions().getProtein());
        holder.calories.setText("Calories: " + fruit.getNutritions().getCalories());

        if(sortType == 1)
            holder.sugar.setTypeface(null, Typeface.BOLD);
        else if (sortType == 2)
            holder.protein.setTypeface(null, Typeface.BOLD);
        else if (sortType == 3)
            holder.calories.setTypeface(null, Typeface.BOLD);
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }


    public class fruitViewHolder extends RecyclerView.ViewHolder {

        public MaterialTextView name;
        public MaterialTextView sugar;
        public MaterialTextView protein;
        public MaterialTextView calories;
        public fruitViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.fruit_name);
            sugar = itemView.findViewById(R.id.fruit_sugar);
            protein = itemView.findViewById(R.id.fruit_protein);
            calories = itemView.findViewById(R.id.fruit_calories);
        }
    }
}
