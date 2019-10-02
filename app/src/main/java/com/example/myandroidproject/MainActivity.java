package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button firstNextButton = findViewById(R.id.first_button);
        firstNextButton.setOnClickListener(l ->{
            Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
        });
    }
}
