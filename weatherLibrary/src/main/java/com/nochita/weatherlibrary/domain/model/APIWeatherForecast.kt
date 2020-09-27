package com.nochita.weatherlibrary.domain.model

internal data class APIWeatherForecast(val data : List<APIDataWeatherForecast>){

    private fun getTemperature() : String? = data?.get(0)?.temp
    private fun getWindSpeed() : String? = data?.get(0)?.wind_spd

    fun toWeatherForecast(): WeatherForecast {
            return WeatherForecast(getTemperature(), getWindSpeed())
        }
}

internal data class APIDataWeatherForecast(val temp: String,
                                  val wind_spd : String
)