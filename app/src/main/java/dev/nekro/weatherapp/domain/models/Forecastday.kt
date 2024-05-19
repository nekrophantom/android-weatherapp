package dev.nekro.weatherapp.domain.models

data class Forecastday(
    val date: String,
    val forecastAverageTemp: Double,
    val conditionText: String,
    val conditionIcon: String,
)
