package com.example.jcomponent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EstimationActivity extends AppCompatActivity {

    EditText username;
    TextView estimatedCost;
    TextView numberOfServants;
    TextView totalAmount;
    TextView advanceAmount;
    Button btnPay;
    Button btnAdvance;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimation);

        username = findViewById(R.id.getUserName);
        estimatedCost = findViewById(R.id.estimatedCost);
        numberOfServants = findViewById(R.id.numberOfServants);
        advanceAmount = findViewById(R.id.advanceAmount);
        btnPay = findViewById(R.id.btnPay);
        btnAdvance = findViewById(R.id.btnPayAdvance);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = username.getText().toString();
                if(!userName.isEmpty()){
                    readData(userName);
                }
                else {
                    Toast.makeText(EstimationActivity.this, "Please Enter a Username", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EstimationActivity.this,PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void readData(String userName) {

        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(userName).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if(task.isSuccessful()){

                    if(task.getResult().exists()){

                    Toast.makeText(EstimationActivity.this, "Successfully Read!", Toast.LENGTH_SHORT).show();
                    DataSnapshot dataSnapshot = task.getResult();
                    String duration = String.valueOf(dataSnapshot.child("duration").getValue());
                    String numberOfPeople = String.valueOf(dataSnapshot.child("numberOfPeople").getValue());

                    int newDuration = Integer.valueOf(duration);
                    int newPeople = Integer.valueOf(numberOfPeople);

                    int numberOfServant = newPeople/20;
                    int totalCost = newPeople*75;
                    int advanceCost = (int) (totalCost*0.25);

                    estimatedCost.setText("Total Cost = "+Integer.toString(totalCost));
                    numberOfServants.setText("No. of Servants = "+Integer.toString(numberOfServant));
                    advanceAmount.setText("Advance Amount = "+Integer.toString(advanceCost));


                    }
                    else {
                        Toast.makeText(EstimationActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(EstimationActivity.this, "Failed to Read Data", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}