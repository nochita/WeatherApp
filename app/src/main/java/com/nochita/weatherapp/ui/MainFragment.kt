package com.nochita.weatherapp.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nochita.weatherapp.R
import com.nochita.weatherapp.WeatherForecastApplication
import com.nochita.weatherapp.viewmodel.MainViewModel
import com.nochita.weatherlibrary.WeatherForecastRetriever
import com.nochita.weatherlibrary.domain.model.WeatherForecast
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var weatherForecastRetriever : WeatherForecastRetriever

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            (it.application as WeatherForecastApplication).getWeatherForecastComponent().inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.retrieveWeatherForecast(weatherForecastRetriever)

        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is MainViewModel.State.Loading -> progressBar.isVisible = true
                is MainViewModel.State.Success -> {
                    progressBar.isVisible = false
                    populateUI(state.weatherForecast)
                }
            }
        })
    }

    private fun populateUI(weatherForecast: WeatherForecast) {
        weatherForecast.apply {
            weatherForecastTemperatureText.text =
                getString(R.string.temperature_is, temperature) ?: getString(R.string.no_data_temperature)
            weatherForecastWindSpeedText.text =
                getString(R.string.wind_speed_is, windSpeed) ?: getString(R.string.no_data_wind_speed)
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}