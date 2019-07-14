package com.test.weatherapp.feature.dashboard

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.weatherapp.R
import com.test.weatherapp.feature.BaseActivity
import com.test.weatherapp.feature.dashboard.adapter.DashboardAdapter
import com.test.weatherapp.feature.dashboard.adapter.TodayDataAdapter
import com.test.weatherapp.repository.entity.Weather
import com.test.weatherapp.util.DateUtil
import com.test.weatherapp.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : BaseActivity() {

    private var viewModel: DashboardViewModel? = null
    private var dashboardAdapter: DashboardAdapter? = null
    private var todayWeatherAdapter: TodayDataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        initialize()

        setObservers()

        setListener()
    }

    private fun initialize() {
        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        dashboardAdapter = DashboardAdapter()
        todayWeatherAdapter = TodayDataAdapter()
        weatherRv.apply {
            adapter = dashboardAdapter
            layoutManager = LinearLayoutManager(context)
        }

        todayRv.apply {
            adapter = todayWeatherAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        dateTxt?.text = DateUtil.getTodayFullDate()
        todayTxt.text = "${DateUtil.getToday()} TODAY"
        if (DateUtil.isDaylight()) {
            backgroundImg.imageTintList = ColorStateList.valueOf(resources.getColor(R.color.blue_70))
        } else {
            backgroundImg.imageTintList = ColorStateList.valueOf(resources.getColor(R.color.black_b2))
        }
    }

    private fun setObservers() {

        viewModel?.weatherDetails?.observe(this, Observer {
            setData(it)
        })
        viewModel?.error?.observe(this, Observer {
            showError(it)
        })
    }

    private fun setListener() {

    }

    private fun setData(weather: Weather) {

        val todayWeather = viewModel?.getTodayWeather() ?: arrayListOf()
        if (todayWeather?.size > 0) {
            tempTxt?.text = "${todayWeather?.first()?.temp?.toInt()}°"
            todayWeatherAdapter?.refreshData(todayWeather)
        }
        dashboardAdapter?.refreshData(viewModel?.get5DayForecast())
        cityTxt?.text = weather.city
    }
}
