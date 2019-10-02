package com.example.myandroidproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Registry : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)

        val capacityText:TextView
        capacityText = findViewById(R.id.capacity)
        capacityText.text  = "Кол-во зарег. авто:\n"+intent.getIntExtra("capacity",0).toString()+"\n" +
                "Детальное кол-во авто:\n"+intent.getStringExtra("capacityDetails")

        val allInfoText:TextView
        allInfoText = findViewById(R.id.allInfo)
        allInfoText.text = intent.getStringExtra("allInfo")
    }
}
