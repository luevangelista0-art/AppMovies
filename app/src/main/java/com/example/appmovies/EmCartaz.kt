package com.example.appmovies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EmCartaz.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmCartaz : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_em_cartaz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nome = view.findViewById<TextView>(R.id.saudacao)
        val nomeRecuperacao = requireContext().getSharedPreferences("texto", Context.MODE_PRIVATE)
            .getString("nome", "Seja Bem Vindo")
        nome.text = "Olá, $nomeRecuperacao"

        val btnHarry = view.findViewById<Button>(R.id.btnHarry)
        val btnIt = view.findViewById<Button>(R.id.btnIt)
        val btnEdm = view.findViewById<Button>(R.id.btnEdm)
        val btnVing = view.findViewById<Button>(R.id.btnVing)
        val btnPanico = view.findViewById<Button>(R.id.btnPanico)
        val btnPiratas = view.findViewById<Button>(R.id.btnPiratas)
        val btnTitanic = view.findViewById<Button>(R.id.btnTitanic)
        val btnJohn = view.findViewById<Button>(R.id.btnJohn)

        val buttons = listOf(btnHarry, btnIt, btnEdm,btnVing,btnPanico,btnPiratas,btnTitanic, btnJohn)
        val intent = Intent(context, Detalhes::class.java)
        val chave_id = "filme_id"


        buttons.forEach { button ->
            button.setOnClickListener { click ->
                val filme_id = click .tag.toString().toIntOrNull() ?: 0
                intent.putExtra(chave_id, filme_id)
                startActivity(intent)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EmCartaz.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmCartaz().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}