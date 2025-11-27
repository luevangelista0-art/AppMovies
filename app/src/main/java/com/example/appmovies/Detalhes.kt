package com.example.appmovies

import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovies.recyclerview.adapter.HorariosAdapter

class Detalhes : AppCompatActivity() {

    private val chave_id = "filme_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)

        val filmeId = intent.getIntExtra(chave_id, -1)
        val busca = DetalhesRepositorio()

        val filmeCompleto = busca.getDetalhe(filmeId)

        if(filmeCompleto != null) {
            val img = findViewById<ImageView>(R.id.imgFilme)
            val titulo = findViewById<TextView>(R.id.titulo)
            val sinopse = findViewById<TextView>(R.id.sinopse)
            img.setImageResource(filmeCompleto.img)
            titulo.text = filmeCompleto.titulo
            sinopse.text = filmeCompleto.sinopse

            val recycler = findViewById<RecyclerView>(R.id.recyclerView)

            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recycler.layoutManager = layoutManager


            val adapter = HorariosAdapter(this, filmeCompleto.sessoes)
            recycler.adapter = adapter

        } else{
            val toast = Toast.makeText(this, "Erro ao carregar a página", Toast.LENGTH_SHORT)
            toast.show()
            finish()
        }

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
