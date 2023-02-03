package com.raulfm.weatherapp.domain.model

import androidx.annotation.StringRes

data class City(
    val id: String,
    @StringRes val name: Int
)