package dev.nekro.weatherapp.presentation.weather

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nekro.weatherapp.domain.models.Weather
import dev.nekro.weatherapp.domain.use_case.WeatherUseCase
import dev.nekro.weatherapp.domain.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCase : WeatherUseCase
) : ViewModel() {

    private val _weatherState = mutableStateOf<Resource<Weather>?>(null)
    val weatherState: State<Resource<Weather>?> = _weatherState

    private val _searchState = mutableStateOf("")
    val weatherSearchState: State<String> = _searchState

    fun onWeatherSearchChange(newString: String) {
        _searchState.value = newString
    }


    fun fetchWeather(q: String) {
        viewModelScope.launch {
            _weatherState.value = weatherUseCase.getCurrentWeather(q)
        }
    }

}