package com.nochita.weatherlibrary.data.repository

import com.nochita.weatherlibrary.domain.model.APIWeatherForecast

internal interface WeatherForecastRepository {
    suspend fun getWeatherForecast(lat : String, lon : String) : APIWeatherForecast
}