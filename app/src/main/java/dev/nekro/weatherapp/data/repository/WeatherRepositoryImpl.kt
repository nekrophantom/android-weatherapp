package dev.nekro.weatherapp.data.repository

import dev.nekro.weatherapp.data.dto.WeatherDto
import dev.nekro.weatherapp.data.remote.WeatherApiService
import dev.nekro.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val apiService: WeatherApiService) : WeatherRepository {
    override suspend fun getCurrentWeather(q: String): WeatherDto {
        return apiService.getCurrentWeather(q)
    }
}