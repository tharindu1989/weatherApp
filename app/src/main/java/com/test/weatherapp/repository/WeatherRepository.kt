package com.test.weatherapp.repository

import android.location.Location
import com.test.weatherapp.repository.api.WeatherDetails
import com.test.weatherapp.repository.entity.Weather

/**
 * Created By Tharindu on 7/12/2019
 * Repository will handle the Data, Which will retrieve from APi or DB
 *
 */

class WeatherRepository {

    /**
     * get Weather From Repository or DB
     */
    fun getWeatherDetails(
        location: Location,
        onSuccess: (weather: Weather) -> Unit,
        onError: () -> Unit
    ) {

        WeatherDetails().getWeatherDetails(
            location = location,
            onSuccess = onSuccess,
            onError = {
                // Further Implementation for get data, if Network API failed and DB have cache data
                onError.invoke()
            })
    }

}