package com.raulfm.weatherapp.data.model

data class NetworkError(val code: Int, val msg: String) : Throwable()