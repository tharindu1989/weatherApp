package com.test.weatherapp.feature.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.weatherapp.R
import com.test.weatherapp.repository.entity.ForeCastWeather
import com.test.weatherapp.util.ImageUtil

/**
 * Created By Tharindu on 7/12/2019
 *
 */
class TodayWeatherViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.today_weather_list_layout, parent, false)) {

    var titleTxt: TextView? = null
    var tempTxt: TextView? = null
    var imageIconImg: ImageView? = null

    init {
        titleTxt = itemView?.findViewById(R.id.titleTxt)
        tempTxt = itemView?.findViewById(R.id.tempTxt)
        imageIconImg = itemView?.findViewById(R.id.weatherImg)
    }

    fun bindData(data: ForeCastWeather) {
        titleTxt?.text = data.time
        tempTxt?.text = "${data.temp?.toInt()}°"
        imageIconImg?.setImageResource(ImageUtil.getImageByTitle(data.weather))
    }

}