package com.tikslab.bonchcab

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_table,
                R.id.navigation_grading,
                R.id.navigation_settings,
                R.id.navigation_auth
            )
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_table -> showBottomNav()
                R.id.navigation_grading -> showBottomNav()
                R.id.navigation_settings -> showBottomNav()
                else -> hideBottomNav()
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    fun navigateToHomeFragment() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_logIn_to_navigation_home)
    }

    fun navigateToAuthFragment() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_navigation_log_out)
    }

    private fun showBottomNav() {
        navView.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        navView.visibility = View.GONE

    }
}
