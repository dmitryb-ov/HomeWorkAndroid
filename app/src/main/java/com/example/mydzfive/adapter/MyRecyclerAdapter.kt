package com.example.mydzfive.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydzfive.City
import com.example.mydzfive.CityHolder

class MyRecyclerAdapter(
    var dataValues: List<City>,
    private val clickLambda: (City) -> Unit
) :
    RecyclerView.Adapter<CityHolder>() {

    override fun getItemCount() = dataValues.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder =
        CityHolder.create(parent, clickLambda)

    override fun onBindViewHolder(holder: CityHolder, position: Int) =
        holder.bind(dataValues[position])

}

