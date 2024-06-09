package com.example.tp_tdl_beltran.ui.shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _aulasDisponibles = MutableLiveData<List<Int>>()
    val aulasDisponibles: LiveData<List<Int>> get() = _aulasDisponibles

    fun setAulasDisponibles(aulas: List<Int>) {
        _aulasDisponibles.value = aulas
    }
}
