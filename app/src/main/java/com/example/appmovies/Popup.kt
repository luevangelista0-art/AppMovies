package com.example.appmovies
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.view.LayoutInflater
import android.view.View


fun popup(context: Context, filmeId: Int) {
        val repositorio = FilmeRepositorio()


        val dialogView = LayoutInflater.from(context).inflate(R.layout.signin, null)
        val filme = repositorio.getFilme(filmeId)


        if (filme != null) {
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
            tipo.text = filme.sessoes[0].tipoSessao
            shop.text = filme.sessoes[0].local
            sala.text = filme.sessoes[0].sala
            end.text = filme.sessoes[0].endereco
            horario.text = filme.sessoes[0].horarios[0]

            val sessao = filme.sessoes[0]
            val horario2 = dialogView.findViewById<TextView>(R.id.horas2)

            if (sessao.horarios.size > 1){
                horario2.visibility = View.VISIBLE
                horario2.text = filme.sessoes[0].horarios[1]
            } else {
                horario2.visibility = View.GONE
            }
        }



            val builder = AlertDialog.Builder(context)

            builder.setView(dialogView)

            val dialog = builder.create()

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations = R.style.animation

            dialog.show()

            val btnCancelar = dialogView.findViewById<TextView>(R.id.btnFechar)
            btnCancelar.setOnClickListener {
                dialog.cancel()
            }
        }
