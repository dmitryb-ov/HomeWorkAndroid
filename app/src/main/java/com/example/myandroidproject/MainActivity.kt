package com.example.myandroidproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.bottom_navigation.*

class MainActivity : AppCompatActivity() {


    private val testFragment: Fragment = TestFragment()
    private val elemenstFragment: Fragment = ElementsFragment()
    private val cardFragment: Fragment = CardFragment()
    private var activeFragment = testFragment
    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction().add(R.id.main_container, cardFragment, "3").hide(cardFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, elemenstFragment, "2").hide(elemenstFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_container, testFragment, "1").commit()



        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_test -> {
//                    supportFragmentManager.also {
//                        it.beginTransaction().apply {
//                            replace(R.id.bottom_navigation, TestFragment.newInstance())
//                            commit()
//                            true
//                        }
//                    }


                    //it`s good?
                    //can I use it? Or I must use "replace"?
                    fragmentManager.beginTransaction().hide(activeFragment).show(testFragment).commit()
                    activeFragment = testFragment
                    true
                }
                R.id.action_elements -> {
//                    supportFragmentManager.also {
//                        it.beginTransaction().apply {
//                            replace(R.id.bottom_navigation, ElementsFragment.newInstance())
//                            commit()
//                            true
//                        }
//                    }
                    fragmentManager.beginTransaction().hide(activeFragment).show(elemenstFragment).commit()
                    activeFragment = elemenstFragment
                    true
                }
                R.id.action_card -> {
//                    supportFragmentManager.also {
//                        it.beginTransaction().apply {
//                            replace(R.id.bottom_navigation, CardFragment.newInstance())
//                            commit()
//                            true
//                        }
//                    }
                    fragmentManager.beginTransaction().hide(activeFragment).show(cardFragment).commit()
                    activeFragment = cardFragment
                    true
                }
                else -> false
            }

        }

        bottom_navigation.setOnNavigationItemReselectedListener { }


    }
}
