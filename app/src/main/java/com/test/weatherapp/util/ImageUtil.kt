package com.test.weatherapp.util

import com.test.weatherapp.R

/**
 * Created By Tharindu on 7/14/2019
 *
 */
object ImageUtil {

    fun getImageByTitle(title: String?): Int {

        return when (title) {
            "Thunderstorm" -> {
                R.drawable.ic_021_storm
            }
            "Drizzle" -> {
                R.drawable.ic_021_rain
            }
            "Rain" -> {
                R.drawable.ic_021_rain_2
            }
            "Snow" -> {
                R.drawable.ic_021_snowing_1
            }
            "Clear" -> {
                R.drawable.ic_021_sun
            }
            "Clouds" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Mist" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Smoke" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Haze" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Dust" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Fog" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Sand" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Ash" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Squall" -> {
                R.drawable.ic_021_cloudy_1
            }
            "Tornado" -> {
                R.drawable.ic_021_tornado
            }
            else -> {
                R.drawable.ic_021_cloudy_1
            }
        }
    }
}