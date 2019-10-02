package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class FifthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Button fifthNextButton = findViewById(R.id.fifth_button);
        fifthNextButton.setOnClickListener(l->{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}
