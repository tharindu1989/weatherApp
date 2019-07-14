package com.test.weatherapp.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.test.weatherapp.R
import com.test.weatherapp.viewmodel.DashboardViewModel

open class BaseActivity : AppCompatActivity() {

    /**
     * show Error message
     * @param message : Massage to Show
     */
    fun showError(message: String? = null) {
        val error = message?.let {
            it
        } ?: run {
            getString(R.string.error_message)
        }
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
}
