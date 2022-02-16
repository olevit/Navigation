package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment: NavHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = navHostFragment.navController
        setupBottomNavMenu(navController)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            Navigation.findNavController(this, R.id.nav_host_fragment))
                || super.onOptionsItemSelected(item)

        // Другой вариант
        //import androidx.navigation.findNavController
        //import androidx.navigation.ui.onNavDestinationSelected

        //val navController = findNavController(R.id.nav_host_fragment)
        //return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNavigation?.setupWithNavController(navController)
    }
}