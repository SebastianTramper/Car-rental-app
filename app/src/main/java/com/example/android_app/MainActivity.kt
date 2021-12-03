package com.example.android_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.android_app.databinding.ActivityMainBinding
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
     lateinit var chipNavigationBar : ChipNavigationBar
     lateinit var constraint:CoordinatorLayout
//     lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val window = window
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        constraint=findViewById(R.id.coordinator)

        chipNavigationBar = findViewById(R.id.bottom_chipnavigationbar)
        chipNavigationBar.setItemSelected(R.id.nav_item_vehicles_overview, true)

        supportFragmentManager.beginTransaction().replace(R.id.root_layout, MainFragment()).commit()

        bottom_menu()
    }

    private fun bottom_menu() {
        chipNavigationBar.setOnItemSelectedListener {
            when(it) {
                R.id.nav_item_vehicles_overview -> {
                    supportFragmentManager.beginTransaction().replace(R.id.root_layout,MainFragment()).commit()
                }
                R.id.nav_item_account_signin ->{
                    supportFragmentManager.beginTransaction().replace(R.id.root_layout, MyAccount()).commit()
                }
                R.id.nav_item_registrations_overview ->{
                    supportFragmentManager.beginTransaction().replace(R.id.root_layout, MyRegistrationsOverview()).commit()
                }
            }
        }
    }
/*    private fun setupTabbar() {
        binding.bottomChipnavigationbar.setOnItemSelectedListener{
            when(it) {
                R.id.nav_item_vehicles_overview -> {
                    supportFragmentManager.beginTransaction().replace(R.id.)
                }
            }
        }
    }*/
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Overwrite AppBarConfiguration with the AppBarConfiguration with the graph of the NavController.... ???
        appBarConfiguration = AppBarConfiguration(navController.graph)
        //
        setupActionBarWithNavController(navController, appBarConfiguration)


        binding.menuBottom.setOnItemSelectedListener { id ->
            when (id) {
                R.id.VehicleFragment -> binding.viewpager.currentItem = 0
                R.id.registrations_title -> binding.viewpager.currentItem = 1
                R.id.myAccount -> binding.viewpager.currentItem = 2
            }

        }

*/
/*
        binding.viewpager.adapter = ViewPageAdapter(supportFragmentManager).apply {
            list = ArrayList<String>().apply {
                add("Vehicles")
                add("Registrations")
                add("Account")
            }
        }
*//*

    }
*/

/*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
*/

/*
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
*/
}