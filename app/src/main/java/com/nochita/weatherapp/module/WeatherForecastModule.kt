package com.nochita.weatherapp.module

import com.nochita.weatherlibrary.WeatherForecastRetriever
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherForecastModule {

    @Provides
    @Singleton
    fun provideWeatherForecastRetriever() = WeatherForecastRetriever()

}