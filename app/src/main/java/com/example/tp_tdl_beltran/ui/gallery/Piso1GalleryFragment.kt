package com.example.tp_tdl_beltran.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tp_tdl_beltran.databinding.Piso1FragmentGalleryBinding
import com.example.tp_tdl_beltran.ui.shared.SharedViewModel

class Piso1GalleryFragment : Fragment() {

    private var _binding: Piso1FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var aula103: ImageView
    private lateinit var aula105: ImageView
    private lateinit var aula107: ImageView
    private lateinit var aulaL1: ImageView
    private lateinit var aulaL10: ImageView
    private lateinit var aulaL11: ImageView
    private lateinit var aulaL13: ImageView
    private lateinit var aulaL14: ImageView
    private lateinit var aulaL2: ImageView
    private lateinit var aulaL3: ImageView
    private lateinit var aulaL5: ImageView
    private lateinit var aulaL6: ImageView
    private lateinit var aulaL7: ImageView
    private lateinit var aulaL8: ImageView
    private lateinit var piso1Aulas: ImageView
    private lateinit var piso1Mapa: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Piso1FragmentGalleryBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        inicializarVistas()

        sharedViewModel.aulasDisponibles.observe(viewLifecycleOwner) { aulasDisponibles ->
            mostrarAulasDisponiblesPiso3(aulasDisponibles)
        }

        return view
    }

    private fun inicializarVistas() {
        aula103 = binding.aula103
        aula105 = binding.aula105
        aula107 = binding.aula107
        aulaL1 = binding.aulaL1
        aulaL10 = binding.aulaL10
        aulaL11 = binding.aulaL11
        aulaL13 = binding.aulaL13
        aulaL14 = binding.aulaL14
        aulaL2 = binding.aulaL2
        aulaL3 = binding.aulaL3
        aulaL5 = binding.aulaL5
        aulaL6 = binding.aulaL6
        aulaL7 = binding.aulaL7
        aulaL8 = binding.aulaL8
        piso1Aulas = binding.piso1Aulas
        piso1Mapa = binding.piso1Mapa
    }

    fun mostrarAulasDisponiblesPiso3(aulasDisponibles: List<Int>) {
        aula103.visibility = if (aulasDisponibles.contains(103)) View.VISIBLE else View.GONE
        aula105.visibility = if (aulasDisponibles.contains(105)) View.VISIBLE else View.GONE
        aula107.visibility = if (aulasDisponibles.contains(107)) View.VISIBLE else View.GONE
        aulaL1.visibility = if (aulasDisponibles.contains(1)) View.VISIBLE else View.GONE
        aulaL10.visibility = if (aulasDisponibles.contains(10)) View.VISIBLE else View.GONE
        aulaL11.visibility = if (aulasDisponibles.contains(11)) View.VISIBLE else View.GONE
        aulaL13.visibility = if (aulasDisponibles.contains(13)) View.VISIBLE else View.GONE
        aulaL14.visibility = if (aulasDisponibles.contains(14)) View.VISIBLE else View.GONE
        aulaL2.visibility = if (aulasDisponibles.contains(2)) View.VISIBLE else View.GONE
        aulaL3.visibility = if (aulasDisponibles.contains(3)) View.VISIBLE else View.GONE
        aulaL5.visibility = if (aulasDisponibles.contains(5)) View.VISIBLE else View.GONE
        aulaL6.visibility = if (aulasDisponibles.contains(6)) View.VISIBLE else View.GONE
        aulaL7.visibility = if (aulasDisponibles.contains(7)) View.VISIBLE else View.GONE
        aulaL8.visibility = if (aulasDisponibles.contains(8)) View.VISIBLE else View.GONE
        piso1Aulas.visibility = View.VISIBLE
        piso1Mapa.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
