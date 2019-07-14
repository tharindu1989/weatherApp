package com.test.weatherapp.viewmodel

import android.app.Application
import android.location.Location
import androidx.lifecycle.MutableLiveData
import com.test.weatherapp.repository.WeatherRepository
import com.test.weatherapp.repository.entity.Weather

/**
 * Created By Tharindu on 7/12/2019
 *
 */
class DashboardViewModel : BaseViewModel {
    constructor(application: Application) : super(application)

    val weatherDetails: MutableLiveData<Weather> by lazy {
        MutableLiveData<Weather>().also {
            getWeather()
        }
    }

    // get Weather Data from Repository
    fun getWeather() {
        val location = Location("me")
        location.latitude = 35.0
        location.longitude = 135.0

        WeatherRepository().getWeatherDetails(location, {
            weatherDetails.value = it
        }, {
            onError("Network Error")
        })
    }
}