package com.example.demo.mytraxxx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class select_goal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_goal);
        CardView card1 = (CardView) findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(select_goal.this,financial.class);
                startActivity(intent);

            }
        });

        CardView card2 = (CardView) findViewById(R.id.card2);

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(select_goal.this,education.class);
                startActivity(intent);
            }
        });

        CardView card3 = (CardView) findViewById(R.id.card3);

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(select_goal.this,travel.class);
                startActivity(intent);

            }
        });

        CardView card4 = (CardView) findViewById(R.id.card4);

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(select_goal.this,Health.class);
                startActivity(intent);

            }
        });

    }
}
