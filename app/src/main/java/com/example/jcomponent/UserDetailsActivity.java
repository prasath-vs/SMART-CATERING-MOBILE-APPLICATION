package com.example.jcomponent;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserDetailsActivity extends AppCompatActivity {

    EditText userName;
    EditText eventName;
    EditText numberOfPeople;
    EditText duration;
    Button btnSubmit;
    Button btnEstimation;
    ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        userName = findViewById(R.id.userName);
        eventName = findViewById(R.id.eventName);
        numberOfPeople = findViewById(R.id.numberOfPeople);
        duration = findViewById(R.id.duration);
        btnSubmit = findViewById(R.id.submit);
        btnEstimation = findViewById(R.id.btnEstimation);
        progressDialog = new ProgressDialog(this);


        btnEstimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserDetailsActivity.this,EstimationActivity.class);
                startActivity(i);
            }
        });

        btnSubmit.setOnClickListener(view -> {
            String getUserName = userName.getText().toString();
            String getEventName = eventName.getText().toString();
            String getNumberOfPeople = numberOfPeople.getText().toString();
            String getDuration = duration.getText().toString();

            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("userName", getUserName);
            hashMap.put("eventName", getEventName);
            hashMap.put("numberOfPeople", getNumberOfPeople);
            hashMap.put("duration", getDuration);

            databaseReference.child("Users")
                    .child(getUserName)
                    .setValue(hashMap)
                    .addOnSuccessListener(unused -> {
                        progressDialog.setMessage("Moving to Estimation...");
                        progressDialog.show();
                        Toast.makeText(UserDetailsActivity.this, "Data Added Successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserDetailsActivity.this, EstimationActivity.class);
                        startActivity(intent);

                    })
                    .addOnFailureListener(e -> Toast.makeText(UserDetailsActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show());
        });
    }
}