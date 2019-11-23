package com.example.myandroidproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.card_view.view.*

class Adapter(val listComp: List<CardViewComponents>, val context: Context) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return listComp.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.card_view, container, false) as ViewGroup

        layout.card_image_view.setImageResource(listComp.get(position).image)
        layout.card_text_view.text = listComp.get(position).title
        layout.description.text = listComp.get(position).description
        layout.image_ava.setImageResource(listComp.get(position).ava)

        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}