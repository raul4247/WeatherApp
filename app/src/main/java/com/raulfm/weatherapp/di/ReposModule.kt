package com.raulfm.weatherapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.raulfm.weatherapp.data.interceptor.TokenInterceptor
import com.raulfm.weatherapp.data.service.WeatherService
import com.raulfm.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object ReposModule {

    private const val API_URL = "https://api.openweathermap.org/data/2.5/"
    private const val API_TOKEN = "e5c656e96a6fb979a5cfa7d8894b212f"

    @Provides
    fun provideWeatherRepository(weatherService: WeatherService): WeatherRepository =
        WeatherRepository(weatherService)

    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor(API_TOKEN))
            .build()
    }
}
