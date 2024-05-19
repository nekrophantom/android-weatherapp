package dev.nekro.weatherapp.domain.repository

import dev.nekro.weatherapp.data.dto.WeatherDto

interface WeatherRepository {

    suspend fun getCurrentWeather(q: String): WeatherDto

}