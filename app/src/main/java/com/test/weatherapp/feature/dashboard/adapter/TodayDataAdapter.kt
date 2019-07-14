package com.test.weatherapp.feature.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.weatherapp.feature.dashboard.viewholder.TodayWeatherViewHolder
import com.test.weatherapp.repository.entity.ForeCastWeather

/**
 * Created By Tharindu on 7/14/2019
 *
 */
class TodayDataAdapter : RecyclerView.Adapter<TodayWeatherViewHolder>() {

    var itemList: ArrayList<ForeCastWeather> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayWeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TodayWeatherViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TodayWeatherViewHolder, position: Int) {
        val data = itemList[position]
        holder.bindData(data)

    }

    /**
     * refresh Adapter with new Data
     * @param items : New Items
     */
    fun refreshData(items: ArrayList<ForeCastWeather>?) {
        items?.let {
            itemList = it
            notifyDataSetChanged()
        }
    }
}