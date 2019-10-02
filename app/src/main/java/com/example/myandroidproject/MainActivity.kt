package com.example.myandroidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var login:EditText
        var password:EditText
        var loginButton:Button? = null

        var carUser = CarUserImpl()

        loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            login = findViewById(R.id.login)
            password = findViewById(R.id.password)
            if(carUser.login(login.text.toString(), password.text.toString()) == 200){
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
