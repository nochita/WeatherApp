package com.nochita.weatherapp

import android.app.Application
import com.nochita.weatherapp.component.DaggerWeatherForecastComponent
import com.nochita.weatherapp.component.WeatherForecastComponent
import com.nochita.weatherapp.module.WeatherForecastModule

class WeatherForecastApplication : Application() {

    private lateinit var weatherForecastComponent: WeatherForecastComponent

    override fun onCreate() {
        super.onCreate()
        weatherForecastComponent = DaggerWeatherForecastComponent
            .builder().weatherForecastModule(WeatherForecastModule()).build()
    }

    fun getWeatherForecastComponent() = weatherForecastComponent
}