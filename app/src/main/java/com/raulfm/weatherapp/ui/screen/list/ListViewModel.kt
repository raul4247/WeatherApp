package com.raulfm.weatherapp.ui.screen.list

import androidx.lifecycle.ViewModel
import com.raulfm.weatherapp.R
import com.raulfm.weatherapp.domain.model.City
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : ViewModel() {

    private val _citiesList = MutableStateFlow(defaultCities)
    val citiesList = _citiesList.asStateFlow()
}

private val defaultCities = listOf(
    City("lisbon", R.string.lisbon_city_name),
    City("madrid", R.string.madrid_city_name),
    City("paris", R.string.paris_city_name),
    City("berlin", R.string.berlin_city_name),
    City("copenhagen", R.string.copenhagen_city_name),
    City("rome", R.string.rome_city_name),
    City("london", R.string.london_city_name),
    City("dublin", R.string.dublin_city_name),
    City("prague", R.string.prague_city_name),
    City("vienna", R.string.vienna_city_name)
)
