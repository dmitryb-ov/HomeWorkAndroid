package com.example.myandroidproject

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.dialog_add_citie.view.*
import kotlinx.android.synthetic.main.elements_fragment.*


class ElementsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.elements_fragment, container, false)

    }


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var citiesList: ArrayList<CityComponents> = ArrayList()
        val listView: ListView? = view.findViewById(R.id.cities_view)
//        citiesList.add(CityComponents("Kazan", "DESK"))
//        citiesList.add(CityComponents("KazanNNN", "DESKLKK"))

        var adapter = CityAdapter(view.context, citiesList)
        listView?.adapter = adapter

        fab.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(view.context)
            val dView: View = LayoutInflater.from(view.context).inflate(R.layout.dialog_add_citie, null)
//            val inflater: LayoutInflater? = view.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
            builder.setView(dView)
                    .setPositiveButton(R.string.ok) { dialog, id ->
                        if (dView.city_number.text.toString() == "" || Integer.parseInt(dView.city_number.text.toString()) > citiesList.size) {
                            citiesList.add(CityComponents(dView.city_name.text.toString(), dView.city_description.text.toString()))
                        } else {
                            if (Integer.parseInt(dView.city_number.text.toString()) - 1 <= 0) {
                                citiesList.add(0, CityComponents(dView.city_name.text.toString(), dView.city_description.text.toString()))
                            } else {
                                citiesList.add(Integer.parseInt(dView.city_number.text.toString()) - 1, CityComponents(dView.city_name.text.toString(), dView.city_description.text.toString()))
                            }
                        }
                    }
                    .setNegativeButton(R.string.cancel) { dialog, id ->
                        dialog.cancel()
                    }
            builder.create()
            builder.show()
        }

        listView?.setOnItemClickListener { parent, view, position, id ->
            val builder: AlertDialog.Builder = AlertDialog.Builder(view.context)
            builder.setTitle("Удалить?")
            builder.setPositiveButton("Удалить") { dialog, id ->
                citiesList.removeAt(position)
                adapter.notifyDataSetChanged()
                Toast.makeText(activity, "Удалено", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("Не удаляй") { dialog, id ->
                Toast.makeText(activity, "Отлично", Toast.LENGTH_LONG).show()
            }
            builder.setCancelable(true)
            builder.show()
        }
    }


}