package com.example.appmovies

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Detalhes : AppCompatActivity() {

    private val chave_id = "filme_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val filmeId = intent.getIntExtra(chave_id, -1)
        val busca = BuscarDetalhes()

        val filmeCompleto = busca.getDetalhe(filmeId)

        if(filmeCompleto != null) {
            val img = findViewById<ImageView>(R.id.imgFilme)
            val titulo = findViewById<TextView>(R.id.titulo)
            val sinopse = findViewById<TextView>(R.id.sinopse)
            img.setImageResource(filmeCompleto.img)
            titulo.text = filmeCompleto.titulo
            sinopse.text = filmeCompleto.sinopse
        } else{
            val toast = Toast.makeText(this, "Erro ao carregar a página", Toast.LENGTH_SHORT)
            toast.show()
            finish()
        }




    }
}