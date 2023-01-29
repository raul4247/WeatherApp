package com.raulfm.weatherapp.ui.screen.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raulfm.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun ListScreen() {
    Text("ListScreen")
}

@Preview
@Composable
fun ListScreenPreview() {
    WeatherAppTheme {
        ListScreen()
    }
}
