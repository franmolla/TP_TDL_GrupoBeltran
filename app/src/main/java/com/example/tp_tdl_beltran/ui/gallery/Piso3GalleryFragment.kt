package com.example.tp_tdl_beltran.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tp_tdl_beltran.databinding.Piso3FragmentGalleryBinding
import com.example.tp_tdl_beltran.ui.shared.SharedViewModel

class Piso3GalleryFragment : Fragment() {

    private var _binding: Piso3FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var aula301: ImageView
    private lateinit var aula302: ImageView
    private lateinit var aula303: ImageView
    private lateinit var aula304: ImageView
    private lateinit var aula305: ImageView
    private lateinit var aula310: ImageView
    private lateinit var aula313: ImageView
    private lateinit var aula319: ImageView
    private lateinit var piso3Aulas: ImageView
    private lateinit var piso3Mapa: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Piso3FragmentGalleryBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        inicializarVistas()

        sharedViewModel.aulasDisponibles.observe(viewLifecycleOwner) { aulasDisponibles ->
            mostrarAulasDisponiblesPiso3(aulasDisponibles)
        }

        return view
    }

    private fun inicializarVistas() {
        aula301 = binding.aula301
        aula302 = binding.aula302
        aula303 = binding.aula303
        aula304 = binding.aula304
        aula305 = binding.aula305
        aula310 = binding.aula310
        aula313 = binding.aula313
        aula319 = binding.aula319
        piso3Aulas = binding.piso3Aulas
        piso3Mapa = binding.piso3Mapa
    }

    fun mostrarAulasDisponiblesPiso3(aulasDisponibles: List<Int>) {
        aula301.visibility = if (aulasDisponibles.contains(301)) View.VISIBLE else View.GONE
        aula302.visibility = if (aulasDisponibles.contains(302)) View.VISIBLE else View.GONE
        aula303.visibility = if (aulasDisponibles.contains(303)) View.VISIBLE else View.GONE
        aula304.visibility = if (aulasDisponibles.contains(304)) View.VISIBLE else View.GONE
        aula305.visibility = if (aulasDisponibles.contains(305)) View.VISIBLE else View.GONE
        aula310.visibility = if (aulasDisponibles.contains(310)) View.VISIBLE else View.GONE
        aula313.visibility = if (aulasDisponibles.contains(313)) View.VISIBLE else View.GONE
        aula319.visibility = if (aulasDisponibles.contains(319)) View.VISIBLE else View.GONE
        piso3Aulas.visibility = View.VISIBLE
        piso3Mapa.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
