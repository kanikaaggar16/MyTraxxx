package com.example.demo.mytraxxx;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registeration extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText emailt, passwordt, cpasswordt;
    private Button register, signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        signin = (Button) findViewById(R.id.tuser);
        register = (Button) findViewById(R.id.register);
        emailt = (EditText) findViewById(R.id.edit_text1);
        cpasswordt = (EditText) findViewById(R.id.edit_text3);
        passwordt = (EditText) findViewById(R.id.edit_text2);
        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailt.getText().toString();
                String password = passwordt.getText().toString();
                String confirm = cpasswordt.getText().toString();

                if (validateData(email,password,confirm)){
                    mAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(registeration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(registeration.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(registeration.this,MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(registeration.this,"Sign in successful",Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(registeration.this,MainActivity.class));
                            }
                        }
                    });
                }

            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(registeration.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private boolean validateData(String email, String password, String cpassword){
        if (!email.isEmpty()) {
            if (!password.equals(cpassword)) {
                Toast.makeText(registeration.this, "Password must match.", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        } else {
            Toast.makeText(registeration.this, "Email must not be empty.", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
