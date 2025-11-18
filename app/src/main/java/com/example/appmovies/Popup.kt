package com.example.appmovies
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.view.LayoutInflater





     fun popup(context: Context, filmeId: Int, audioId: Int, localId: Int) {
        val repositorio = FilmeRepositorio()
        val tipoAudio = Modo()
        val listaLocais = LocalRepositorio()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.signin, null)
        val filme = repositorio.getFilme(filmeId)
        val audio = tipoAudio.getTipo(audioId)
        val locais = listaLocais.getLocal(localId)

        if (filme != null && audio != null && locais != null) {
            val txtNome = dialogView.findViewById<TextView>(R.id.titulo)
            val txtSinopse = dialogView.findViewById<TextView>(R.id.sinopse)
            val imgFilme = dialogView.findViewById<ImageView>(R.id.img)
            val tipo = dialogView.findViewById<TextView>(R.id.modoAudio)
            val shop = dialogView.findViewById<TextView>(R.id.shop)
            val sala = dialogView.findViewById<TextView>(R.id.sala)
            val end = dialogView.findViewById<TextView>(R.id.endereco)
            val horario = dialogView.findViewById<TextView>(R.id.horas)

            txtNome.text = filme.nome
            txtSinopse.text = filme.sinopse
            imgFilme.setImageResource(filme.imagem)
            tipo.text = audio.descri
            shop.text = locais.shopping
            sala.text = "Sala  ${locais.sala}"
            end.text = locais.endereco
            horario.text = locais.horario


            val builder = AlertDialog.Builder(context)

            builder.setView(dialogView)

            val dialog = builder.create()

            dialog.window?.attributes?.windowAnimations = R.style.animation

            dialog.show()

            val btnCancelar = dialogView.findViewById<TextView>(R.id.btnFechar)
            btnCancelar.setOnClickListener {
                dialog.cancel()
            }
        }
}