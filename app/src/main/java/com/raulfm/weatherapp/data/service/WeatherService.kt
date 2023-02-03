package com.raulfm.weatherapp.data.service

import com.raulfm.weatherapp.data.model.WeatherDataDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    fun getWeatherByCity(
        @Query("q") cityName: String,
        @Query("units") units: String = DefaultUnit
    ): Call<WeatherDataDto>
}

private const val DefaultUnit = "metric"