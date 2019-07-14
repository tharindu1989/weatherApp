package com.test.weatherapp

import com.test.weatherapp.extention.toDate
import org.junit.Assert
import org.junit.Test

/**
 * Created By Tharindu on 7/14/2019
 *
 */
class DateUnitTest {
    @Test
    fun test_date() {
        // Given
        val dateTimeStamp : Long = 1563105600
        val dateString = "2019-07-14"

        // when
        val res = dateTimeStamp.toDate()

        //then
        Assert.assertEquals(dateString,res)
    }
}