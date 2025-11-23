package com.example.appmovies

import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity // Importação correta da classe pai
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
// Importações de Fragment, Button, EditText e Toast não são necessárias nesta Activity, mas foram mantidas
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class EmCartaz : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.fragment_em_cartaz)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragCartaz)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nome = findViewById<TextView>(R.id.saldacao)
        val nomeRecuperacao = getSharedPreferences("motivacao", Context.MODE_PRIVATE)
            .getString("nome", "Seja Bem Vindo")
            nome.text = "Olá, $nomeRecuperacao"
            }
        }







