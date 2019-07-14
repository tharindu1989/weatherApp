package com.test.weatherapp.repository.entity

/**
 * Created By Tharindu on 7/14/2019
 *
 */
data class ForeCastWeather(
    val date: String,
    val temp: Double,
    val minTemp: Double,
    val maxTemp: Double,
    val weather: String,
    val weatherDescription: String? = null,
    val time: String? = null
)