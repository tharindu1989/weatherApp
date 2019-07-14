package com.test.weatherapp.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.test.weatherapp.R
import com.test.weatherapp.viewmodel.DashboardViewModel

class MainActivity : AppCompatActivity() {

    var viewModel: DashboardViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        viewModel?.weatherDetails?.observe(this, Observer {
            Log.e("DATA", it.toString())
        })
    }
}
