package dev.nekro.weatherapp.domain.use_case

import dev.nekro.weatherapp.data.dto.toWeather
import dev.nekro.weatherapp.domain.models.Weather
import dev.nekro.weatherapp.domain.repository.WeatherRepository
import dev.nekro.weatherapp.domain.util.Resource

class GetCurrentWeather(private val repository: WeatherRepository) {
    suspend operator fun invoke(q: String) : Resource<Weather> {
        return try {
            val response = repository.getCurrentWeather(q).toWeather()
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An unkown error occurred")
        }
    }
}