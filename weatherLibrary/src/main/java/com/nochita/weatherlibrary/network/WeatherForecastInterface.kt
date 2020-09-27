package com.nochita.weatherlibrary.network

import com.nochita.weatherlibrary.domain.model.APIWeatherForecast
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WeatherForecastInterface {

    //https://api.openweathermap.org/data/2.5/weather?lat=-34&lon=-58&appid=f088bd2fd79d2a3bd64f622744ebdd9f
    //https://api.weatherbit.io/v2.0/current?lat=38.123&lon=-78.543&key=f12760200cad414fa3a3e7a5f650630f
    @GET("/v2.0/current?key=f12760200cad414fa3a3e7a5f650630f")
    //@GET("/weather?appid=f088bd2fd79d2a3bd64f622744ebdd9f")
    suspend fun getWeatherForecast(@Query("lat") lat : String,
                                   @Query("lon") lon : String
    ) : APIWeatherForecast

}