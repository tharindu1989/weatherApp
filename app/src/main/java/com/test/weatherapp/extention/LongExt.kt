package com.test.weatherapp.extention

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created By Tharindu on 7/14/2019
 *
 */
fun Long?.toDate(): String {

    val sdf = SimpleDateFormat("yyyy-MM-dd")
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
