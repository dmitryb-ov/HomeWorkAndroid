package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button secondNextButton = findViewById(R.id.second_button);
        secondNextButton.setOnClickListener(l ->{
            Intent intent = new Intent(this,ThirdActivity.class);
            startActivity(intent);
        });
    }
}
