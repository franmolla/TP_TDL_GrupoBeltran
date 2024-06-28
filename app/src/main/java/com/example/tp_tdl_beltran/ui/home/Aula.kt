package com.example.tp_tdl_beltran.ui.home

data class Aula(
    val day: String = "",
    val room: String = "",
    val `7`: String? = null,
    val `8`: String? = null,
    val `9`: String? = null,
    val `10`: String? = null,
    val `11`: String? = null,
    val `12`: String? = null,
    val `13`: String? = null,
    val `14`: String? = null,
    val `15`: String? = null,
    val `16`: String? = null,
    val `17`: String? = null,
    val `18`: String? = null,
    val `19`: String? = null,
    val `20`: String? = null,
    val `21`: String? = null,
    val `22`: String? = null,
    val `23`: String? = null,
    val piso1: String? = null,
    val piso2: String? = null,
    val piso3: String? = null,
    val piso4: String? = null,
    val piso5: String? = null,
    val Subsuelo: String? = null
) {
    // Método para obtener el campo de hora correspondiente
    fun getHoraField(horaSeleccionada: Int): String? {
        return when (horaSeleccionada) {
            7 -> this.`7`
            8 -> this.`8`
            9 -> this.`9`
            10 -> this.`10`
            11 -> this.`11`
            12 -> this.`12`
            13 -> this.`13`
            14 -> this.`14`
            15 -> this.`15`
            16 -> this.`16`
            17 -> this.`17`
            18 -> this.`18`
            19 -> this.`19`
            20 -> this.`20`
            21 -> this.`21`
            22 -> this.`22`
            23 -> this.`23`
            else -> null
        }
    }

    // Método para obtener el campo de piso seleccionado
    fun getPisoField(pisoSeleccionado: String): String? {
        return when (pisoSeleccionado) {
            "Piso 1" -> this.piso1
            "Piso 2" -> this.piso2
            "Piso 3" -> this.piso3
            "Piso 4" -> this.piso4
            "Piso 5" -> this.piso5
            "Subsuelo" -> this.Subsuelo
            else -> null
        }
    }
}