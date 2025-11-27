package com.example.appmovies

import kotlin.collections.find

class EmBreveRepositorio {


    data class GrupoSessao(val tipoSessao : String, val local : String , val sala : String, val endereco : String, val horarios: List<String>)
    data class Filme(val codigo : Int, val nome : String, val sinopse : String, val imagem : Int, val sessoes : List<GrupoSessao>)

    private val listFilme: List<Filme> = listOf(

        Filme(
            1,
            "Wicked 2",
            "Após os eventos que abalaram Oz, Elphaba e Glinda enfrentam as consequências de suas escolhas, enquanto antigas alianças se rompem e novos perigos surgem em meio à luta entre magia, poder e amizade.",
            R.drawable.wicked,
            sessoes = listOf(

                GrupoSessao("Dub", "Shopping Morumbi", "Sala 5", "Av. Roque Petroni Júnior, 1089 - Jardim das Acácias, São Paulo - SP, 04707-900", horarios = listOf("19:00", "21:45")),

                GrupoSessao("Leg", "Shopping Morumbi", "Sala 8", "Av. Roque Petroni Júnior, 1089 - Jardim das Acácias, São Paulo - SP, 04707-900", horarios = listOf("20:30"))
            )
        ),
        Filme(
            2,
            "Truque de Mestre: O 3º Ato",
            "Os Quatro Cavaleiros retornam para sua performance mais ousada, enfrentando um inimigo misterioso que os desafia a superar seus próprios limites e a descobrir quem realmente controla o jogo.",
            R.drawable.truque,
            sessoes = listOf(
                GrupoSessao("Leg", "Shopping Eldorado", "Sala 2", "Av. Rebouças, 3970 - Pinheiros, São Paulo - SP, 05402-600", horarios = listOf("20:30"))
            )
        ),
        Filme(
            3,
            "Sombras no Deserto",
            "Em meio ao calor escaldante e segredos enterrados na areia, um grupo de exploradores descobre algo que jamais deveria ter sido revelado, desencadeando forças que testam a sanidade e a sobrevivência de todos.",
            R.drawable.sombras,
            sessoes = listOf(
                GrupoSessao("Leg", "Shopping JK Iguatemi", "Sala 3", "Av. Pres. Juscelino Kubitschek, 2041 - Vila Olímpia, São Paulo - SP, 04543-011", horarios = listOf("22:00"))
            )
        ),
        Filme(
            4,
            "Eddington",
            "Baseado em fatos reais, o filme acompanha o astrônomo Arthur Eddington em sua busca por provar a teoria da relatividade de Einstein, enfrentando o ceticismo científico e o caos da Primeira Guerra Mundial.",
            R.drawable.edd,
            sessoes = listOf(
                GrupoSessao("Dub", "Shopping Pátio Higienópolis", "Sala 1", "Av. Higienópolis, 618 - Higienópolis, São Paulo - SP, 01238-000", horarios = listOf("17:00", "19:45"))
            )
        ),
        Filme(
            5,
            "Silvio Santos Vem Aí",
            "A trajetória de Senor Abravanel, o homem por trás do ícone Silvio Santos, desde vendedor de rua até se tornar um dos maiores apresentadores e empresários da televisão brasileira.",
            R.drawable.silvio,
            sessoes = listOf(
                GrupoSessao("Dub", "Shopping Center Norte", "Sala 8", "Travessa Casalbuono, 120 - Vila Guilherme, São Paulo - SP, 02049-000", horarios = listOf("16:30", "19:15"))
            )
        )


    )
    fun getFilme(id: Int): Filme?{
        return listFilme.find { it.codigo == id }
    }
}
