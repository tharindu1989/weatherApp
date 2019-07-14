package com.test.weatherapp.feature.dashboard

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.weatherapp.R
import com.test.weatherapp.feature.BaseActivity
import com.test.weatherapp.feature.dashboard.adapter.DashboardAdapter
import com.test.weatherapp.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : BaseActivity() {

    private var viewModel: DashboardViewModel? = null
    private var dashboardAdapter: DashboardAdapter? = null

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
        weatherRv.apply {
            adapter = dashboardAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setObservers() {

        viewModel?.weatherDetails?.observe(this, Observer {
            dashboardAdapter?.refreshData(it?.list)
        })
        viewModel?.error?.observe(this, Observer {
            showError(it)
        })
    }

    private fun setListener() {

    }
}
