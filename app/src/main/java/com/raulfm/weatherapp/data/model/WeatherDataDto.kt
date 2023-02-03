package com.raulfm.weatherapp.data.model

import com.google.gson.annotations.SerializedName
import com.raulfm.weatherapp.domain.model.WeatherData


data class WeatherDataDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("cod")
    val cod: Long,
    @SerializedName("coord")
    val coordinates: CoordinatesDto,
    @SerializedName("main")
    val mainWeather: MainWeatherDto,
    @SerializedName("visibility")
    val visibility: Long,
    @SerializedName("wind")
    val wind: WindDto,
    @SerializedName("clouds")
    val clouds: CloudsDto,
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("weather")
    val weatherList: List<WeatherDto>
)

data class CoordinatesDto(
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("lat")
    val lat: Double
)

data class CloudsDto(
    @SerializedName("all")
    val all: Long
)

data class MainWeatherDto(
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("pressure")
    val pressure: Long,
    @SerializedName("humidity")
    val humidity: Long,
    @SerializedName("temp_min")
    val tempMin: Double,
    @SerializedName("temp_max")
    val tempMax: Double
)

data class WindDto(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Long
)

data class WeatherDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String,
    @SerializedName("description")
    val description: String,
)

fun WeatherDataDto.toWeatherData() = WeatherData(
    cityName = name,
    description = weatherList.first().description,
    weatherId = weatherList.first().id,
    temperature = mainWeather.temp,
    minTemperature = mainWeather.tempMin,
    maxTemperature = mainWeather.tempMax,
    humidity = mainWeather.humidity,
    pressure = mainWeather.pressure,
    windSpeed = wind.speed,
    cloudiness = clouds.all,
)