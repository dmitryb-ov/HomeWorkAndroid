package com.example.myandroidproject

import com.example.myandroidproject.data.WeatherInCircleByCoordRes
import com.example.myandroidproject.data.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun weatherByName(@Query("q") name: String): WeatherResponse

    @GET("find")
    suspend fun weatherInCircleByCoord(
        @Query("lat") latitude: Double?, @Query("lon") longitude: Double?,
        @Query("cnt") radius: Int = 10
    ): WeatherInCircleByCoordRes

    @GET("weather")
    suspend fun weatherById(@Query("id") id: Int): WeatherResponse

}
