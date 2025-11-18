package com.example.appmovies

import com.example.appmovies.Modo.audioTipo
import kotlin.collections.find

class LocalRepositorio {

    data class LocalFilme(val id : Int, val shopping : String, val endereco : String, val sala : Int, val horario : String)

    private val listaLocal: List<LocalFilme> = listOf(
        LocalFilme(
            1,
            "Aricanduva",
            "Av. Aricanduva, 5555 - Vila Matilde CEP: 03527-900 - São Paulo - Brasil",
            11,
            "19:30"
        )
    )

    fun getLocal(id : Int) : LocalFilme?{
        return listaLocal.find { it.id == id }
    }
}