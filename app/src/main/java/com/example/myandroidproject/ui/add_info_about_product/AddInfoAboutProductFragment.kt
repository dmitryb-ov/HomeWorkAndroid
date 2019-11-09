package com.example.myandroidproject.ui.add_info_about_product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.myandroidproject.R
import com.example.myandroidproject.ui.show_product_info.ShowProductInfoFragment
import kotlinx.android.synthetic.main.fragment_add_info_about_product.*

class AddInfoAboutProductFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_info_about_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_send.setOnClickListener {
            activity?.supportFragmentManager.also {
                it?.beginTransaction()?.apply {
                    //                    setCustomAnimations()
                    replace(R.id.nav_host_fragment, ShowProductInfoFragment.newInstance(editText_product_name.text.toString(),
                            editText_product_type.text.toString(),
                            editText_product_cost.text.toString()))
                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    val bundle = Bundle()
//                    bundle.putString("prod_name",editText_product_name.text.toString())
//                    bundle.putString("prod_type",editText_product_type.text.toString())
//                    bundle.putString("prod_price",editText_product_cost.text.toString())
                    addToBackStack(null).commit()
                }
            }
        }
    }

    companion object {
        private const val ARG = "sum"
        fun newInstance(sum: Int = 0): AddInfoAboutProductFragment = AddInfoAboutProductFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG, sum)
            }
        }
    }
}