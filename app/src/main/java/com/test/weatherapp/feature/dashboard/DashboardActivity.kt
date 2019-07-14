package com.test.weatherapp.feature.dashboard

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.test.weatherapp.R
import com.test.weatherapp.feature.BaseActivity
import com.test.weatherapp.viewmodel.DashboardViewModel

class DashboardActivity : BaseActivity() {

    private var viewModel: DashboardViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        viewModel?.weatherDetails?.observe(this, Observer {
            Log.e("DATA", it.toString())
        })
        viewModel?.error?.observe(this, Observer {
            showError(it)
        })
    }
}
