package com.raulfm.weatherapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raulfm.weatherapp.ui.screen.Screens
import com.raulfm.weatherapp.ui.screen.detail.DetailScreen
import com.raulfm.weatherapp.ui.screen.list.ListScreen
import com.raulfm.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screens.List.route) {
                    composable(Screens.List.route) { ListScreen(navController) }
                    composable(Screens.Detail.route + "/{cityId}") { backStackEntry ->
                        DetailScreen()
                    }
                }
            }
        }
    }
}
