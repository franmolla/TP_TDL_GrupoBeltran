package com.example.tp_tdl_beltran.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tp_tdl_beltran.R
import com.example.tp_tdl_beltran.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.Lunes
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        //seteo el NumPicker
        binding.horasPicker.minValue = 0
        binding.horasPicker.maxValue = 12
        binding.minutosPicker.minValue = 0
        binding.minutosPicker.maxValue = 59

        val str = arrayOf("AM", "PM")
//        binding.horarioPicker.minValue = 0
//        binding.horarioPicker.maxValue = str.size
        binding.horarioPicker.displayedValues = str

        //Spinner
        val spinner: Spinner = binding.SpinnerPiso
        val pisos = resources.getStringArray(R.array.pisos_array)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, pisos
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.selected_item) + " " + pisos[position],
                    Toast.LENGTH_SHORT
                ).show()
            when (pisos[position]) {
                "Subsuelo" -> {
                    // funcionalidad
                }
                "Piso 1" -> {
                    // funcionalidad
                }
                "Piso 2" -> {
                    // funcionalidad
                }
                "Piso 3" -> {
                    // funcionalidad
                }
                "Piso 4" -> {
                    // funcionalidad
                }
                "Piso 5" -> {
                    // funcionalidad
                }
            }
        }




            override fun onNothingSelected(parent: AdapterView<*>) {
                // Que hacer cuando no se selecciona nada en el spinner
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}