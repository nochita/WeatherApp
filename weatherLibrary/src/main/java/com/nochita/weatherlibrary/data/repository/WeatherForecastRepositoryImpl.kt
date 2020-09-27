package com.nochita.weatherlibrary.data.repository

import com.nochita.weatherlibrary.domain.model.APIWeatherForecast
import com.nochita.weatherlibrary.network.WeatherForecastClientService
import com.nochita.weatherlibrary.network.WeatherForecastInterface

internal class WeatherForecastRepositoryImpl : WeatherForecastRepository {

    private val client = WeatherForecastClientService.getRetrofit().create(WeatherForecastInterface::class.java)

    override suspend fun getWeatherForecast(lat : String, lon : String) : APIWeatherForecast = client.getWeatherForecast(lat, lon)

}