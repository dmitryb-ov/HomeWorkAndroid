package com.example.myandroidproject.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroidproject.data.WeatherResponse

class Adapter(
    var localityList: List<WeatherResponse>,
    private val clickLambda: (WeatherResponse) -> Unit
) : RecyclerView.Adapter<LocalityHolder>() {
    override fun getItemCount() = localityList.size

    override fun onBindViewHolder(holder: LocalityHolder, position: Int) =
        holder.bind(localityList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalityHolder =
        LocalityHolder.create(parent, clickLambda)


}
