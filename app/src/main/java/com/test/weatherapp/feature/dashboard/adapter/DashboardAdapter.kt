package com.test.weatherapp.feature.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.weatherapp.feature.dashboard.viewholder.WeatherViewHolder
import com.test.weatherapp.repository.entity.Weather

/**
 * Created By Tharindu on 7/12/2019
 *
 */
class DashboardAdapter : RecyclerView.Adapter<WeatherViewHolder>() {

    var itemList: ArrayList<Weather> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WeatherViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val data = itemList[position]
        holder.bindData(data)

    }
}