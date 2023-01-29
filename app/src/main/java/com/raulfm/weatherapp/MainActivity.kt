package com.raulfm.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raulfm.weatherapp.ui.screen.Screens
import com.raulfm.weatherapp.ui.screen.detail.DetailScreen
import com.raulfm.weatherapp.ui.screen.list.ListScreen
import com.raulfm.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                NavHost(navController = rememberNavController(), startDestination = Screens.List.route) {
                    composable(Screens.List.route) { ListScreen() }
                    composable(Screens.Detail.route) { DetailScreen() }
                }
            }
        }
    }
}
