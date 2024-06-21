package com.example.tp_tdl_beltran.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tp_tdl_beltran.databinding.FragmentGalleryBinding
import com.example.tp_tdl_beltran.ui.shared.SharedViewModel

class Piso4GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var aula400: ImageView
    private lateinit var aula401: ImageView
    private lateinit var aula402: ImageView
    private lateinit var aula403: ImageView
    private lateinit var aula405: ImageView
    private lateinit var aula407: ImageView
    private lateinit var aula408: ImageView
    private lateinit var aula411: ImageView
    private lateinit var aula412: ImageView
    private lateinit var aula414: ImageView
    private lateinit var aula416: ImageView
    private lateinit var aula417: ImageView
    private lateinit var aula430: ImageView
    private lateinit var piso4Aulas: ImageView
    private lateinit var piso4Mapa: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        inicializarVistas()

        sharedViewModel.aulasDisponibles.observe(viewLifecycleOwner) { aulasDisponibles ->
            mostrarAulasDisponiblesPiso4(aulasDisponibles)
        }

        return view
    }

    private fun inicializarVistas() {
        aula400 = binding.aula400
        aula401 = binding.aula401
        aula402 = binding.aula402
        aula403 = binding.aula403
        aula405 = binding.aula405
        aula407 = binding.aula407
        aula408 = binding.aula408
        aula411 = binding.aula411
        aula412 = binding.aula412
        aula414 = binding.aula414
        aula416 = binding.aula416
        aula417 = binding.aula417
        aula430 = binding.aula430
        piso4Aulas = binding.piso4Aulas
        piso4Mapa = binding.piso4Mapa
    }

    fun mostrarAulasDisponiblesPiso4(aulasDisponibles: List<String>) {
        aula400.visibility = if (aulasDisponibles.contains("400")) View.VISIBLE else View.GONE
        aula401.visibility = if (aulasDisponibles.contains("401")) View.VISIBLE else View.GONE
        aula402.visibility = if (aulasDisponibles.contains("402")) View.VISIBLE else View.GONE
        aula403.visibility = if (aulasDisponibles.contains("403")) View.VISIBLE else View.GONE
        aula405.visibility = if (aulasDisponibles.contains("405")) View.VISIBLE else View.GONE
        aula407.visibility = if (aulasDisponibles.contains("407")) View.VISIBLE else View.GONE
        aula408.visibility = if (aulasDisponibles.contains("408")) View.VISIBLE else View.GONE
        aula411.visibility = if (aulasDisponibles.contains("411")) View.VISIBLE else View.GONE
        aula412.visibility = if (aulasDisponibles.contains("412")) View.VISIBLE else View.GONE
        aula414.visibility = if (aulasDisponibles.contains("414")) View.VISIBLE else View.GONE
        aula416.visibility = if (aulasDisponibles.contains("416")) View.VISIBLE else View.GONE
        aula417.visibility = if (aulasDisponibles.contains("417")) View.VISIBLE else View.GONE
        aula430.visibility = if (aulasDisponibles.contains("430")) View.VISIBLE else View.GONE
        piso4Aulas.visibility = View.VISIBLE
        piso4Mapa.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
