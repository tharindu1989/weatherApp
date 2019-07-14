package com.test.weatherapp.viewmodel

import android.app.Application
import android.location.Location
import androidx.lifecycle.MutableLiveData
import com.test.weatherapp.repository.WeatherRepository
import com.test.weatherapp.repository.entity.DailyWeather
import com.test.weatherapp.repository.entity.ForeCastWeather
import com.test.weatherapp.repository.entity.Weather
import com.test.weatherapp.util.DateUtil

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
    private fun getWeather() {
        val location = Location("me")
        location.latitude = 1.359805 // Singapore
        location.longitude = 103.878925 // Singapore

        WeatherRepository().getWeatherDetails(location, {
            weatherDetails.value = it
        }, {
            onError("Network Error")
        })
    }

    /**
     * get Today Weather
     */
    fun getTodayWeather(): ArrayList<ForeCastWeather>? {
        val today = DateUtil.getTodayDate()
        val items: ArrayList<ForeCastWeather> = weatherDetails.value?.list ?: arrayListOf()
        return items.filter { it.date == today } as? ArrayList<ForeCastWeather>
    }

    /**
     * get next 5 days Weather
     */
    fun get5DayForecast(): ArrayList<DailyWeather> {
        val listOfDailyWeather = arrayListOf<DailyWeather>()
        val dailyMap = weatherDetails.value?.list?.groupBy { it.date }
        dailyMap?.map {
            val dailyWeather = DailyWeather(
                day = DateUtil.getDayOfWeek(it.key),
                minTemp = it.value.first().minTemp,
                maxTemp = it.value.first().maxTemp,
                startWeather = it.value.first().weather,
                endWeather = it.value.last().weather
            )
            listOfDailyWeather.add(dailyWeather)
        }

        return listOfDailyWeather
    }
}