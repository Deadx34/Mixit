package com.isuru.mixit;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

    }
    Intent openSetPin = new Intent(RegisterActivity.this, SetPinActivity.class);
    String name =  username.getText().toString();
// Add the data to the intent using the a key
openSetPin.putExtra("name_key", name);
    startActivity(openSetPin);
}