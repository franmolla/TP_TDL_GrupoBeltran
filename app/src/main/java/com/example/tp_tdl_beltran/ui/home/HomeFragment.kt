package com.example.tp_tdl_beltran.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.tp_tdl_beltran.R
import com.example.tp_tdl_beltran.databinding.FragmentHomeBinding
import com.example.tp_tdl_beltran.ui.gallery.GalleryFragment
import com.example.tp_tdl_beltran.ui.shared.SharedViewModel

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
        val pisos = resources.getStringArray(R.array.pisos_array)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, pisos
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val galleryFragment = GalleryFragment()
        val fragmentManager: FragmentManager = parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment_container, galleryFragment)
        fragmentTransaction.commit()

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
                val aulasDisponibles = listOf(400, 401, 402, 403)
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
                        sharedViewModel.setAulasDisponibles(aulasDisponibles)
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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
