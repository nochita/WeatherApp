package com.nochita.weatherlibrary.usecase

import com.nochita.weatherlibrary.data.repository.WeatherForecastRepository
import com.nochita.weatherlibrary.domain.model.WeatherForecast

internal interface WeatherForecastUseCase {

    suspend fun getWeatherForecast(
        repository: WeatherForecastRepository,
        latitude: String,
        longitude: String
    ): WeatherForecast

}