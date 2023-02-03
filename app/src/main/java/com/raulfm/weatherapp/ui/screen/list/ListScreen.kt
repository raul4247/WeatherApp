package com.raulfm.weatherapp.ui.screen.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.raulfm.weatherapp.ui.screen.Screens
import com.raulfm.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun ListScreen(
    navController: NavHostController
) {
    val viewModel = hiltViewModel<ListViewModel>()

    val cities by viewModel.citiesList.collectAsState()

    val navigateToDetail: (cityId: String) -> Unit = { cityId ->
        navController.navigate(Screens.Detail.route + "/$cityId")
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item {
            Text(
                modifier = Modifier.padding(24.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                text = "Cities"
            )
        }

        items(items = cities) { city ->
            CityItem(
                modifier = Modifier.padding(horizontal = 24.dp),
                onClick = navigateToDetail,
                city = city
            )
        }
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    WeatherAppTheme {
        ListScreen(
            navController = rememberNavController()
        )
    }
}
