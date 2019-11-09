package com.example.myandroidproject.ui.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myandroidproject.R

class BasketFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }

    companion object {
        private const val ARG = "sum"
        fun newInstance(sum: Int = 0): BasketFragment = BasketFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG, sum)
            }
        }
    }
}