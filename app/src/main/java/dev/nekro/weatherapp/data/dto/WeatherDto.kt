package dev.nekro.weatherapp.data.dto

import dev.nekro.weatherapp.domain.models.Forecastday
import dev.nekro.weatherapp.domain.models.Weather

data class WeatherDto(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)


fun WeatherDto.toWeather() : Weather {
    return Weather(
        locationName = location.name,
        locationRegion = location.region,
        locationCountry = location.country,
        currentTemp = current.temp_c,
        currentConditionText = current.condition.text,
        currentIcon = current.condition.icon,
        lat = location.lat,
        lon = location.lon,
        forecastday = forecast.forecastday.map { forecastdayDto ->
            Forecastday(
                date = forecastdayDto.date,
                forecastAverageTemp = forecastdayDto.day.avgtemp_c,
                conditionText = forecastdayDto.day.condition.text,
                conditionIcon = forecastdayDto.day.condition.icon
            )
        }
    )
}