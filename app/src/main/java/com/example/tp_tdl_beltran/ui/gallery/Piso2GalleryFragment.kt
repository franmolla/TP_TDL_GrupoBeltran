package com.example.tp_tdl_beltran.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tp_tdl_beltran.databinding.Piso2FragmentGalleryBinding
import com.example.tp_tdl_beltran.ui.shared.SharedViewModel

class Piso2GalleryFragment : Fragment() {

    private var _binding: Piso2FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var aula200: ImageView
    private lateinit var aula201: ImageView
    private lateinit var aula202: ImageView
    private lateinit var aula203: ImageView
    private lateinit var aula211a: ImageView
    private lateinit var aula211b: ImageView
    private lateinit var aula211c: ImageView
    private lateinit var aula221: ImageView
    private lateinit var aula222: ImageView
    private lateinit var aula237: ImageView
    private lateinit var piso2Aulas: ImageView
    private lateinit var piso2Mapa: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Piso2FragmentGalleryBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        inicializarVistas()

        sharedViewModel.aulasDisponibles.observe(viewLifecycleOwner) { aulasDisponibles ->
            mostrarAulasDisponiblesPiso2(aulasDisponibles)
        }

        return view
    }

    private fun inicializarVistas() {
        aula200 = binding.aula200
        aula201 = binding.aula201
        aula202 = binding.aula202
        aula203 = binding.aula203
        aula211a = binding.aula211a
        aula211b = binding.aula211b
        aula211c = binding.aula211c
        aula221 = binding.aula221
        aula222 = binding.aula222
        aula237 = binding.aula237
        piso2Aulas = binding.piso2Aulas
        piso2Mapa = binding.piso2Mapa
    }

    fun mostrarAulasDisponiblesPiso2(aulasDisponibles: List<String>) {
        aula200.visibility = if (aulasDisponibles.contains("200")) View.VISIBLE else View.GONE
        aula201.visibility = if (aulasDisponibles.contains("201")) View.VISIBLE else View.GONE
        aula202.visibility = if (aulasDisponibles.contains("202")) View.VISIBLE else View.GONE
        aula203.visibility = if (aulasDisponibles.contains("203")) View.VISIBLE else View.GONE
        aula211a.visibility = if (aulasDisponibles.contains("211a")) View.VISIBLE else View.GONE
        aula211b.visibility = if (aulasDisponibles.contains("211b")) View.VISIBLE else View.GONE
        aula211c.visibility = if (aulasDisponibles.contains("211c")) View.VISIBLE else View.GONE
        aula221.visibility = if (aulasDisponibles.contains("221")) View.VISIBLE else View.GONE
        aula222.visibility = if (aulasDisponibles.contains("222")) View.VISIBLE else View.GONE
        aula237.visibility = if (aulasDisponibles.contains("237")) View.VISIBLE else View.GONE
        piso2Aulas.visibility = View.VISIBLE
        piso2Mapa.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
