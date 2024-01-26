package com.example.jcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FoodMenu extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        img1 = findViewById(R.id.foodMenu1);
        img2 = findViewById(R.id.foodMenu2);
        img3 = findViewById(R.id.foodMenu3);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodMenu.this,MarriageMenu.class));
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodMenu.this,PartyMenu.class));
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodMenu.this,MeetingMenu.class));
            }
        });
    }
}