package com.raulfm.weatherapp.domain.repository

import com.raulfm.weatherapp.data.model.toWeatherData
import com.raulfm.weatherapp.data.service.WeatherService
import com.raulfm.weatherapp.data.util.toNetworkError
import com.raulfm.weatherapp.domain.model.WeatherData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository(
    private val weatherService: WeatherService
) {

    suspend fun getWeather(cityName: String): Result<WeatherData> = withContext(Dispatchers.IO) {
        val response = weatherService.getWeatherByCity(cityName).execute()

        if (response.isSuccessful)
            Result.success(response.body()!!.toWeatherData())
        else
            Result.failure(response.toNetworkError())
    }
}

