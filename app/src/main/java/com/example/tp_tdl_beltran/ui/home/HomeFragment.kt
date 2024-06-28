package com.example.tp_tdl_beltran.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.horasPicker.minValue = 7
        binding.horasPicker.maxValue = 23
        binding.minutosPicker.minValue = 0
        binding.minutosPicker.maxValue = 59

        val numberPicker: NumberPicker = binding.horasPicker

        val spinner: Spinner = binding.SpinnerPiso
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

        var pisoSeleccionado = ""

//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>,
//                view: View,
//                position: Int,
//                id: Long
//            ) {
//                updateTextView(spinner, numberPicker, toggleButtonGroup, textView)
//                Toast.makeText(
//                    requireContext(),
//                    getString(R.string.selected_item) + " " + pisos[position],
//                    Toast.LENGTH_SHORT
//                ).show()
//                pisoSeleccionado = pisos[position]
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                // Qué hacer cuando no se selecciona nada en el spinner
//            }
//        }


        binding.botonMapa.setOnClickListener {
            var horarioSeleccionado = numberPicker.value
            val pisoSeleccionado = spinner.selectedItem.toString()
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

            buscarAulas(horarioSeleccionado, diaSeleccionado,
                onSuccess = { result ->
                    val aulasEncontradas = result.split(", ")
                    when (pisoSeleccionado) {
                        "Subsuelo" -> {
                            sharedViewModel.setAulasDisponibles(aulasEncontradas)
                            findNavController().navigate(R.id.subsuelo_nav_gallery)
                        }
                        "Piso 1" -> {
                            sharedViewModel.setAulasDisponibles(aulasEncontradas)
                            findNavController().navigate(R.id.piso1_nav_gallery)
                        }
                        "Piso 2" -> {
                            sharedViewModel.setAulasDisponibles(aulasEncontradas)
                            findNavController().navigate(R.id.piso2_nav_gallery)
                        }
                        "Piso 3" -> {
                            sharedViewModel.setAulasDisponibles(aulasEncontradas)
                            findNavController().navigate(R.id.piso3_nav_gallery)
                        }
                        "Piso 4" -> {
                            sharedViewModel.setAulasDisponibles(aulasEncontradas)
                            findNavController().navigate(R.id.piso4_nav_gallery)
                        }
                        "Piso 5" -> {
                            sharedViewModel.setAulasDisponibles(aulasEncontradas)
                            findNavController().navigate(R.id.piso5_nav_gallery)
                        }
                        else -> {
                            Toast.makeText(requireContext(), "Seleccione un piso válido", Toast.LENGTH_SHORT).show()
                        }
                    }

                },
                onFailure = { error ->
                    // Por si falla algo
                    Log.e("Firebase", "Error al buscar aulas: $error")
                }
            )
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
    }}


    fun buscarAulas(
        horaSeleccionada: Int,
        diaSeleccionado: String,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val database = FirebaseDatabase.getInstance().reference.child("Sheet1")

        val query = database.orderByChild("day").equalTo(diaSeleccionado)
        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val aulasEncontradas = mutableListOf<String>()

                for (aulaSnapshot in snapshot.children) {
                    val aula = aulaSnapshot.getValue(Aula::class.java)

                    if (aula != null && aula.room.isNotEmpty() &&
                        aula.getHoraField(horaSeleccionada) == "X") {
                        aulasEncontradas.add(aula.room)
                    }
                }

                val result = aulasEncontradas.joinToString(", ")


                onSuccess(result)
            }

            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }
        })
    }


    private fun updateTextView(spinner: Spinner, numberPicker: NumberPicker, toggleButtonGroup: MaterialButtonToggleGroup, textView: TextView) {

        var horarioSeleccionado = numberPicker.value
        val pisoSeleccionado = spinner.selectedItem.toString()
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

        buscarAulas(horarioSeleccionado, diaSeleccionado,
            onSuccess = { result ->

                val aulasPorLinea = "Las aulas libres son:\n$result"
                textView.text = aulasPorLinea

            },
            onFailure = { error ->
                // Por si falla algo
                Log.e("Firebase", "Error al buscar aulas: $error")
            }
        )
    }
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}
