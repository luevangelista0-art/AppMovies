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

        ViewCompat.setOnApplyWindowInsetsListener(barLayout) {view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.updatePadding(
                top = systemBarsInsets.top
            )
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)


        bottomNav.post {
            val navController = findNavController(R.id.fragmentContainerView)
            bottomNav.setupWithNavController(navController)

            navController.addOnDestinationChangedListener { _, destination, _ ->

                // NOVO CÓDIGO AQUI:

                // O ID do Fragment de login (definido no seu nav_graph.xml)
                if (destination.id == R.id.telaInicial) { // Substitua R.id.loginFragment pelo ID correto do seu Fragment inicial
                    // Esconde as duas barras
                    bottomNav.visibility = View.GONE
                    barLayout.visibility = View.GONE
                } else {
                    // Mostra as duas barras em qualquer outro Fragment
                    bottomNav.visibility = View.VISIBLE
                    barLayout.visibility = View.VISIBLE
                }
            }
        }

        val toolbar = findViewById<Toolbar>( R.id.toolbar)

        setSupportActionBar(toolbar)



    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}