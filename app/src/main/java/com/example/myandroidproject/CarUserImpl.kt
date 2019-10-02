package com.example.myandroidproject

import android.content.ContentValues.TAG
import android.util.Log

class CarUserImpl : CarUserInterface {
    override fun login(login: String, password: String):Int {
        if (login == "login" && password == "password") {
            Log.i(TAG, "Yo, ты авторизовался")
            return 200
        } else {
            Log.e(TAG, "Гуляй")
            return 403
        }
    }

    override fun logout() {
        Log.i(TAG,"Вышел")
    }

}