package com.raulfm.weatherapp.ui.screen.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raulfm.weatherapp.ui.theme.WeatherAppTheme


@Composable
fun DetailScreen() {
    Text("DetailScreen")
}

@Preview
@Composable
fun DetailScreenPreview() {
    WeatherAppTheme {
        DetailScreen()
    }
}
