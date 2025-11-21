package com.example.appmovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EmBreve.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmBreve : Fragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_em_breve, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnF1 = view.findViewById<Button>(R.id.f1)
        val btnF2 = view.findViewById<Button>(R.id.f2)
        val btnF3 = view.findViewById<Button>(R.id.f3)
        val btnF4 = view.findViewById<Button>(R.id.f4)
        val btnF5 = view.findViewById<Button>(R.id.f5)

        btnF1.setOnClickListener {
            popup(context = requireContext(), filmeId = 1, audioId = 2, localId = 1)
        }
        btnF2.setOnClickListener {
            popup(context = requireContext(), filmeId = 2, audioId = 2, localId = 1)
        }
        btnF3.setOnClickListener {
            popup(context = requireContext(), filmeId = 3, audioId = 1, localId = 1)
        }
        btnF4.setOnClickListener {
            popup(context = requireContext(), filmeId = 4, audioId = 2, localId = 1)
        }
        btnF5.setOnClickListener {
            popup(context = requireContext(), filmeId = 5, audioId = 1, localId = 1)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EmBreve.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EmBreve().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

