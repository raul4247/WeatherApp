package com.raulfm.weatherapp.ui.screen.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raulfm.weatherapp.R
import com.raulfm.weatherapp.domain.model.City
import com.raulfm.weatherapp.ui.theme.WeatherAppTheme


@Composable
fun CityItem(
    city: City,
    onClick: (cityId: String) -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(city.id) }
    ) {
        Text(
            modifier = Modifier.padding(12.dp),
            fontSize = 16.sp,
            text = stringResource(city.name)
        )

        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
        )
    }
}

@Preview
@Composable
fun CityItemPreview() {
    WeatherAppTheme {
        CityItem(
            city = City("lisbon", R.string.lisbon_city_name),
            onClick = {}
        )
    }
}

