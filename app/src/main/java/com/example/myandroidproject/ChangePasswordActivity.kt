package com.example.myandroidproject

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        backButton.setOnClickListener {
            super.onBackPressed()
        }

        emailTextView.text = "Логин: ${intent.getStringExtra("email")}"

        okButton.setOnClickListener {
            if(et_sign_in_changePass.text.toString() == double_et_sign_in_changePass.text.toString()){
                PasswordRepository.password = et_sign_in_changePass.text.toString()
                super.onBackPressed()
            }
            else {
                setPasswordError()
            }

        }

        double_et_sign_in_changePass.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                double_ti_sign_in_changePass.error = null
                double_ti_sign_in_changePass.isErrorEnabled = false
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    private fun setPasswordError() {
        double_ti_sign_in_changePass.error = getString(R.string.incorrect_password)
    }
}
