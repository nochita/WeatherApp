package com.nochita.weatherlibrary.usecase

import com.nochita.weatherlibrary.data.repository.WeatherForecastRepository
import com.nochita.weatherlibrary.domain.model.WeatherForecast

internal class WeatherForecastUseCaseImpl : WeatherForecastUseCase {

    override suspend fun getWeatherForecast(
        repository: WeatherForecastRepository,
        latitude: String,
        longitude: String
    ): WeatherForecast {
        val apiResponse = repository.getWeatherForecast(latitude, longitude)
        return apiResponse.toWeatherForecast()
    }

}