package com.example.appmovies

import com.example.appmovies.FilmeRepositorio.Filme
import kotlin.collections.find

class Modo {

    data class audioTipo(val id : Int, val descri : String)

        private val modoFilme: List<audioTipo> = listOf(
            audioTipo(1, "DUB"),
            audioTipo(2, "LEG")
        )

        fun getTipo(value : Int) : audioTipo?{
            return modoFilme.find { it.id == value }
        }


}