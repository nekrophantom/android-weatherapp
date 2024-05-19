package dev.nekro.weatherapp.domain.models

data class Weather(
    val locationName: String,
    val locationRegion: String,
    val locationCountry: String,
    val lat: Double,
    val lon: Double,
    val currentTemp: Double,
    val currentConditionText: String,
    val currentIcon: String,
    val forecastday: List<Forecastday>
)
