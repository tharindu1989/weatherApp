package com.test.weatherapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.test.weatherapp.feature.dashboard.DashboardActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created By Tharindu on 7/14/2019
 *
 */
@RunWith(AndroidJUnit4::class)
class DashboardTest {

    @get:Rule
    val activityTestRuler: ActivityTestRule<DashboardActivity> =
        ActivityTestRule<DashboardActivity>(DashboardActivity::class.java)

    @Test
    fun test_forecast_list(){

        IdlingRegistry.getInstance().register(activityTestRuler.activity.countingIdlingResource)
        onView(withId(R.id.weatherRv)).check(RecyclerViewItemCountAssertion())
    }

    @Test
    fun test_today_weather_list(){

        IdlingRegistry.getInstance().register(activityTestRuler.activity.countingIdlingResource)
        onView(withId(R.id.todayRv)).check(RecyclerViewItemCountAssertion())
    }
}