package com.example.tp_tdl_beltran.ui.home

import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.NumberPicker
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tp_tdl_beltran.R
import com.example.tp_tdl_beltran.databinding.FragmentHomeBinding
import com.example.tp_tdl_beltran.ui.shared.SharedViewModel
import com.google.android.material.button.MaterialButtonToggleGroup
import android.database.sqlite.SQLiteDatabase


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.horasPicker.minValue = 0
        binding.horasPicker.maxValue = 12
        binding.minutosPicker.minValue = 0
        binding.minutosPicker.maxValue = 59

        val str = arrayOf("AM", "PM")
        binding.horarioPicker.displayedValues = str

        val spinner: Spinner = binding.SpinnerPiso
        val numberPicker: NumberPicker = binding.horasPicker
        val textView: TextView = binding.multilineTextView
        val toggleButtonGroup: MaterialButtonToggleGroup = binding.toggleButtonGroup


        val pisos = resources.getStringArray(R.array.pisos_array)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, pisos
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        updateTextView(spinner, numberPicker, toggleButtonGroup, textView)


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                updateTextView(spinner, numberPicker, toggleButtonGroup, textView)

                Toast.makeText(
                    requireContext(),
                    getString(R.string.selected_item) + " " + pisos[position],
                    Toast.LENGTH_SHORT
                ).show()
                val aulasDisponiblesPiso3 = listOf(301, 302, 303, 304, 305)
                val aulasDisponiblesPiso4 = listOf(400, 401, 402, 403)
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
                        sharedViewModel.setAulasDisponibles(aulasDisponiblesPiso3)
                        findNavController().navigate(R.id.piso3_nav_gallery)
                    }
                    "Piso 4" -> {
                        sharedViewModel.setAulasDisponibles(aulasDisponiblesPiso4)
                        findNavController().navigate(R.id.piso4_nav_gallery)
                    }
                    "Piso 5" -> {
                        // funcionalidad
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Qué hacer cuando no se selecciona nada en el spinner
            }
        }

        numberPicker.setOnValueChangedListener { _, _, _ ->
            updateTextView(spinner, numberPicker, toggleButtonGroup, textView)
        }

        toggleButtonGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                updateTextView(spinner, numberPicker, toggleButtonGroup, textView)
            }
        }

        return root
    }
    private fun updateTextView(spinner: Spinner, numberPicker: NumberPicker, toggleButtonGroup: MaterialButtonToggleGroup, textView: TextView) {
        val pisoSeleccionado = spinner.selectedItem.toString()
        val horaSeleccionada = numberPicker.value
        val selectedButtonId = toggleButtonGroup.checkedButtonId
        val diaSeleccionado = when (selectedButtonId) {
            R.id.Lunes -> "Lunes"
            R.id.Martes -> "Martes"
            R.id.Miercoles -> "Miércoles"
            R.id.Jueves -> "Jueves"
            R.id.Viernes -> "Viernes"
            R.id.Sabado -> "Sábado"
            else -> "Ninguno"
        }
        val result = "Spinner: $pisoSeleccionado, NumberPicker: $horaSeleccionada, Día: $diaSeleccionado"
        textView.text = result

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
