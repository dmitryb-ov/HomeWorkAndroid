package com.example.myandroidproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.networkapp.R
import kotlinx.android.synthetic.main.activity_selected_weather.*
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.text.SimpleDateFormat
import java.util.*

class SelectedWeatherActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private val service: WeatherService by lazy {
        ApiFactory.weatherService
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_weather)

        val intent: Intent = intent
        val cityId = intent.getIntExtra("cityId", DEFAULT_CITY_ID)
        val color = intent.getIntExtra("color", R.color.black)
        launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    service.weatherById(cityId)
                }
                tv_city_name.text = response.name
                tv_city_temp.text = response.main?.temp?.toInt().toString()
                tv_city_temp.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        Util.setTextColorForTemp(response.main?.temp)
                    )
                )
                tv_temp_feel_num.text = response.main?.feelsLike?.toInt().toString()
                tv_wind_type.text =
                    "${Util.getWindType(response.wind?.deg)} ${response.wind?.speed} м/c"
                tv_weather_type.text = doFirstInUpperCase(response.weather?.get(0)?.description)
                tv_pressure_num.text = "${response.main?.pressure.toString()} мм рт. ст."
                tv_humidity_num.text = "${response.main?.humidity.toString()}%"
                tv_day_of_week.text = doFirstInUpperCase(getDayName())

                val icon = response.weather?.get(0)?.icon
                val iconURL = "https://openweathermap.org/img/wn/${icon}@2x.png"
                Glide.with(this@SelectedWeatherActivity).load(iconURL).into(iv_weather_pic)
            } catch (e: HttpException) {
                Log.e("EXCEPTION", "$e.message\n${e.response().toString()}")
            }
        }
    }

    private fun doFirstInUpperCase(string: String?) =
        string?.substring(0, 1)?.toUpperCase() + string?.substring(1)

    @SuppressLint("SimpleDateFormat")
    private fun getDayName(): String {
        val simpleDateFormat = SimpleDateFormat("EEEE")
        val date = Date()
//        println(simpleDateFormat.format(d))
        return simpleDateFormat.format(date)
    }

    companion object {
        private const val DEFAULT_CITY_ID: Int = 2172797
    }
}
