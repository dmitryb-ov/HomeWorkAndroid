package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class FourthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Button fourthNextButton = findViewById(R.id.fourth_button);
        fourthNextButton.setOnClickListener(l->{
            Intent intent = new Intent(this,FifthActivity.class);
            startActivity(intent);
        });
    }
}
