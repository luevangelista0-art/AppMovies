package com.example.appmovies

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast // Mantido, caso você queira adicionar a lógica de Toast/EditText depois
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.apply



class TelaInicial : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_inicial)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnSave = findViewById<Button>(R.id.btnTelaFilmes);
        btnSave.setOnClickListener {
            var nomeText = findViewById<EditText>(R.id.editTextNome).text;
            if (nomeText.isEmpty()) {
                Toast.makeText(this, "Digite seu nome", Toast.LENGTH_LONG).show()
            } else {
                this.getSharedPreferences(
                    "motivacao",MODE_PRIVATE).edit().putString("nome", nomeText.toString()).apply()
                var intent = Intent(this, EmCartaz::class.java)
                startActivity(intent)

            }

        }
    }
}