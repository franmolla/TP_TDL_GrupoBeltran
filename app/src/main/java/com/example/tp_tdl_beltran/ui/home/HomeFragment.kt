package com.example.tp_tdl_beltran.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        val str =  arrayOf("AM", "PM")
//        binding.horarioPicker.minValue = 0
//        binding.horarioPicker.maxValue = str.size
        binding.horarioPicker.displayedValues = str
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}