package com.nochita.weatherapp.component

import com.nochita.weatherapp.module.WeatherForecastModule
import com.nochita.weatherapp.ui.MainFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [WeatherForecastModule::class])
interface WeatherForecastComponent {
    fun inject(mainFragment : MainFragment)
}