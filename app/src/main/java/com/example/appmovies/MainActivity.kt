package com.example.appmovies

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val barLayout = findViewById<AppBarLayout>(R.id.toolbarLayout)



        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)


        bottomNav.post {
            val navController = findNavController(R.id.fragmentContainerView)
            bottomNav.setupWithNavController(navController)

            navController.addOnDestinationChangedListener { _, destination, _ ->


                if (destination.id == R.id.telaInicial) {
                    bottomNav.visibility = View.GONE
                    barLayout.visibility = View.GONE
                } else {
                    bottomNav.visibility = View.VISIBLE
                    barLayout.visibility = View.VISIBLE
                }
            }
        }

        val toolbar = findViewById<Toolbar>( R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}