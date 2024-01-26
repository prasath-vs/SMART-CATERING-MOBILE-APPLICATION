package com.example.jcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {

    Button payBtn;
    TextView payStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Checkout.preload(getApplicationContext());

        payBtn = findViewById(R.id.pay_btn);
        payStatus = findViewById(R.id.pay_status);

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PaymentNow("100");
            }
        });
    }

    private void PaymentNow(String amount) {

        final Activity activity = this;

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_live_9sVXb9hJHWB7yj");
        checkout.setImage(R.drawable.logo);

        double finalAmount = Float.parseFloat(amount)*100;

        try {
            JSONObject options = new JSONObject();
            options.put("name", "SMART CATERING");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", finalAmount+"");
            options.put("prefill.email", "vsprasath@gmail.com");
            options.put("prefill.contact", "9786881909");

            checkout.open(activity, options);
        } catch (Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Payment Success!", Toast.LENGTH_SHORT).show();
        payStatus.setText("Payment Successful!");
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed!", Toast.LENGTH_SHORT).show();
        payStatus.setText("Payment Failed...");
    }
}