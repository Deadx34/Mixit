package com.isuru.mixit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Sign_in extends AppCompatActivity {

    EditText getEmail, getPassword;
    Button btnSignIn;
    TextView signUpRedirectText;
    DataBaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);

        getEmail = findViewById(R.id.getEmail);
        getPassword = findViewById(R.id.getPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        dbHelper = new DataBaseHelper(this);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = getEmail.getText().toString();
                String password = getPassword.getText().toString();

                if (dbHelper.checkUser(email, password)) {
                    Toast.makeText(Sign_in.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Sign_in.this, Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Sign_in.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_in.this, Sign_up.class);
                startActivity(intent);
            }
        });
    }
}
