package com.example.mydzfive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_view.*

class CityHolder(override val containerView: View, private val clickLambda: (City) -> Unit) :
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(city: City) {
        recycler_image_city.setImageResource(city.img)
        text_list_item.text = city.name
        itemView.setOnClickListener {
            clickLambda(city)
        }
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (City) -> Unit) =
            CityHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false),
                clickLambda
            )
    }
}