package com.example.myandroidproject

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.dialog_add_citie.view.*
import kotlinx.android.synthetic.main.elements_fragment.*

class ElementsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.elements_fragment, container, false)

    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var citiesList: ArrayList<String> = ArrayList()
//        citiesList.add("One")
//        citiesList.add("Two")
//        citiesList.add("Three")
        var adapter: ArrayAdapter<String> = ArrayAdapter(view.context, android.R.layout.simple_list_item_multiple_choice, citiesList)
        val listView: ListView? = view.findViewById(R.id.cities_view)
        listView?.adapter = adapter
        fab.bringToFront()

        var deleteList: ArrayList<Int> = ArrayList()
        listView?.setOnItemClickListener { parent, view, position, id ->
            fab_delete.visibility = View.VISIBLE
            val chosen: SparseBooleanArray = (parent as ListView).checkedItemPositions
            for (i in 0..chosen.size()) {
                if (chosen.valueAt(i)) {
                    deleteList.add(i)
                }
            }
        }

        fab_delete.setOnClickListener {
            for (i in 0..deleteList.size - 1) {
                citiesList.removeAt(deleteList.get(i))
            }
            adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_multiple_choice, citiesList)
            listView?.adapter = adapter
            deleteList.clear()
            fab_delete.visibility = View.INVISIBLE
        }

        fab.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(view.context)
            Log.v(TAG, "Dfdddfdfd")
            val dView: View = LayoutInflater.from(view.context).inflate(R.layout.dialog_add_citie, null)
//            val inflater: LayoutInflater? = view.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
            builder.setView(dView)
                    .setPositiveButton(R.string.ok) { dialog, id ->
                        if (dView.city_number.text.toString() == "" || Integer.parseInt(dView.city_number.text.toString()) > citiesList.size) {
                            citiesList.add(dView.city_name.text.toString())
                        } else {
                            citiesList.add(Integer.parseInt(dView.city_number.text.toString()), dView.city_name.text.toString())
                        }
                    }
                    .setNegativeButton(R.string.cancel) { dialog, id ->
                        dialog.cancel()
                    }
            builder.create()
            builder.show()
        }
    }


}