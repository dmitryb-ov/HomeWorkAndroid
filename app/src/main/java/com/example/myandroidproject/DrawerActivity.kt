package com.example.myandroidproject

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myandroidproject.ui.add_product.AddProductFragment
import com.example.myandroidproject.ui.basket.BasketFragment
import com.example.myandroidproject.ui.product.ProductFragment
import com.example.myandroidproject.ui.profile.ProfileFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_drawer.*

class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_profile, R.id.nav_product, R.id.nav_basket,
                R.id.nav_add_product), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()


        supportFragmentManager.also {
            it.beginTransaction().apply {
                replace(R.id.nav_host_fragment, ProfileFragment.newInstance())
                addToBackStack(ProfileFragment::class.java.name).commit()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_profile -> {
                supportFragmentManager.also {
                    it.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, ProfileFragment.newInstance())
                        addToBackStack(null).commit()
                    }
                }
            }

            R.id.nav_product -> {
                supportFragmentManager.also {
                    it.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, ProductFragment.newInstance())
                        addToBackStack(null).commit()
                    }
                }
            }

            R.id.nav_basket -> {
                supportFragmentManager.also {
                    it.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, BasketFragment.newInstance())
                        addToBackStack(null).commit()
                    }
                }
            }

            R.id.nav_add_product -> {
                supportFragmentManager.also {
                    it.beginTransaction().apply {
                        replace(R.id.nav_host_fragment, AddProductFragment.newInstance())
                        addToBackStack(null).commit()
                    }
                }
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        when {
            drawer.isDrawerOpen(GravityCompat.START) -> drawer.closeDrawer(GravityCompat.START)
            supportFragmentManager.backStackEntryCount > 0 -> supportFragmentManager.popBackStack()
            else -> super.onBackPressed()
        }
    }
}
