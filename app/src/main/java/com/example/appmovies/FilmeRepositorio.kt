package com.example.appmovies

import kotlin.collections.find

class FilmeRepositorio {

    data class Filme(val codigo : Int, val nome : String, val sinopse : String, val imagem : Int)

    private val listFilme: List<Filme> = listOf(

        Filme(
            1,
            "Wicked 2",
            "Após os eventos que abalaram Oz, Elphaba e Glinda enfrentam as consequências de suas escolhas, enquanto antigas alianças se rompem e novos perigos surgem em meio à luta entre magia, poder e amizade.",
            R.drawable.wicked

        ),
        Filme(
            2,
            "Truque de Mestre: O 3º Ato",
            "Os Quatro Cavaleiros retornam para sua performance mais ousada, enfrentando um inimigo misterioso que os desafia a superar seus próprios limites e a descobrir quem realmente controla o jogo.",
            R.drawable.truque
        ),
        Filme(
            3,
            "Sombras no Deserto",
            "Em meio ao calor escaldante e segredos enterrados na areia, um grupo de exploradores descobre algo que jamais deveria ter sido revelado, desencadeando forças que testam a sanidade e a sobrevivência de todos.",
            R.drawable.sombras
        ),
        Filme(
            4,
            "Eddington",
            "Baseado em fatos reais, o filme acompanha o astrônomo Arthur Eddington em sua busca por provar a teoria da relatividade de Einstein, enfrentando o ceticismo científico e o caos da Primeira Guerra Mundial.",
            R.drawable.edd
        ),
        Filme(
            5,
            "Silvio Santos Vem Aí",
            "A trajetória de Senor Abravanel, o homem por trás do ícone Silvio Santos, desde vendedor de rua até se tornar um dos maiores apresentadores e empresários da televisão brasileira.",
            R.drawable.silvio
        )


    )
    fun getFilme(id: Int): Filme?{
        return listFilme.find { it.codigo == id }
    }
}