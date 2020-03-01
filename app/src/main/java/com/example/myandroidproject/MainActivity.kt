package com.example.myandroidproject

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.Menu
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import com.example.myandroidproject.data.WeatherResponse
import com.example.myandroidproject.recycler.Adapter
import com.example.networkapp.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.HttpException

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private lateinit var service: WeatherService
    private lateinit var provider: FusedLocationProviderClient
    private var adapter: Adapter? = null
    private var latitude: Double? = 49.12
    private var longitude: Double? = 55.79


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        service = ApiFactory.weatherService
        provider = LocationServices.getFusedLocationProviderClient(this)

        val perms = checkPermissions()
        if (!perms) {
            ActivityCompat.requestPermissions(this@MainActivity, Array(2) {
                android.Manifest.permission.ACCESS_FINE_LOCATION
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1)
        } else {
//                var latitude: Double? = 49.12
//                var longitude: Double?  = 55.79
            provider.lastLocation.apply {
                addOnSuccessListener { location ->
                    if (location != null) {
                        latitude = location.latitude
                        longitude = location.longitude
                    }
                }
            }
        }

        launch {
            try {
                delay(300)
//                if (ActivityCompat.checkSelfPermission(
//                        this@MainActivity,
//                        android.Manifest.permission.ACCESS_FINE_LOCATION
//                    ) !=
//                    PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                        this@MainActivity,
//                        android.Manifest.permission.ACCESS_COARSE_LOCATION
//                    ) !=
//                    PackageManager.PERMISSION_GRANTED
//                ) {
                val response = withContext(Dispatchers.IO) {
                    service.weatherInCircleByCoord(latitude, longitude, 20)
                }
                println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
                println("FFFFFFFFFFFFFFFFFFFFFFFFFff${response.list}")
                recyclerView.adapter = Adapter(response.list) { weatherRes ->
                    detailWeather(weatherRes)
                }
            } catch (e: Exception) {

            }
        }
    }

    private fun detailWeather(weather: WeatherResponse) {
        val intent = Intent(this, SelectedWeatherActivity::class.java)
        intent.putExtra("cityId", weather.id)
        intent.putExtra("color", color)
        startActivity(intent)
    }

    private fun checkPermissions(): Boolean {
        return !(ActivityCompat.checkSelfPermission(
            this@MainActivity,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            this@MainActivity,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ) !=
                PackageManager.PERMISSION_GRANTED)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchItem = menu?.findItem(R.id.menu_search)
        val searchView = searchItem?.actionView as SearchView
        val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        editText.hint = "Введите город здесь..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                launch {
                    try {
//                        searchView.clearFocus()
//                        searchView.setQuery("",false)
                        val response = withContext(Dispatchers.IO) {
                            query?.let {
                                service.weatherByName(it)
                            }
                        }
                        response?.let { detailWeather(it) }
                    } catch (ex: HttpException) {
                        val sn = Snackbar.make(
                            main_const_layout,
                            "Город не найден",
                            Snackbar.LENGTH_LONG
                        )
                        sn.show()
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
//        return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineContext.cancelChildren()
    }

    companion object {
        var color: Int = R.color.black
    }
}
