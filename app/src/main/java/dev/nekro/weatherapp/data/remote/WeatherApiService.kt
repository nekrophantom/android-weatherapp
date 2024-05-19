package dev.nekro.weatherapp.data.remote

import dev.nekro.weatherapp.data.dto.WeatherDto
import dev.nekro.weatherapp.domain.util.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("forecast.json")
    suspend fun getCurrentWeather(
        @Query("q") q: String,
        @Query("key") apiKey: String = Constant.API_KEY,
        @Query("days") days: Int = 7,
    ): WeatherDto


}