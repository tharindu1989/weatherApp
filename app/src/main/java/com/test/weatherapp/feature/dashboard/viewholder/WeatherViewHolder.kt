package com.test.weatherapp.feature.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.weatherapp.R
import com.test.weatherapp.repository.entity.Weather

/**
 * Created By Tharindu on 7/12/2019
 *
 */
class WeatherViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.weather_list_layout, parent, false)) {

    init {

    }


    fun bindData(data: Weather) {

    }

}