package dev.nekro.weatherapp.presentation.weather.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.nekro.weatherapp.domain.models.Weather

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherInfo(weather: Weather) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        AsyncImage(
            model = "https:${weather.currentIcon}",
            contentDescription = "icon",
            modifier = Modifier.size(175.dp)
        )

        Text(text = "Location: ${weather.locationName}, ${weather.locationCountry}")

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Temperature: ${weather.currentTemp}°C")

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Condition: ${weather.currentConditionText}")


        Spacer(modifier = Modifier.height(50.dp))


        LazyRow() {
            items(weather.forecastday) { forecastday ->
                ForecastItem(forecastday = forecastday)
            }
        }
    }
}