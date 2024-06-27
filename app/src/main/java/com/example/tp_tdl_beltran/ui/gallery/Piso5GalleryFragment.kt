package com.example.tp_tdl_beltran.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tp_tdl_beltran.databinding.Piso5FragmentGalleryBinding
import com.example.tp_tdl_beltran.ui.shared.SharedViewModel

class Piso5GalleryFragment : Fragment() {

    private var _binding: Piso5FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var aula500: ImageView
    private lateinit var aula501: ImageView
    private lateinit var aula502: ImageView
    private lateinit var aula503: ImageView
    private lateinit var aula504: ImageView
    private lateinit var aula505: ImageView
    private lateinit var aula506: ImageView
    private lateinit var aula507: ImageView
    private lateinit var aula509: ImageView
    private lateinit var aula510: ImageView
    private lateinit var aula512: ImageView
    private lateinit var piso5Aulas: ImageView
    private lateinit var piso5Mapa: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Piso5FragmentGalleryBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        inicializarVistas()

        sharedViewModel.aulasDisponibles.observe(viewLifecycleOwner) { aulasDisponibles ->
            mostrarAulasDisponiblesPiso5(aulasDisponibles)
        }

        return view
    }

    private fun inicializarVistas() {
        aula500 = binding.aula500
        aula501 = binding.aula501
        aula502 = binding.aula502
        aula503 = binding.aula503
        aula504 = binding.aula504
        aula505 = binding.aula505
        aula506 = binding.aula506
        aula507 = binding.aula507
        aula509 = binding.aula509
        aula510 = binding.aula510
        aula512 = binding.aula512
        piso5Aulas = binding.piso5Aulas
        piso5Mapa = binding.piso5Mapa
        piso5Aulas.visibility = View.VISIBLE
        piso5Mapa.visibility = View.VISIBLE
    }
    fun mostrarAulasDisponiblesPiso5(aulasDisponibles: List<String>) {
        aula500.visibility = if (aulasDisponibles.contains("500")) View.VISIBLE else View.GONE
        aula501.visibility = if (aulasDisponibles.contains("501")) View.VISIBLE else View.GONE
        aula502.visibility = if (aulasDisponibles.contains("502")) View.VISIBLE else View.GONE
        aula503.visibility = if (aulasDisponibles.contains("503")) View.VISIBLE else View.GONE
        aula504.visibility = if (aulasDisponibles.contains("504")) View.VISIBLE else View.GONE
        aula505.visibility = if (aulasDisponibles.contains("505")) View.VISIBLE else View.GONE
        aula506.visibility = if (aulasDisponibles.contains("506")) View.VISIBLE else View.GONE
        aula507.visibility = if (aulasDisponibles.contains("507")) View.VISIBLE else View.GONE
        aula509.visibility = if (aulasDisponibles.contains("509")) View.VISIBLE else View.GONE
        aula510.visibility = if (aulasDisponibles.contains("510")) View.VISIBLE else View.GONE
        aula512.visibility = if (aulasDisponibles.contains("512")) View.VISIBLE else View.GONE
        piso5Aulas.visibility = View.VISIBLE
        piso5Mapa.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
