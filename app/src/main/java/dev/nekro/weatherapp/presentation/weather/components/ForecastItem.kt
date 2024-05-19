package dev.nekro.weatherapp.presentation.weather.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.nekro.weatherapp.domain.models.Forecastday
import java.time.LocalDate
import java.util.Locale
import java.time.format.TextStyle

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForecastItem(forecastday: Forecastday) {

    val date = LocalDate.parse(forecastday.date)
    val dayOfWeek = date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        AsyncImage(
            model = "https:${forecastday.conditionIcon}",
            contentDescription = "Weather Icon"
        )

        Text(text = dayOfWeek)
        Text(text = "${forecastday.forecastAverageTemp}°C")

    }

}