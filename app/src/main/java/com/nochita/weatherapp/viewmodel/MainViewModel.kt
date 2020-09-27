package com.nochita.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nochita.weatherlibrary.WeatherForecastRetriever
import com.nochita.weatherlibrary.domain.model.WeatherForecast
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    init {
        _state.value = State.Loading()
    }

    fun retrieveWeatherForecast(weatherForecastRetriever: WeatherForecastRetriever) {
        viewModelScope.launch(coroutineDispatcher) {
            _state.postValue(
                State.Success(
                    weatherForecastRetriever.retrieveWeatherForecast("33", "58")
                )
            )
        }
    }

    sealed class State {
        class Loading : State()
        class Success(val weatherForecast : WeatherForecast) : State()
    }
}