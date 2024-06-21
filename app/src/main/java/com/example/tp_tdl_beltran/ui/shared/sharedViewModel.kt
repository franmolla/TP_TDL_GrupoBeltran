package com.example.tp_tdl_beltran.ui.shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _aulasDisponibles = MutableLiveData<List<String>>()
    val aulasDisponibles: LiveData<List<String>> get() = _aulasDisponibles

    fun setAulasDisponibles(aulas: List<String>) {
        _aulasDisponibles.value = aulas
    }
}
