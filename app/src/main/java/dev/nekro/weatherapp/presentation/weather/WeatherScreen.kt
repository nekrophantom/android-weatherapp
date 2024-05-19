package dev.nekro.weatherapp.presentation.weather

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.nekro.weatherapp.domain.util.Resource
import dev.nekro.weatherapp.presentation.weather.components.WeatherInfo

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel(),
    modifier: Modifier
) {

    val weatherState by viewModel.weatherState
    val searchState by viewModel.weatherSearchState

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        TextField(
            value = searchState,
            onValueChange = {
                viewModel.onWeatherSearchChange(it)
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                viewModel.fetchWeather(searchState)
            }),
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        when (weatherState) {
            is Resource.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            is Resource.Error -> {
                Text(
                    text = (weatherState  as Resource.Error).message,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            is Resource.Success -> {
                val weather = (weatherState as Resource.Success).data
                Log.d("data: ", weather.toString())
                WeatherInfo(weather = weather)
            }
            else -> {}
        }


    }

}