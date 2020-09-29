package com.nochita.weatherlibrary

import com.nochita.weatherlibrary.data.repository.WeatherForecastRepositoryImpl
import com.nochita.weatherlibrary.domain.model.WeatherForecast
import com.nochita.weatherlibrary.usecase.WeatherForecastUseCaseImpl

class WeatherForecastRetriever {

        suspend fun retrieveWeatherForecast(latitude: String = "-34", longitude : String = "-58") : WeatherForecast{
            val repository = WeatherForecastRepositoryImpl()
            val useCase = WeatherForecastUseCaseImpl()
            return useCase.getWeatherForecast(repository, latitude, longitude)
        }
}