package com.raulfm.weatherapp.ui.screen.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raulfm.weatherapp.domain.model.WeatherData
import com.raulfm.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        val cityId = savedStateHandle.get<String>("cityId")
        if (cityId != null) {
            viewModelScope.launch {
                weatherRepository.getWeather(cityId)
                    .onSuccess { onSuccess(it) }
                    .onFailure { onError(it) }
            }
        } else {
            onError(IllegalStateException())
        }
    }

    private fun onSuccess(weatherData: WeatherData) {
        _uiState.update { DetailsUiState.Success(weatherData) }
    }

    private fun onError(throwable: Throwable) {
        Log.e("WeatherAppError", throwable.message.toString())
        _uiState.update { DetailsUiState.Error }
    }
}

sealed class DetailsUiState {
    object Loading : DetailsUiState()
    object Error : DetailsUiState()
    data class Success(val weatherData: WeatherData) : DetailsUiState()
}
