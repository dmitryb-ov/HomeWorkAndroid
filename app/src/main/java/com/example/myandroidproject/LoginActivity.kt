package com.example.myandroidproject

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val imageView: ImageView = findViewById(R.id.imageView2)
        imageView.setImageResource(R.drawable.img)

        changePasswordButton.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
            intent.putExtra("email", et_sign_in_login.text.toString())
            startActivity(intent)

        }

        loginButton.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            if (et_sign_in_pass.text.toString() == PasswordRepository.password) {
//                var b = 0
//                while (b != 567){
//                    b = (1..10000).random()
//                }
                Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
//                var b = 0
//                while (b != 543){
//                    b = (1..10000).random()
//                }
                Toast.makeText(this, "Wrong password", Toast.LENGTH_LONG).show()
                setPasswordError()
            }
            progressBar.visibility = View.INVISIBLE
        }

        et_sign_in_pass.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                ti_sign_in_pass.error = null
                ti_sign_in_pass.isErrorEnabled = false
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })


    }

    private fun setPasswordError() {
        ti_sign_in_pass.error = getString(R.string.wrong_password)
    }
}
