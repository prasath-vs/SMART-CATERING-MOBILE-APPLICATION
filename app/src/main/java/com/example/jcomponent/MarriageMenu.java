package com.example.jcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MarriageMenu extends AppCompatActivity {

    ListView list;

    String[] maintitle ={
            "Rice","Sambar", "Aviyal", "Kootu", "Rasam", "Poriyal", " Appalam  ", "Thayir Saadam", "Vadai", "Payasam",
    };

    String[] subtitle ={
            "Rice is the staple food present in almost every meal consumed in Tamilnadu","Sambar is a lentil- based vegetable stew that is spicy and tangy",
            "Aviyal is a vegetable mix consisting mostly of sliced drumsticks, carrots, pumpkin, green beans, coconut oil, and curry leaves",
            "Kootu is a semi-solid lentil and vegetable stew made with a fresh coconut paste mixed with spices and vegetables",
            "Rasam is a spicy, sweet’ n sour soup stock traditionally prepared using tomato and tamarind as the base",
            "Poriyal is the ultimate vegetable side dish for any meal one can have in Tamilnadu",
            "Appalam is a thin, crisp, roughly round flatbread", "Yogurt (or curd) mixed with rice is known as Thayir Saadam in Tamilnadu",
            "Vadai is a savoury snack that is served hot. It is made from legumes like chickpea, black gram or green gram",
            "Payasam is a rice pudding made by boiling milk and sugar with rice along with dried fruits, almonds and cashew nuts",
    };

    Integer[] imgid={
            R.drawable.mf1,R.drawable.mf2, R.drawable.mf3, R.drawable.mf4, R.drawable.mf5, R.drawable.mf6, R.drawable.mf7,
            R.drawable.mf8, R.drawable.mf9, R.drawable.mf10,
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage_menu);
        setTitle("CustomListView");

        MarriageListview adapter=new MarriageListview(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener((parent, view, position, id) -> {
            // TODO Auto-generated method stub
            if(position == 0) {
                Toast.makeText(getApplicationContext(),"Rice Selected",Toast.LENGTH_SHORT).show();
            }

            else if(position == 1) {
                Toast.makeText(getApplicationContext(),"Sambar Selected",Toast.LENGTH_SHORT).show();
            }

            else if(position == 2) {

                Toast.makeText(getApplicationContext(),"Aviyal Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 3) {

                Toast.makeText(getApplicationContext(),"Kootu Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 4) {

                Toast.makeText(getApplicationContext(),"Rasam Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 5) {

                Toast.makeText(getApplicationContext(),"Poriyal Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 6) {

                Toast.makeText(getApplicationContext(),"Appalam Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 7) {

                Toast.makeText(getApplicationContext(),"Thayir Saadam Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 8) {

                Toast.makeText(getApplicationContext(),"Vadai Selected",Toast.LENGTH_SHORT).show();
            }
            else if(position == 9) {

                Toast.makeText(getApplicationContext(),"Payasam Selected",Toast.LENGTH_SHORT).show();
            }

        });
    }
}