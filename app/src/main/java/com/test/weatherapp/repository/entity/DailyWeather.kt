package com.test.weatherapp.repository.entity

/**
 * Created By Tharindu on 7/14/2019
 *
 */
data class DailyWeather(
    var day: String? = null,
    var startWeather: String? = null,
    var endWeather: String? = null,
    var minTemp: Double? = null,
    var maxTemp: Double? = null
)