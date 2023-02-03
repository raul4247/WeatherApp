package com.raulfm.weatherapp.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raulfm.weatherapp.R
import com.raulfm.weatherapp.domain.model.WeatherData
import com.raulfm.weatherapp.ui.theme.WeatherAppTheme


@Composable
fun DetailScreen() {
    val viewModel = hiltViewModel<DetailViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        when (val state = uiState) {
            DetailsUiState.Loading -> CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )

            DetailsUiState.Error -> Text("Error!")
            is DetailsUiState.Success -> {
                WeatherDetails(state.weatherData)
            }
        }
    }
}

@Composable
fun WeatherDetails(
    weatherData: WeatherData
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ) {

        Spacer(Modifier.height(24.dp))

        Image(
            modifier = Modifier
                .size(128.dp)
                .align(CenterHorizontally),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = weatherData.getImage()),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .align(CenterHorizontally),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            text = weatherData.cityName
        )

        Spacer(Modifier.height(4.dp))

        Text(
            modifier = Modifier
                .align(CenterHorizontally),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            text = "${weatherData.temperature}ºC"
        )

        Spacer(Modifier.height(4.dp))

        Text(
            modifier = Modifier
                .align(CenterHorizontally),
            fontSize = 16.sp,
            text = weatherData.description.capitalize(Locale.current)
        )

        Spacer(Modifier.height(12.dp))

        WeatherInfo(
            label = "Min:",
            value = "${weatherData.minTemperature}ºC"
        )

        WeatherInfo(
            label = "Max:",
            value = "${weatherData.maxTemperature}ºC"
        )

        WeatherInfo(
            label = "Max:",
            value = "${weatherData.maxTemperature}ºC"
        )

        WeatherInfo(
            label = "Humidity: ",
            value = "${weatherData.humidity.toInt()}%"
        )

        WeatherInfo(
            label = "Pressure: ",
            value = "${weatherData.pressure.toInt()} hPa"
        )

        WeatherInfo(
            label = "Pressure: ",
            value = "${weatherData.pressure.toInt()} hPa"
        )

        WeatherInfo(
            label = "Wind Speed: ",
            value = "${weatherData.windSpeed} m/s"
        )

        WeatherInfo(
            label = "Cloudiness: ",
            value = "${weatherData.cloudiness.toInt()}%"
        )
    }
}

private fun WeatherData.getImage(): Int {
    return when (weatherId) {
        in 200..299 -> R.drawable.thunder
        in 300..399 -> R.drawable.rainy
        in 500..599 -> R.drawable.rainy_2
        in 600..699 -> R.drawable.snowy
        800 -> R.drawable.day
        else -> R.drawable.cloudy
    }
}

@Composable
fun WeatherInfo(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.padding(horizontal = 24.dp, vertical = 8.dp),
        fontSize = 16.sp,
        text = label + value
    )
}

@Preview
@Composable
fun WeatherDetailsPreview() {
    WeatherAppTheme {
        WeatherDetails(
            weatherData = WeatherData(
                cityName = "London",
                description = "Drizzle, light intensity drizzle",
                temperature = 280.32,
                minTemperature = 279.15,
                maxTemperature = 281.15,
                humidity = 81L,
                pressure = 1012L,
                windSpeed = 4.1,
                cloudiness = 90L,
                weatherId = 800,
            )
        )
    }
}
