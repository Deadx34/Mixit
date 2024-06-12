package com.isuru.mixit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Sign_up extends AppCompatActivity {

    EditText getName, getPassword, getConfirmPassword, getEmail;
    Button btnSignIn, btnSignUp;
    TextView greetingH1;
    TextView loginRedirectText;
    DataBaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        getName = findViewById(R.id.getName);
        getPassword = findViewById(R.id.getpassword);
        getConfirmPassword = findViewById(R.id.getConfermPw);
        getEmail = findViewById(R.id.getEmail);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
        greetingH1 = findViewById(R.id.greetingH1);

        dbHelper = new DataBaseHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = getName.getText().toString();
                String email = getEmail.getText().toString();
                String password = getPassword.getText().toString();
                String confirmPassword = getConfirmPassword.getText().toString();

                if (password.equals(confirmPassword)) {
                    dbHelper.addUser(name, email, password);
                    Toast.makeText(Sign_up.this, "You have successfully signed up",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Sign_up.this, Sign_up.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Sign_up.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sign_up.this, Sign_in.class);
                startActivity(intent);
            }
        });
    }
}
