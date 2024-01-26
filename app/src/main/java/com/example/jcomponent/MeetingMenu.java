package com.example.jcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MeetingMenu extends AppCompatActivity {

    ListView list;

    String[] maintitle ={
            "Sandwich","Salad", "Pasta", "Kettle chips", "Fresh fruit", "Veggies", "Wings",
            "Pizza", "Desserts", "Light refreshment beverages",
    };

    String[] subtitle ={
            "A sandwich is a food typically consisting of vegetables, sliced cheese or meat, placed on or between slices of bread",
            "A salad is a dish consisting of mixed, mostly natural ingredients",
            "Pasta is a type of food typically made from an unleavened dough of wheat flour mixed with water or eggs",
            "It is Kettle cooked potato chips with Thick cut slices of potato, Great crunch, Free from gluten and Free from artificial coloring",
            "Different Fruits",
            "Different Vegetables",
            "A Buffalo wing in American cuisine is an unbreaded chicken wing section that is generally deep-fried",
            "Pizza is a dish of Italian origin consisting of a usually round, flat base of leavened wheat-based dough topped with tomatoes, cheese",
            "Brownies are a good dessert",
            "Non - alcoholic beverages and edible items commonly served between meals, but not intended to substitute for meals",
    };

    Integer[] imgid={
            R.drawable.bf1,R.drawable.bf2, R.drawable.bf3, R.drawable.bf4, R.drawable.bf5, R.drawable.bf6, R.drawable.bf7,
            R.drawable.bf8, R.drawable.bf9, R.drawable.bf10,
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_menu);
        setTitle("CustomListView");

        MarriageListview adapter=new MarriageListview(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener((parent, view, position, id) -> {
            // TODO Auto-generated method stub
            if(position == 0) {
                Toast.makeText(getApplicationContext(),"Sandwich Selected",Toast.LENGTH_SHORT).show();
            }

            else if(position == 1) {
                Toast.makeText(getApplicationContext(),"Salad Selected",Toast.LENGTH_SHORT).show();
            }

            else if(position == 2) {

                Toast.makeText(getApplicationContext(),"Pasta Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 3) {

                Toast.makeText(getApplicationContext(),"Kettle chips Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 4) {

                Toast.makeText(getApplicationContext(),"Fresh fruit Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 5) {

                Toast.makeText(getApplicationContext(),"Veggies Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 6) {

                Toast.makeText(getApplicationContext(),"Wings Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 7) {

                Toast.makeText(getApplicationContext(),"Pizza Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 8) {

                Toast.makeText(getApplicationContext(),"Desserts Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 9) {

                Toast.makeText(getApplicationContext(),"Light refreshment beverages Selected",Toast.LENGTH_SHORT).show();
            }

        });
    }
}