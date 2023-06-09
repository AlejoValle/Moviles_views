package com.example.senderos4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.senderos4.Fragment.ConfigurationFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationVIew: NavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var ButtonSetting: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()

        setSupportActionBar(toolbar)
        appBarConfiguration = AppBarConfiguration((navController.graph), drawerLayout)
        setupActionBarWithNavController(navController, drawerLayout)
        navigationVIew.setupWithNavController(navController)


        toolbar.setTitleTextColor(Color.TRANSPARENT)

    }


    private fun addListener() {
        ButtonSetting.setOnClickListener {

            navController.navigate(R.id.action_map_fragment_to_configurationFragment2)
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }


    fun bind() {
        toolbar = findViewById(R.id.myToolbar)
        drawerLayout = findViewById(R.id.drawer)
        navController = findNavController(R.id.fragmentContainerView)
        navigationVIew = findViewById(R.id.navigationView)

        val headerView = navigationVIew.getHeaderView(0)
        ButtonSetting = headerView.findViewById(R.id.setting_options)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }


    /*     drawerLayout.setOnClickListener {
             drawerLayout.open()

         }
         drawerLayout.close() */

}