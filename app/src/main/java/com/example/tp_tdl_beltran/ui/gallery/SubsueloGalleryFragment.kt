package com.example.tp_tdl_beltran.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tp_tdl_beltran.databinding.SubsueloFragmentGalleryBinding
import com.example.tp_tdl_beltran.ui.shared.SharedViewModel

class SubsueloGalleryFragment : Fragment() {

    private var _binding: SubsueloFragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var aulaE1: ImageView
    private lateinit var aulaE10: ImageView
    private lateinit var aulaE14: ImageView
    private lateinit var aulaE16: ImageView
    private lateinit var aulaE29: ImageView
    private lateinit var aulaE3: ImageView
    private lateinit var aulaE32: ImageView
    private lateinit var aulaE33: ImageView
    private lateinit var aulaE5: ImageView
    private lateinit var aulaE7: ImageView
    private lateinit var aulaE8: ImageView
    private lateinit var aulaE9: ImageView
    private lateinit var subsueloAulas: ImageView
    private lateinit var subsueloMapa: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SubsueloFragmentGalleryBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        inicializarVistas()

        sharedViewModel.aulasDisponibles.observe(viewLifecycleOwner) { aulasDisponibles ->
            mostrarAulasDisponiblesSubsuelo(aulasDisponibles)
        }

        return view
    }

    private fun inicializarVistas() {
        aulaE1 = binding.aulaE1
        aulaE10 = binding.aulaE10
        aulaE14 = binding.aulaE14
        aulaE16 = binding.aulaE16
        aulaE29 = binding.aulaE29
        aulaE3 = binding.aulaE3
        aulaE32 = binding.aulaE32
        aulaE33 = binding.aulaE33
        aulaE5 = binding.aulaE5
        aulaE7 = binding.aulaE7
        aulaE8 = binding.aulaE8
        aulaE9 = binding.aulaE9
        subsueloAulas = binding.subsueloAulas
        subsueloMapa = binding.subsueloMapa
    }
    fun mostrarAulasDisponiblesSubsuelo(aulasDisponibles: List<String>) {
        aulaE1.visibility = if (aulasDisponibles.contains("E1")) View.VISIBLE else View.GONE
        aulaE10.visibility = if (aulasDisponibles.contains("E10")) View.VISIBLE else View.GONE
        aulaE14.visibility = if (aulasDisponibles.contains("E14")) View.VISIBLE else View.GONE
        aulaE16.visibility = if (aulasDisponibles.contains("E16")) View.VISIBLE else View.GONE
        aulaE29.visibility = if (aulasDisponibles.contains("E29")) View.VISIBLE else View.GONE
        aulaE3.visibility = if (aulasDisponibles.contains("E3")) View.VISIBLE else View.GONE
        aulaE32.visibility = if (aulasDisponibles.contains("E32")) View.VISIBLE else View.GONE
        aulaE33.visibility = if (aulasDisponibles.contains("E33")) View.VISIBLE else View.GONE
        aulaE5.visibility = if (aulasDisponibles.contains("E5")) View.VISIBLE else View.GONE
        aulaE7.visibility = if (aulasDisponibles.contains("E7")) View.VISIBLE else View.GONE
        aulaE8.visibility = if (aulasDisponibles.contains("E8")) View.VISIBLE else View.GONE
        aulaE9.visibility = if (aulasDisponibles.contains("E9")) View.VISIBLE else View.GONE
        subsueloAulas.visibility = View.VISIBLE
        subsueloMapa.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
