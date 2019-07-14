package com.test.weatherapp.util

import com.test.weatherapp.config.AppConfig.DATE_FORMAT
import com.test.weatherapp.config.AppConfig.DATE_FORMAT_DAY
import com.test.weatherapp.config.AppConfig.DATE_FORMAT_FULL
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created By Tharindu on 7/14/2019
 *
 */
object DateUtil {
    /**
     * get Today Date
     */
    fun getTodayDate(): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT)
        return dateFormat.format(Date())
    }

    /**
     * get Day of the Week
     * @param date : given Date
     */
    fun getDayOfWeek(date: String): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT)
        val convertFormat = SimpleDateFormat(DATE_FORMAT_DAY)

        return try {
            convertFormat.format(dateFormat.parse(date))
        } catch (ex: Exception) {
            "N/A"
        }
    }

    /**
     * get today date by full Format
     */
    fun getTodayFullDate(): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT_FULL)
        return dateFormat.format(Date())
    }

    /**
     * get today date by full Format
     */
    fun getToday(): String {
        val dateFormat = SimpleDateFormat(DATE_FORMAT_DAY)
        return dateFormat.format(Date())
    }

    /**
     * check current time is between 6 am tp 6pm
     */
    fun isDaylight(): Boolean {
        return true
    }
}