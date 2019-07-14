package com.test.weatherapp.extention

import com.test.weatherapp.config.AppConfig.DATE_FORMAT
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created By Tharindu on 7/14/2019
 *
 */
fun Long?.toDate(): String {

    val sdf = SimpleDateFormat(DATE_FORMAT)
    try {
        this?.let {
            val date = Date(it * 1000) // to milliseconds
            return sdf.format(date)
        } ?: run {
            return "N/A"
        }
    } catch (ex: Exception) {
        return "N/A"
    }
}

fun Long?.toTime(): String {

    val sdf = SimpleDateFormat("hh a")
    try {
        this?.let {
            val date = Date(it * 1000) // to milliseconds
            return sdf.format(date).toUpperCase()
        } ?: run {
            return "N/A"
        }
    } catch (ex: Exception) {
        return "N/A"
    }
}
