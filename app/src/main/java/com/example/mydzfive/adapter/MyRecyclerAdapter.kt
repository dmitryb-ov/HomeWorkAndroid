package com.example.mydzfive.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydzfive.CitiesClass
import com.example.mydzfive.DetailActivity
import com.example.mydzfive.R

class MyRecyclerAdapter(private val values: List<CitiesClass>) :
    RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent?.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.textView?.text = values[position].name
        holder?.imageView?.setImageResource(values[position].img)
        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("cityName", values[position].name)
            intent.putExtra("img", values[position].img)
            intent.putExtra("description", values[position].description)
            v?.context?.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var textView: TextView? = itemView?.findViewById(R.id.text_list_item)
        var imageView: ImageView? = itemView?.findViewById(R.id.recycler_image)

    }
}