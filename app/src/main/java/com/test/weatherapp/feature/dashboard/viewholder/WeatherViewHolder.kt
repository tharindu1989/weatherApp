package com.test.weatherapp.feature.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.weatherapp.R
import com.test.weatherapp.repository.entity.DailyWeather

/**
 * Created By Tharindu on 7/12/2019
 *
 */
class WeatherViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.weather_list_layout, parent, false)) {

    var dateTxt: TextView? = null

    init {
        dateTxt = itemView?.findViewById(R.id.dateTxt)
    }


    fun bindData(data: DailyWeather) {
        dateTxt?.text = data.date
    }

}