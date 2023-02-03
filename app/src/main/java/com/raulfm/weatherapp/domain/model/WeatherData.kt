package com.raulfm.weatherapp.domain.model

data class WeatherData(
    val cityName: String,
    val description: String,
    val temperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val humidity: Long,
    val pressure: Long,
    val windSpeed: Double,
    val cloudiness: Long,
    val weatherId: Int
)