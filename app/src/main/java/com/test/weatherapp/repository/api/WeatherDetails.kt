package com.test.weatherapp.repository.api

import android.location.Location
import com.test.weatherapp.config.AppConfig
import com.test.weatherapp.enums.RequestType
import com.test.weatherapp.extention.toDate
import com.test.weatherapp.extention.toTime
import com.test.weatherapp.repository.entity.DailyWeather
import com.test.weatherapp.repository.entity.ForeCastWeather
import com.test.weatherapp.repository.entity.Weather
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Created By Tharindu on 7/12/2019
 *
 */
class WeatherDetails {

    /**
     * get Weather Forecast by Location
     * @param location : Current Location
     */
    fun getWeatherDetails(
        location: Location,
        onSuccess: (weather: Weather) -> Unit,
        onError: () -> Unit
    ) {
        val url = "forecast?lat=${location.latitude}&lon=${location.longitude}&units=metric&APPID=${AppConfig.API_KEY}"
        ApiRouter().callApi(url, RequestType.GET, null, {

            try {

                val jsonObj = JSONObject(it)
                val cod = jsonObj.getInt("cod")
                val cnt = jsonObj.getInt("cnt")
                val message = jsonObj.getString("message")
                val city = jsonObj?.getJSONObject("city")?.getString("name")
                val list = arrayListOf<ForeCastWeather>()

                val jsonArray: JSONArray = jsonObj.getJSONArray("list")

                for (i in (0 until jsonArray.length())) {

                    val jsonObj = jsonArray.getJSONObject(i)
                    val timestamp = jsonObj.getLong("dt")
                    val date = timestamp?.toDate()
                    val temp = jsonObj.getJSONObject("main")?.getDouble("temp") ?: 0.0
                    val minTemp = jsonObj.getJSONObject("main")?.getDouble("temp_min") ?: 0.0
                    val maxTemp = jsonObj.getJSONObject("main")?.getDouble("temp_max") ?: 0.0
                    val weatherStr = jsonObj.getJSONArray("weather").getJSONObject(0)?.getString("main") ?: ""
                    val weatherDes = jsonObj.getJSONArray("weather").getJSONObject(0)?.getString("description") ?: ""

                    val foreCast = ForeCastWeather(
                        date = date,
                        temp = temp,
                        minTemp = minTemp,
                        maxTemp = maxTemp,
                        weather = weatherStr,
                        weatherDescription = weatherDes,
                        time = timestamp?.toTime()
                    )
                    list.add(foreCast)

                }


                var weather = Weather(
                    cod = cod,
                    cnt = cnt,
                    message = message,
                    list = list,
                    city = city ?: "N/A"
                )
                onSuccess.invoke(weather)
            } catch (ex: JSONException) {
                onError.invoke()
            }
        }, {
            onError.invoke()
        })
    }
}