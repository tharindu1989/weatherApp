package com.test.weatherapp.feature.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.weatherapp.R
import com.test.weatherapp.repository.entity.DailyWeather
import com.test.weatherapp.repository.entity.ForeCastWeather
import com.test.weatherapp.util.ImageUtil

/**
 * Created By Tharindu on 7/12/2019
 *
 */
class WeatherViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.weather_list_layout, parent, false)) {

    var dateTxt: TextView? = null
    var startImg: ImageView? = null
    var endImg: ImageView? = null
    var minTempTxt: TextView? = null
    var maxTempTxt: TextView? = null

    init {
        dateTxt = itemView?.findViewById(R.id.dayTxt)
        minTempTxt = itemView?.findViewById(R.id.minTempTxt)
        maxTempTxt = itemView?.findViewById(R.id.maxTempTxt)
        startImg = itemView?.findViewById(R.id.startImg)
        endImg = itemView?.findViewById(R.id.endImg)
    }

    fun bindData(data: DailyWeather) {
        dateTxt?.text = data.day
        minTempTxt?.text = "${data.minTemp?.toInt()}°"
        maxTempTxt?.text = "${data.maxTemp?.toInt()}°"
        startImg?.setImageResource(ImageUtil.getImageByTitle(data.startWeather))
        endImg?.setImageResource(ImageUtil.getImageByTitle(data.endWeather))
    }

}