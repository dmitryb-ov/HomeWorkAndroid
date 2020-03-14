package com.example.myandroidproject.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidproject.Util
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
        tv_locality_name.text = weather.name
        tv_locality_name.setTextColor(
            ContextCompat.getColor(
                containerView.context,
                Util.setTextColorForTemp(tempInC)
            )
        )
        tv_locality_temp.text = tempInC?.toInt().toString()
        tv_locality_temp.setTextColor(
            ContextCompat.getColor(
                containerView.context,
                Util.setTextColorForTemp(tempInC)
            )
        )

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
