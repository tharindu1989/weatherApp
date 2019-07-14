package com.test.weatherapp.repository.entity

/**
 * Created By Tharindu on 7/12/2019
 *
 */
data class Weather(
    val cod: Int,
    val message: String,
    val cnt: Int,
    val list: ArrayList<DailyWeather>
)