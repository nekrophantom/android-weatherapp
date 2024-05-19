package dev.nekro.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.nekro.weatherapp.data.remote.WeatherApiService
import dev.nekro.weatherapp.data.repository.WeatherRepositoryImpl
import dev.nekro.weatherapp.domain.repository.WeatherRepository
import dev.nekro.weatherapp.domain.use_case.GetCurrentWeather
import dev.nekro.weatherapp.domain.use_case.WeatherUseCase
import dev.nekro.weatherapp.domain.util.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    
    @Provides
    @Singleton
    fun provideWeatherApiService() : WeatherApiService {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(apiService: WeatherApiService) : WeatherRepository {
        return WeatherRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideWeatherUseCase(repository: WeatherRepository) : WeatherUseCase {
        return WeatherUseCase(
            getCurrentWeather = GetCurrentWeather(repository)
        )
    }

}