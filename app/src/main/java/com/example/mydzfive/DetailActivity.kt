package com.example.mydzfive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        city_name_text_view.text = intent?.getStringExtra("cityName").toString()
        detail_image_view.setImageResource(intent.getIntExtra("img", R.mipmap.ic_launcher))
        description_text_view.text = intent?.getStringExtra("description").toString()
    }
}
