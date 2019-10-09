package com.example.demo.mytraxxx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class financial extends AppCompatActivity {
CardView paymentCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial);

        paymentCard = findViewById(R.id.paymentCard);

        paymentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(financial.this, payment.class));
            }
        });
    }

}
