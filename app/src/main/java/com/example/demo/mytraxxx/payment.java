package com.example.demo.mytraxxx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class payment extends AppCompatActivity {
    DatePicker datePicker;
    EditText amountET;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");

        datePicker = findViewById(R.id.datePicker);
        amountET = findViewById(R.id.enterAmountET);

        final String amount = amountET.getText().toString();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        final String date = day + "-" + month + "-" + year;

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeUserToDatabase(date,amount);
            }
        });

    }

    private void storeUserToDatabase(String date, String ammount) {
        UserModel userModel = new UserModel();
        userModel.setDate(date);
        userModel.setAmmount(ammount);
        databaseReference.child(currentUser.getUid()).setValue(userModel);

    }

}
