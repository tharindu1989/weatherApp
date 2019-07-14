package com.test.weatherapp.repository.entity

/**
 * Created By Tharindu on 7/14/2019
 *
 */
data class DailyWeather(
    val date : String,
    val temp : Double,
    val weather : String,
    val weatherDescription : String?=null
)