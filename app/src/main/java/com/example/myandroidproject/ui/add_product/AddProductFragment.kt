package com.example.myandroidproject.ui.add_product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myandroidproject.R
import com.example.myandroidproject.ui.add_info_about_product.AddInfoAboutProductFragment
import kotlinx.android.synthetic.main.fragment_add_product.*

class AddProductFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_add_product.setOnClickListener {
            //            Log.i(TAG,"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFff")
            activity?.supportFragmentManager.also {
                it?.beginTransaction()?.apply {
                    setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right)
                    replace(R.id.nav_host_fragment, AddInfoAboutProductFragment.newInstance())
                    addToBackStack(null).commit()
                }
            }
        }
    }

    companion object {
        private const val ARG = "sum"
        fun newInstance(sum: Int = 0): AddProductFragment = AddProductFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG, sum)
            }
        }
    }
}