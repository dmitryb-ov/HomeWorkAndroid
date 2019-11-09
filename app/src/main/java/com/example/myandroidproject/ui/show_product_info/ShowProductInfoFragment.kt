package com.example.myandroidproject.ui.show_product_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myandroidproject.R
import kotlinx.android.synthetic.main.fragment_show_product_info.*

class ShowProductInfoFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_product_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView_show_product_name.text = arguments?.getString(NAME)
        textView_show_product_type.text = arguments?.getString(TYPE)
        textView_show_product_price.text = arguments?.getString(PRICE)
    }

    companion object {
        private const val NAME = "prod_name"
        private const val TYPE = "prod_type"
        private const val PRICE = "prod_price"
        fun newInstance(prodName: String = "null", prodType: String = "null", prodPrice: String = "null"): ShowProductInfoFragment = ShowProductInfoFragment().apply {
            arguments = Bundle().apply {
                putString(NAME, prodName)
                putString(TYPE, prodType)
                putString(PRICE, prodPrice)
            }
        }
    }
}