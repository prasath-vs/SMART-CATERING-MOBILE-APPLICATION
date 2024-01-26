package com.example.jcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class PartyMenu extends AppCompatActivity {

    ListView list;

    String[] maintitle ={
            "Meatballs","Potato Skins", "Sausage Rolls", "Chocolate Truffles", "Chicken Empanadas",
            "Steak and Cheese Quesadilla", "Chicken Tenders", "Brownies", "Croquettes", "Vodka Jello Shots",
    };

    String[] subtitle ={
            "Combining both beef and pork, these meatballs are perfectly tender and moist",
            "Russet potato halves loaded with cheese and bacon, baked until fluffy and tender",
            "The secret to this phenomenal recipe is the ground pork mixed with bacon",
            "These homemade truffles are incredibly smooth, indulgent, and highly addictive!",
            "You have perfectly seasoned meat filling wrapped in a flaky and buttery crust which is then deep fried until golden",
            "Tender beef and melted cheese wrapped in a toasted soft tortilla",
            "Flavorful meat that’s crisp on the outside and juicy on the inside",
            "It’s sweet, but not too overpowering. The consistency is crisp on the edges and fudgy in the center!",
            "Croquettes are deep fried balls made of mashed potatoes and bacon with a melted cheese filling",
            "These vodka jello shots are tasty and will give just the right amount of buzz to your guests",
    };

    Integer[] imgid={
            R.drawable.pf1,R.drawable.pf2, R.drawable.pf3, R.drawable.pf4, R.drawable.pf5, R.drawable.pf6, R.drawable.pf7,
            R.drawable.pf8, R.drawable.pf9, R.drawable.pf10,
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_menu);
        setTitle("CustomListView");

        MarriageListview adapter=new MarriageListview(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener((parent, view, position, id) -> {
            // TODO Auto-generated method stub
            if(position == 0) {
                Toast.makeText(getApplicationContext(),"Meatballs Selected",Toast.LENGTH_SHORT).show();
            }

            else if(position == 1) {
                Toast.makeText(getApplicationContext(),"Potato Skins Selected",Toast.LENGTH_SHORT).show();
            }

            else if(position == 2) {

                Toast.makeText(getApplicationContext(),"Sausage Rolls Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 3) {

                Toast.makeText(getApplicationContext(),"Chocolate Truffles Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 4) {

                Toast.makeText(getApplicationContext(),"Chicken Empanadas Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 5) {

                Toast.makeText(getApplicationContext(),"Steak and Cheese Quesadilla Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 6) {

                Toast.makeText(getApplicationContext(),"Chicken Tenders Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 7) {

                Toast.makeText(getApplicationContext(),"Brownies Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 8) {

                Toast.makeText(getApplicationContext(),"Croquettes Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 9) {

                Toast.makeText(getApplicationContext(),"Vodka Jello Shots Selected",Toast.LENGTH_SHORT).show();
            }

        });
    }
}