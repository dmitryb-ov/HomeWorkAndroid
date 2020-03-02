package com.example.myandroidproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.networkapp.R
import kotlinx.android.synthetic.main.activity_selected_weather.*
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

class SelectedWeatherActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private lateinit var service: WeatherService

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_weather)

        val intent: Intent = intent
        val cityId = intent.getIntExtra("cityId", 2172797)
        val color = intent.getIntExtra("color", R.color.black)

        service = ApiFactory.weatherService
        launch {
            val response = withContext(Dispatchers.IO) {
                service.weatherById(cityId)
            }
            tv_city_name.text = response.name
            tv_city_temp.setTextColor(color)
            tv_city_temp.text = response.main?.temp?.toInt().toString()
            tv_temp_feel_num.text = response.main?.feelsLike?.toInt().toString()
            tv_wind_type.text = "${getWindType(response.wind?.deg)} ${response.wind?.speed} м/c"
            tv_weather_type.text = doFirstInUpperCase(response.weather?.get(0)?.description)
            tv_pressure_num.text = "${response.main?.pressure.toString()} мм рт. ст."
            tv_humidity_num.text = "${response.main?.humidity.toString()}%"
            tv_day_of_week.text = doFirstInUpperCase(getDayName())

            val icon = response.weather?.get(0)?.icon
            val iconURL = "https://openweathermap.org/img/wn/${icon}@2x.png"
            Glide.with(this@SelectedWeatherActivity).load(iconURL).into(iv_weather_pic)
        }
    }

    private fun doFirstInUpperCase(string: String?): String? {
        return string?.substring(0, 1)?.toUpperCase() + string?.substring(1)
    }

    private fun getWindType(degInt: Int?): String? {
        val deg = degInt?.toDouble()
        if (deg != null) {
            when {
                deg <= 22.5 -> return "С"
                deg <= 67.5 -> return "СЗ"
                deg <= 112.5 -> return "В"
                deg <= 157.5 -> return "ЮВ"
                deg <= 202.5 -> return "Ю"
                deg <= 247.5 -> return "ЮЗ"
                deg <= 292.5 -> return "З"
                deg <= 337.5 -> return "СЗ"
                deg <= 360 -> return "С"
            }
        }
        return "Нет данных"
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDayName(): String {
        val simpleDateFormat = SimpleDateFormat("EEEE")
        val d = Date()
//        println(simpleDateFormat.format(d))
        return simpleDateFormat.format(d)
    }
}
