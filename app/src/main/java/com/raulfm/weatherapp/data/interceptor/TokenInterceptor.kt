package com.raulfm.weatherapp.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val apiToken: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("appId", apiToken)
            .build()

        val request =  original.newBuilder()
            .url(url).build()
        return chain.proceed(request)
    }
}
