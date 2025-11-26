package com.example.appmovies

import com.example.appmovies.FilmeRepositorio.Filme
import kotlin.collections.find

class BuscarDetalhes {

    data class Sessao(val idSessao : Int, val horario : String, val tipoSessao : String, val local : String , val sala : String)
    data class Detalhes(val id : Int, val img : Int, val titulo : String, val sinopse : String, val sessoes : List<Sessao>)

    private val listDetalhes: List<Detalhes> = listOf(

        Detalhes(
            1,
            R.drawable.harrypotter,
            "Harry Potter e o Prisioneiro de Azkaban",
            "O perigoso assassino Sirius Black foge da prisão de Azkaban, e todos acreditam que ele está indo atrás de Harry Potter. Para proteger Hogwarts, o Ministério da Magia envia os aterrorizantes Dementadores.\n" +
                    "\n" +
                    "Harry, Rony e Hermione investigam a verdade por trás da fuga de Black e descobrem que ele era o melhor amigo dos pais de Harry, tendo sido falsamente acusado de traí-los para Voldemort e assassinar o verdadeiro traidor, Pedro Pettigrew.\n" +
                    "\n" +
                    "Com a ajuda do Professor Lupin e de um Vira-Tempo, eles salvam Black da execução, provando sua inocência. No final, Black foge e Harry ganha um padrinho, mudando sua vida para sempre.",
            sessoes = listOf(
                Sessao(101, "12:00", "Standard", "Shopping A" , "Sala 3"),
                Sessao(102, "15:30", "3D", "Shopping A", "Sala 1"),
                Sessao(103, "20:45", "Standard", "Shopping B", "Sala 5")
            )
        ),
        Detalhes(
            2,
            R.drawable.it,
            "It: A Coisa (It)",
            "Na pacata, mas assombrada, cidade de Derry, Maine, uma entidade maligna e sobrenatural conhecida como \"A Coisa\" ou Pennywise (o palhaço dançarino) ressurge a cada 27 anos para se alimentar, aterrorizando e devorando crianças.\n" +
                    "\n" +
                    "Um grupo de adolescentes excluídos, que se autodenominam o \"Clube dos Perdedores\", é forçado a confrontar seus maiores medos (que a Coisa usa para se manifestar) após o irmão mais novo do líder, Bill Denbrough, ser morto.\n" +
                    "\n" +
                    "Eles fazem um juramento de sangue para destruir a criatura. Anos depois, já adultos, eles precisam se reunir para cumprir essa promessa e enfrentar Pennywise uma última vez. A história lida com o poder da amizade, o trauma da infância e a superação do mal através da união.",
            sessoes = listOf(
                Sessao(201, "14:00", "VIP", "Shopping C", "Sala 7"),
                Sessao(202, "18:30", "Standard", "Shopping C", "Sala 2")
            )
        ),
        Detalhes(
            3,
            R.drawable.edm,
            "Esposa de Mentirinha",
            "Danny Maccabee (Adam Sandler) é um cirurgião plástico que, após uma desilusão amorosa no passado, descobre que usar uma aliança de casamento e contar histórias tristes sobre um \"divórcio iminente\" é a maneira perfeita de conquistar mulheres sem compromisso.\n" +
                    "\n" +
                    "Sua vida como solteirão se complica quando ele conhece Palmer (Brooklyn Decker), uma jovem professora por quem ele realmente se apaixona. Para conquistá-la de vez, Danny inventa a maior mentira de todas: ele diz que é casado, mas que está prestes a se divorciar.\n" +
                    "\n" +
                    "Quando Palmer insiste em conhecer a \"esposa\" para ter certeza de que o casamento realmente acabou, Danny entra em pânico e pede ajuda à sua leal assistente, Katherine Murphy (Jennifer Aniston), uma mãe solteira, para fingir ser sua futura ex-esposa.\n" +
                    "\n" +
                    "A mentira cresce rapidamente quando os dois filhos de Katherine também são envolvidos e todo o grupo — Danny, Palmer, Katherine e as crianças — embarca em uma viagem ao Havaí. Lá, em meio a diversas situações hilárias e a aparição inesperada de uma antiga rival de Katherine (Nicole Kidman), a linha entre a mentira e a realidade começa a se apagar. Danny e Katherine percebem que a química entre eles é muito maior do que a simples parceria profissional, questionando quem é o verdadeiro amor de Danny.",
            sessoes = listOf(
                Sessao(301, "10:30", "Standard", "Shopping D", "Sala 1"),
                Sessao(302, "16:15", "Standard", "Shopping A", "Sala 4"),
                Sessao(303, "19:45", "3D", "Shopping A", "Sala 2"),
                Sessao(304, "22:00", "VIP", "Shopping B", "Sala 8")
            )
        ),
        Detalhes(
            4,
            R.drawable.vingadores,
            "Vingadores: Ultimato",
            "Após Thanos eliminar metade de toda a vida no universo (o \"Estalo\"), os heróis sobreviventes dos Vingadores e seus aliados enfrentam a dor da perda.\n" +
                    "\n" +
                    "Cinco anos depois, eles descobrem uma chance de reverter o dano usando o Reino Quântico para viajar no tempo e coletar as Joias do Infinito no passado.\n" +
                    "\n" +
                    "A missão é um sucesso, mas o ato traz o Thanos de 2014 para o presente. Os Vingadores, reunindo todos os seus aliados ressuscitados, travam uma batalha final épica contra o Titã. O sacrifício de Tony Stark (Homem de Ferro), usando as Joias para eliminar Thanos e seu exército, salva o universo e restaura toda a vida perdida.",
            sessoes = listOf(
                Sessao(401, "21:00", "Standard", "Shopping C", "Sala 6")
            )

        ),
        Detalhes(
            5,
            R.drawable.panico,
            "Pânico 5",
            "Vinte e cinco anos após os assassinatos originais de Woodsboro, um novo Ghostface (Assassino da Máscara) surge e começa a atacar um grupo de adolescentes que possuem alguma ligação com os crimes do passado.\n" +
                    "\n" +
                    "A principal protagonista é Sam Carpenter, que volta à sua cidade natal após o ataque à sua irmã, Tara. Sam carrega um segredo mortal: ela é a filha não reconhecida de Billy Loomis, um dos Ghostfaces originais.\n" +
                    "\n" +
                    "Para sobreviver e descobrir a identidade do novo assassino, os jovens precisam da ajuda dos heróis lendários da franquia: Sidney Prescott, Gale Weathers e Dewey Riley. O filme é uma releitura meta-referencial do original, misturando a nova geração com a clássica, enquanto expõe as regras dos \"reboots-sequência\" de filmes de terror.",
            sessoes = listOf(
                Sessao(501, "13:40", "Standard", "Shopping A", "Sala 6"),
                Sessao(502, "17:10", "3D", "Shopping D", "Sala 4"),
                Sessao(503, "23:59", "VIP", "Shopping D", "Sala 9")
            )
        ),
        Detalhes(
            6,
            R.drawable.pdc,
            "Piratas do caribe",
            "A jovem Elizabeth Swann é sequestrada pelos piratas amaldiçoados do Pérola Negra, liderados pelo Capitão Barbossa, que precisam dela para quebrar uma maldição de mortos-vivos.\n" +
                    "\n" +
                    "O ferreiro Will Turner, apaixonado por Elizabeth, alia-se ao excêntrico e carismático Capitão Jack Sparrow para persegui-los, resgatar Elizabeth e recuperar o navio de Jack.\n" +
                    "\n" +
                    "Eles enfrentam os piratas amaldiçoados em uma aventura épica cheia de duelos e reviravoltas para quebrar o feitiço e restaurar a ordem no Caribe.",
            sessoes = listOf(
                Sessao(601, "11:00", "Standard", "Shopping B", "Sala 3"),
                Sessao(602, "18:45", "Standard", "Shopping C", "Sala 5")
            )
        ),
        Detalhes(
            7,
            R.drawable.titanic,
            "Titanic",
            "Em 1912, a jovem aristocrata Rose DeWitt Bukater, presa a um noivado infeliz, embarca no luxuoso navio Titanic. A bordo, ela conhece Jack Dawson, um artista pobre, e os dois iniciam um intenso e proibido romance, desafiando as barreiras sociais.\n" +
                    "\n" +
                    "A paixão é tragicamente interrompida quando o navio atinge um iceberg. O amor de Jack e Rose é colocado à prova em meio ao caos e ao pânico do naufrágio. O filme é um épico de romance e desastre, focado na luta deles pela sobrevivência.",
            sessoes = listOf(
                Sessao(701, "15:10", "VIP", "Shopping A", "Sala 8"),
                Sessao(702, "19:30", "Standard", "Shopping A", "Sala 7"),
                Sessao(703, "21:30", "3D", "Shopping D", "Sala 1")
            )
        ),
        Detalhes(
            8,
            R.drawable.johnwick,
            "John Wick 3",
            "John Wick está em fuga em Manhattan com uma recompensa de US$ 14 milhões pela sua cabeça, após ter violado a regra máxima do submundo dos assassinos: matar dentro do Hotel Continental.\n" +
                    "\n" +
                    "Considerado \"excomungado\" pela Alta Cúpula, ele precisa lutar contra um exército de assassinos de elite que estão atrás dele, transformando-se de caçador em caça.\n" +
                    "\n" +
                    "Para sobreviver, John busca a ajuda de antigos aliados e tenta encontrar o caminho para o Ancião, a única figura capaz de perdoá-lo. O filme é uma jornada de ação brutal e coreografada, onde John Wick precisa \"preparar-se para a guerra\" e enfrentar as consequências de suas escolhas.",
            sessoes = listOf(
                Sessao(801, "14:20", "Standard", "Shopping B", "Sala 5"),
                Sessao(802, "20:10", "VIP", "Shopping C", "Sala 8")
            )
        )
    )
    fun getDetalhe(id: Int): Detalhes?{
        return listDetalhes.find { it.id == id }


    }
}
