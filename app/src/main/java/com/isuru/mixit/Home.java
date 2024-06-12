package com.isuru.mixit;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    TextView greetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        greetingText = findViewById(R.id.greetingText);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        if (userName != null) {
            greetingText.setText("Hello, " + userName);
        }
    }
}
