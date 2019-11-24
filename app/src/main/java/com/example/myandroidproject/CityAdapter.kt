package com.example.myandroidproject

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.Nullable


class CityAdapter(private val mContext: Context, list: ArrayList<CityComponents>) : ArrayAdapter<CityComponents>(mContext, R.layout.simple_list_item_multiple_choice, list) {
    private var cityList = ArrayList<CityComponents>()

    init {
        cityList = list
    }

    override fun getView(position: Int, @Nullable convertView: View?, parent: ViewGroup): View {
        var listItem = convertView
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(com.example.myandroidproject.R.layout.my_list_item, parent, false)
        }

        val currentCity = cityList.get(position)

        val name = listItem?.findViewById(com.example.myandroidproject.R.id.name) as TextView
        name.text = currentCity.cityName

        val desc = listItem.findViewById(com.example.myandroidproject.R.id.desc) as TextView
        desc.text = currentCity.cityDescription

        return listItem
    }
}