package com.example.appmovies.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovies.BuscarDetalhes
import com.example.appmovies.databinding.ItemHorarioBinding

class HorariosAdapter (
    private val context: Context,
    private val sessoes: List<BuscarDetalhes.Sessao>
) : RecyclerView.Adapter<HorariosAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemHorarioBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sessao: BuscarDetalhes.Sessao, context: Context) {
            binding.horario.text = sessao.horario
            binding.local.text = sessao.local
            binding.tipo.text = sessao.tipoSessao
            binding.sala.text = sessao.sala
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

            val binding = ItemHorarioBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val sessao = sessoes[position]
        holder.bind(sessao, context)
    }

    override fun getItemCount(): Int = sessoes.size


}