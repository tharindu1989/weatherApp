package com.test.weatherapp.repository.api

import android.location.Location
import com.test.weatherapp.config.AppConfig
import com.test.weatherapp.enums.RequestType
import com.test.weatherapp.extention.toDate
import com.test.weatherapp.repository.entity.DailyWeather
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

        val url = "forecast?lat=${location.latitude}&lon=${location.longitude}&APPID=${AppConfig.API_KEY}"
        ApiRouter().callApi(url, RequestType.GET, null, {

            try {

                val jsonObj = JSONObject(it)
                val cod = jsonObj.getInt("cod")
                val cnt = jsonObj.getInt("cnt")
                val message = jsonObj.getString("message")
                val list = arrayListOf<DailyWeather>()
                val jsonArray: JSONArray = jsonObj.getJSONArray("list")

                for (i in (0 until jsonArray.length())) {

                    val jsonObj = jsonArray.getJSONObject(i)
                    val date = jsonObj.getLong("dt")?.toDate()
                    val temp = jsonObj.getJSONObject("main")?.getDouble("temp") ?: 0.0
                    val weatherStr = jsonObj.getJSONArray("weather").getJSONObject(0)?.getString("main") ?: ""
                    val weatherDes = jsonObj.getJSONArray("weather").getJSONObject(0)?.getString("description") ?: ""

                    val dailyWeather = DailyWeather(
                        date = date,
                        temp = temp,
                        weather = weatherStr,
                        weatherDescription = weatherDes
                    )

                    list.add(dailyWeather)

                }


                var weather = Weather(
                    cod = cod,
                    cnt = cnt,
                    message = message,
                    list = list
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