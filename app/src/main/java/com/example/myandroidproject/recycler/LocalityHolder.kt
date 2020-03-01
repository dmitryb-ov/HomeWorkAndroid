package com.example.myandroidproject.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidproject.MainActivity
import com.example.myandroidproject.data.WeatherResponse
import com.example.networkapp.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.*

class LocalityHolder(
    override val containerView: View,
    private val clickLambda: (WeatherResponse) -> Unit
) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    @SuppressLint("ResourceAsColor")
    fun bind(weather: WeatherResponse) {
        val tempInC = weather.main?.temp
        if (tempInC != null) {
            if (tempInC > 0.0) {
                if (tempInC > 10.0) {
                    if (tempInC > 20.0) {
                        tv_locality_temp.setTextColor(R.color.veryHot)
                        tv_locality_name.setTextColor(R.color.veryHot)
                        MainActivity.color = R.color.veryHot
                    } else {
                        tv_locality_name.setTextColor(R.color.mediumHot)
                        tv_locality_temp.setTextColor(R.color.mediumHot)
                        MainActivity.color = R.color.mediumHot
                    }
                } else {
                    tv_locality_name.setTextColor(R.color.normal)
                    tv_locality_temp.setTextColor(R.color.normal)
                    MainActivity.color = R.color.normal
                }
            } else {
                if (tempInC < -10.0) {
                    if (tempInC < -20.0) {
                        tv_locality_name.setTextColor(R.color.veryCold)
                        tv_locality_temp.setTextColor(R.color.veryCold)
                        MainActivity.color = R.color.veryCold
                    } else {
                        tv_locality_name.setTextColor(R.color.mediumCold)
                        tv_locality_temp.setTextColor(R.color.mediumCold)
                        MainActivity.color = R.color.mediumCold
                    }
                } else {
                    tv_locality_temp.setTextColor(R.color.winter)
                    tv_locality_name.setTextColor(R.color.winter)
                    MainActivity.color = R.color.winter
                }
            }
        }
        tv_locality_name.text = weather.name
        tv_locality_temp.text = tempInC?.toInt().toString()

        itemView.setOnClickListener {
            clickLambda(weather)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (WeatherResponse) -> Unit) =
            LocalityHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item,
                    parent,
                    false
                ),
                clickLambda
            )
    }
}