package com.raulfm.weatherapp.data.util

import com.raulfm.weatherapp.data.model.NetworkError
import retrofit2.Response

fun <T> Response<T>.toNetworkError() = NetworkError(
    code = code(),
    msg = errorBody()?.string() ?: "Erro desconhecido!"
)
