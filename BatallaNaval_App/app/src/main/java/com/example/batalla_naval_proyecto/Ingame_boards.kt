package com.example.batalla_naval_proyecto

import android.graphics.Color
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ingame_boards : AppCompatActivity() {
    private val met = Metodos()

    //Es la que obtiene al tablero amigo, es decir de este jugador
    var matrizAmiga : ArrayList<ArrayList<Boolean>> = ArrayList()
    private var misCeldas = arrayOf<Array<TextView>>()
    private var celdasEnemigas = arrayOf<Array<TextView>>()
    private var esMiTurno:Boolean = false //Variable usada para pasar la bandera de quién ataca
    private var numJugador: Int = 0

    fun atacarCelda(coord: PointF){
        //Funcion a implementar con API
        if(!esMiTurno) return //Talvez mostrar el tiempo restante del enemigo en pantalla

        //Desactivar la celda atacada. (not clickable)

        //
    }

    private fun inicializarCeldas(){
        var miCeldaA1 = findViewById(R.id.bttnCelda_A_1) as TextView
        var miCeldaA2 = findViewById(R.id.bttnCelda_A_2) as TextView
        var miCeldaA3 = findViewById(R.id.bttnCelda_A_3) as TextView
        var miCeldaA4 = findViewById(R.id.bttnCelda_A_4) as TextView
        var miCeldaA5 = findViewById(R.id.bttnCelda_A_5) as TextView
        var miCeldaA6 = findViewById(R.id.bttnCelda_A_6) as TextView
        var miCeldaA7 = findViewById(R.id.bttnCelda_A_7) as TextView
        var miCeldaA8 = findViewById(R.id.bttnCelda_A_8) as TextView
        var miCeldaA9 = findViewById(R.id.bttnCelda_A_9) as TextView
        var miCeldaA10 = findViewById(R.id.bttnCelda_A_10) as TextView

        var miCeldaB1 = findViewById(R.id.bttnCelda_B_1) as TextView
        var miCeldaB2 = findViewById(R.id.bttnCelda_B_2) as TextView
        var miCeldaB3 = findViewById(R.id.bttnCelda_B_3) as TextView
        var miCeldaB4 = findViewById(R.id.bttnCelda_B_4) as TextView
        var miCeldaB5 = findViewById(R.id.bttnCelda_B_5) as TextView
        var miCeldaB6 = findViewById(R.id.bttnCelda_B_6) as TextView
        var miCeldaB7 = findViewById(R.id.bttnCelda_B_7) as TextView
        var miCeldaB8 = findViewById(R.id.bttnCelda_B_8) as TextView
        var miCeldaB9 = findViewById(R.id.bttnCelda_B_9) as TextView
        var miCeldaB10 = findViewById(R.id.bttnCelda_B_10) as TextView

        var miCeldaC1 = findViewById(R.id.bttnCelda_C_1) as TextView
        var miCeldaC2 = findViewById(R.id.bttnCelda_C_2) as TextView
        var miCeldaC3 = findViewById(R.id.bttnCelda_C_3) as TextView
        var miCeldaC4 = findViewById(R.id.bttnCelda_C_4) as TextView
        var miCeldaC5 = findViewById(R.id.bttnCelda_C_5) as TextView
        var miCeldaC6 = findViewById(R.id.bttnCelda_C_6) as TextView
        var miCeldaC7 = findViewById(R.id.bttnCelda_C_7) as TextView
        var miCeldaC8 = findViewById(R.id.bttnCelda_C_8) as TextView
        var miCeldaC9 = findViewById(R.id.bttnCelda_C_9) as TextView
        var miCeldaC10 = findViewById(R.id.bttnCelda_C_10) as TextView

        var miCeldaD1 = findViewById(R.id.bttnCelda_D_1) as TextView
        var miCeldaD2 = findViewById(R.id.bttnCelda_D_2) as TextView
        var miCeldaD3 = findViewById(R.id.bttnCelda_D_3) as TextView
        var miCeldaD4 = findViewById(R.id.bttnCelda_D_4) as TextView
        var miCeldaD5 = findViewById(R.id.bttnCelda_D_5) as TextView
        var miCeldaD6 = findViewById(R.id.bttnCelda_D_6) as TextView
        var miCeldaD7 = findViewById(R.id.bttnCelda_D_7) as TextView
        var miCeldaD8 = findViewById(R.id.bttnCelda_D_8) as TextView
        var miCeldaD9 = findViewById(R.id.bttnCelda_D_9) as TextView
        var miCeldaD10 = findViewById(R.id.bttnCelda_D_10) as TextView

        var miCeldaE1 = findViewById(R.id.bttnCelda_E_1) as TextView
        var miCeldaE2 = findViewById(R.id.bttnCelda_E_2) as TextView
        var miCeldaE3 = findViewById(R.id.bttnCelda_E_3) as TextView
        var miCeldaE4 = findViewById(R.id.bttnCelda_E_4) as TextView
        var miCeldaE5 = findViewById(R.id.bttnCelda_E_5) as TextView
        var miCeldaE6 = findViewById(R.id.bttnCelda_E_6) as TextView
        var miCeldaE7 = findViewById(R.id.bttnCelda_E_7) as TextView
        var miCeldaE8 = findViewById(R.id.bttnCelda_E_8) as TextView
        var miCeldaE9 = findViewById(R.id.bttnCelda_E_9) as TextView
        var miCeldaE10 = findViewById(R.id.bttnCelda_E_10) as TextView

        var miCeldaF1 = findViewById(R.id.bttnCelda_F_1) as TextView
        var miCeldaF2 = findViewById(R.id.bttnCelda_F_2) as TextView
        var miCeldaF3 = findViewById(R.id.bttnCelda_F_3) as TextView
        var miCeldaF4 = findViewById(R.id.bttnCelda_F_4) as TextView
        var miCeldaF5 = findViewById(R.id.bttnCelda_F_5) as TextView
        var miCeldaF6 = findViewById(R.id.bttnCelda_F_6) as TextView
        var miCeldaF7 = findViewById(R.id.bttnCelda_F_7) as TextView
        var miCeldaF8 = findViewById(R.id.bttnCelda_F_8) as TextView
        var miCeldaF9 = findViewById(R.id.bttnCelda_F_9) as TextView
        var miCeldaF10 = findViewById(R.id.bttnCelda_F_10) as TextView

        var miCeldaG1 = findViewById(R.id.bttnCelda_G_1) as TextView
        var miCeldaG2 = findViewById(R.id.bttnCelda_G_2) as TextView
        var miCeldaG3 = findViewById(R.id.bttnCelda_G_3) as TextView
        var miCeldaG4 = findViewById(R.id.bttnCelda_G_4) as TextView
        var miCeldaG5 = findViewById(R.id.bttnCelda_G_5) as TextView
        var miCeldaG6 = findViewById(R.id.bttnCelda_G_6) as TextView
        var miCeldaG7 = findViewById(R.id.bttnCelda_G_7) as TextView
        var miCeldaG8 = findViewById(R.id.bttnCelda_G_8) as TextView
        var miCeldaG9 = findViewById(R.id.bttnCelda_G_9) as TextView
        var miCeldaG10 = findViewById(R.id.bttnCelda_G_10) as TextView

        var miCeldaH1 = findViewById(R.id.bttnCelda_H_1) as TextView
        var miCeldaH2 = findViewById(R.id.bttnCelda_H_2) as TextView
        var miCeldaH3 = findViewById(R.id.bttnCelda_H_3) as TextView
        var miCeldaH4 = findViewById(R.id.bttnCelda_H_4) as TextView
        var miCeldaH5 = findViewById(R.id.bttnCelda_H_5) as TextView
        var miCeldaH6 = findViewById(R.id.bttnCelda_H_6) as TextView
        var miCeldaH7 = findViewById(R.id.bttnCelda_H_7) as TextView
        var miCeldaH8 = findViewById(R.id.bttnCelda_H_8) as TextView
        var miCeldaH9 = findViewById(R.id.bttnCelda_H_9) as TextView
        var miCeldaH10 = findViewById(R.id.bttnCelda_H_10) as TextView

        var miCeldaI1 = findViewById(R.id.bttnCelda_I_1) as TextView
        var miCeldaI2 = findViewById(R.id.bttnCelda_I_2) as TextView
        var miCeldaI3 = findViewById(R.id.bttnCelda_I_3) as TextView
        var miCeldaI4 = findViewById(R.id.bttnCelda_I_4) as TextView
        var miCeldaI5 = findViewById(R.id.bttnCelda_I_5) as TextView
        var miCeldaI6 = findViewById(R.id.bttnCelda_I_6) as TextView
        var miCeldaI7 = findViewById(R.id.bttnCelda_I_7) as TextView
        var miCeldaI8 = findViewById(R.id.bttnCelda_I_8) as TextView
        var miCeldaI9 = findViewById(R.id.bttnCelda_I_9) as TextView
        var miCeldaI10 = findViewById(R.id.bttnCelda_I_10) as TextView

        var miCeldaJ1 = findViewById(R.id.bttnCelda_J_1) as TextView
        var miCeldaJ2 = findViewById(R.id.bttnCelda_J_2) as TextView
        var miCeldaJ3 = findViewById(R.id.bttnCelda_J_3) as TextView
        var miCeldaJ4 = findViewById(R.id.bttnCelda_J_4) as TextView
        var miCeldaJ5 = findViewById(R.id.bttnCelda_J_5) as TextView
        var miCeldaJ6 = findViewById(R.id.bttnCelda_J_6) as TextView
        var miCeldaJ7 = findViewById(R.id.bttnCelda_J_7) as TextView
        var miCeldaJ8 = findViewById(R.id.bttnCelda_J_8) as TextView
        var miCeldaJ9 = findViewById(R.id.bttnCelda_J_9) as TextView
        var miCeldaJ10 = findViewById(R.id.bttnCelda_J_10) as TextView


        misCeldas = arrayOf<Array<TextView>>(
            arrayOf<TextView>(miCeldaA1,miCeldaA2,miCeldaA3,miCeldaA4,miCeldaA5,miCeldaA6,miCeldaA7,miCeldaA8,miCeldaA9,miCeldaA10),
            arrayOf<TextView>(miCeldaB1,miCeldaB2,miCeldaB3,miCeldaB4,miCeldaB5,miCeldaB6,miCeldaB7,miCeldaB8,miCeldaB9,miCeldaB10),
            arrayOf<TextView>(miCeldaC1,miCeldaC2,miCeldaC3,miCeldaC4,miCeldaC5,miCeldaC6,miCeldaC7,miCeldaC8,miCeldaC9,miCeldaC10),
            arrayOf<TextView>(miCeldaD1,miCeldaD2,miCeldaD3,miCeldaD4,miCeldaD5,miCeldaD6,miCeldaD7,miCeldaD8,miCeldaD9,miCeldaD10),
            arrayOf<TextView>(miCeldaE1,miCeldaE2,miCeldaE3,miCeldaE4,miCeldaE5,miCeldaE6,miCeldaE7,miCeldaE8,miCeldaE9,miCeldaE10),
            arrayOf<TextView>(miCeldaF1,miCeldaF2,miCeldaF3,miCeldaF4,miCeldaF5,miCeldaF6,miCeldaF7,miCeldaF8,miCeldaF9,miCeldaF10),
            arrayOf<TextView>(miCeldaG1,miCeldaG2,miCeldaG3,miCeldaG4,miCeldaG5,miCeldaG6,miCeldaG7,miCeldaG8,miCeldaG9,miCeldaG10),
            arrayOf<TextView>(miCeldaH1,miCeldaH2,miCeldaH3,miCeldaH4,miCeldaH5,miCeldaH6,miCeldaH7,miCeldaH8,miCeldaH9,miCeldaH10),
            arrayOf<TextView>(miCeldaI1,miCeldaI2,miCeldaI3,miCeldaI4,miCeldaI5,miCeldaI6,miCeldaI7,miCeldaI8,miCeldaI9,miCeldaI10),
            arrayOf<TextView>(miCeldaJ1,miCeldaJ2,miCeldaJ3,miCeldaJ4,miCeldaJ5,miCeldaJ6,miCeldaJ7,miCeldaJ8,miCeldaJ9,miCeldaJ10)
        )

        miCeldaA1 = findViewById(R.id. bttnCeldaEnemiga_A_1) as TextView
        miCeldaA2 = findViewById(R.id. bttnCeldaEnemiga_A_2) as TextView
        miCeldaA3 = findViewById(R.id. bttnCeldaEnemiga_A_3) as TextView
        miCeldaA4 = findViewById(R.id. bttnCeldaEnemiga_A_4) as TextView
        miCeldaA5 = findViewById(R.id. bttnCeldaEnemiga_A_5) as TextView
        miCeldaA6 = findViewById(R.id. bttnCeldaEnemiga_A_6) as TextView
        miCeldaA7 = findViewById(R.id. bttnCeldaEnemiga_A_7) as TextView
        miCeldaA8 = findViewById(R.id. bttnCeldaEnemiga_A_8) as TextView
        miCeldaA9 = findViewById(R.id. bttnCeldaEnemiga_A_9) as TextView
        miCeldaA10 = findViewById(R.id. bttnCeldaEnemiga_A_10) as TextView

        miCeldaB1 = findViewById(R.id. bttnCeldaEnemiga_B_1) as TextView
        miCeldaB2 = findViewById(R.id. bttnCeldaEnemiga_B_2) as TextView
        miCeldaB3 = findViewById(R.id. bttnCeldaEnemiga_B_3) as TextView
        miCeldaB4 = findViewById(R.id. bttnCeldaEnemiga_B_4) as TextView
        miCeldaB5 = findViewById(R.id. bttnCeldaEnemiga_B_5) as TextView
        miCeldaB6 = findViewById(R.id. bttnCeldaEnemiga_B_6) as TextView
        miCeldaB7 = findViewById(R.id. bttnCeldaEnemiga_B_7) as TextView
        miCeldaB8 = findViewById(R.id. bttnCeldaEnemiga_B_8) as TextView
        miCeldaB9 = findViewById(R.id. bttnCeldaEnemiga_B_9) as TextView
        miCeldaB10 = findViewById(R.id. bttnCeldaEnemiga_B_10) as TextView

        miCeldaC1 = findViewById(R.id. bttnCeldaEnemiga_C_1) as TextView
        miCeldaC2 = findViewById(R.id. bttnCeldaEnemiga_C_2) as TextView
        miCeldaC3 = findViewById(R.id. bttnCeldaEnemiga_C_3) as TextView
        miCeldaC4 = findViewById(R.id. bttnCeldaEnemiga_C_4) as TextView
        miCeldaC5 = findViewById(R.id. bttnCeldaEnemiga_C_5) as TextView
        miCeldaC6 = findViewById(R.id. bttnCeldaEnemiga_C_6) as TextView
        miCeldaC7 = findViewById(R.id. bttnCeldaEnemiga_C_7) as TextView
        miCeldaC8 = findViewById(R.id. bttnCeldaEnemiga_C_8) as TextView
        miCeldaC9 = findViewById(R.id. bttnCeldaEnemiga_C_9) as TextView
        miCeldaC10 = findViewById(R.id. bttnCeldaEnemiga_C_10) as TextView

        miCeldaD1 = findViewById(R.id. bttnCeldaEnemiga_D_1) as TextView
        miCeldaD2 = findViewById(R.id. bttnCeldaEnemiga_D_2) as TextView
        miCeldaD3 = findViewById(R.id. bttnCeldaEnemiga_D_3) as TextView
        miCeldaD4 = findViewById(R.id. bttnCeldaEnemiga_D_4) as TextView
        miCeldaD5 = findViewById(R.id. bttnCeldaEnemiga_D_5) as TextView
        miCeldaD6 = findViewById(R.id. bttnCeldaEnemiga_D_6) as TextView
        miCeldaD7 = findViewById(R.id. bttnCeldaEnemiga_D_7) as TextView
        miCeldaD8 = findViewById(R.id. bttnCeldaEnemiga_D_8) as TextView
        miCeldaD9 = findViewById(R.id. bttnCeldaEnemiga_D_9) as TextView
        miCeldaD10 = findViewById(R.id. bttnCeldaEnemiga_D_10) as TextView

        miCeldaE1 = findViewById(R.id. bttnCeldaEnemiga_E_1) as TextView
        miCeldaE2 = findViewById(R.id. bttnCeldaEnemiga_E_2) as TextView
        miCeldaE3 = findViewById(R.id. bttnCeldaEnemiga_E_3) as TextView
        miCeldaE4 = findViewById(R.id. bttnCeldaEnemiga_E_4) as TextView
        miCeldaE5 = findViewById(R.id. bttnCeldaEnemiga_E_5) as TextView
        miCeldaE6 = findViewById(R.id. bttnCeldaEnemiga_E_6) as TextView
        miCeldaE7 = findViewById(R.id. bttnCeldaEnemiga_E_7) as TextView
        miCeldaE8 = findViewById(R.id. bttnCeldaEnemiga_E_8) as TextView
        miCeldaE9 = findViewById(R.id. bttnCeldaEnemiga_E_9) as TextView
        miCeldaE10 = findViewById(R.id. bttnCeldaEnemiga_E_10) as TextView

        miCeldaF1 = findViewById(R.id. bttnCeldaEnemiga_F_1) as TextView
        miCeldaF2 = findViewById(R.id. bttnCeldaEnemiga_F_2) as TextView
        miCeldaF3 = findViewById(R.id. bttnCeldaEnemiga_F_3) as TextView
        miCeldaF4 = findViewById(R.id. bttnCeldaEnemiga_F_4) as TextView
        miCeldaF5 = findViewById(R.id. bttnCeldaEnemiga_F_5) as TextView
        miCeldaF6 = findViewById(R.id. bttnCeldaEnemiga_F_6) as TextView
        miCeldaF7 = findViewById(R.id. bttnCeldaEnemiga_F_7) as TextView
        miCeldaF8 = findViewById(R.id. bttnCeldaEnemiga_F_8) as TextView
        miCeldaF9 = findViewById(R.id. bttnCeldaEnemiga_F_9) as TextView
        miCeldaF10 = findViewById(R.id. bttnCeldaEnemiga_F_10) as TextView

        miCeldaG1 = findViewById(R.id. bttnCeldaEnemiga_G_1) as TextView
        miCeldaG2 = findViewById(R.id. bttnCeldaEnemiga_G_2) as TextView
        miCeldaG3 = findViewById(R.id. bttnCeldaEnemiga_G_3) as TextView
        miCeldaG4 = findViewById(R.id. bttnCeldaEnemiga_G_4) as TextView
        miCeldaG5 = findViewById(R.id. bttnCeldaEnemiga_G_5) as TextView
        miCeldaG6 = findViewById(R.id. bttnCeldaEnemiga_G_6) as TextView
        miCeldaG7 = findViewById(R.id. bttnCeldaEnemiga_G_7) as TextView
        miCeldaG8 = findViewById(R.id. bttnCeldaEnemiga_G_8) as TextView
        miCeldaG9 = findViewById(R.id. bttnCeldaEnemiga_G_9) as TextView
        miCeldaG10 = findViewById(R.id. bttnCeldaEnemiga_G_10) as TextView

        miCeldaH1 = findViewById(R.id. bttnCeldaEnemiga_H_1) as TextView
        miCeldaH2 = findViewById(R.id. bttnCeldaEnemiga_H_2) as TextView
        miCeldaH3 = findViewById(R.id. bttnCeldaEnemiga_H_3) as TextView
        miCeldaH4 = findViewById(R.id. bttnCeldaEnemiga_H_4) as TextView
        miCeldaH5 = findViewById(R.id. bttnCeldaEnemiga_H_5) as TextView
        miCeldaH6 = findViewById(R.id. bttnCeldaEnemiga_H_6) as TextView
        miCeldaH7 = findViewById(R.id. bttnCeldaEnemiga_H_7) as TextView
        miCeldaH8 = findViewById(R.id. bttnCeldaEnemiga_H_8) as TextView
        miCeldaH9 = findViewById(R.id. bttnCeldaEnemiga_H_9) as TextView
        miCeldaH10 = findViewById(R.id. bttnCeldaEnemiga_H_10) as TextView

        miCeldaI1 = findViewById(R.id. bttnCeldaEnemiga_I_1) as TextView
        miCeldaI2 = findViewById(R.id. bttnCeldaEnemiga_I_2) as TextView
        miCeldaI3 = findViewById(R.id. bttnCeldaEnemiga_I_3) as TextView
        miCeldaI4 = findViewById(R.id. bttnCeldaEnemiga_I_4) as TextView
        miCeldaI5 = findViewById(R.id. bttnCeldaEnemiga_I_5) as TextView
        miCeldaI6 = findViewById(R.id. bttnCeldaEnemiga_I_6) as TextView
        miCeldaI7 = findViewById(R.id. bttnCeldaEnemiga_I_7) as TextView
        miCeldaI8 = findViewById(R.id. bttnCeldaEnemiga_I_8) as TextView
        miCeldaI9 = findViewById(R.id. bttnCeldaEnemiga_I_9) as TextView
        miCeldaI10 = findViewById(R.id. bttnCeldaEnemiga_I_10) as TextView

        miCeldaJ1 = findViewById(R.id. bttnCeldaEnemiga_J_1) as TextView
        miCeldaJ2 = findViewById(R.id. bttnCeldaEnemiga_J_2) as TextView
        miCeldaJ3 = findViewById(R.id. bttnCeldaEnemiga_J_3) as TextView
        miCeldaJ4 = findViewById(R.id. bttnCeldaEnemiga_J_4) as TextView
        miCeldaJ5 = findViewById(R.id. bttnCeldaEnemiga_J_5) as TextView
        miCeldaJ6 = findViewById(R.id. bttnCeldaEnemiga_J_6) as TextView
        miCeldaJ7 = findViewById(R.id. bttnCeldaEnemiga_J_7) as TextView
        miCeldaJ8 = findViewById(R.id. bttnCeldaEnemiga_J_8) as TextView
        miCeldaJ9 = findViewById(R.id. bttnCeldaEnemiga_J_9) as TextView
        miCeldaJ10 = findViewById(R.id. bttnCeldaEnemiga_J_10) as TextView


        celdasEnemigas = arrayOf<Array<TextView>>(
            arrayOf<TextView>(miCeldaA1,miCeldaA2,miCeldaA3,miCeldaA4,miCeldaA5,miCeldaA6,miCeldaA7,miCeldaA8,miCeldaA9,miCeldaA10),
            arrayOf<TextView>(miCeldaB1,miCeldaB2,miCeldaB3,miCeldaB4,miCeldaB5,miCeldaB6,miCeldaB7,miCeldaB8,miCeldaB9,miCeldaB10),
            arrayOf<TextView>(miCeldaC1,miCeldaC2,miCeldaC3,miCeldaC4,miCeldaC5,miCeldaC6,miCeldaC7,miCeldaC8,miCeldaC9,miCeldaC10),
            arrayOf<TextView>(miCeldaD1,miCeldaD2,miCeldaD3,miCeldaD4,miCeldaD5,miCeldaD6,miCeldaD7,miCeldaD8,miCeldaD9,miCeldaD10),
            arrayOf<TextView>(miCeldaE1,miCeldaE2,miCeldaE3,miCeldaE4,miCeldaE5,miCeldaE6,miCeldaE7,miCeldaE8,miCeldaE9,miCeldaE10),
            arrayOf<TextView>(miCeldaF1,miCeldaF2,miCeldaF3,miCeldaF4,miCeldaF5,miCeldaF6,miCeldaF7,miCeldaF8,miCeldaF9,miCeldaF10),
            arrayOf<TextView>(miCeldaG1,miCeldaG2,miCeldaG3,miCeldaG4,miCeldaG5,miCeldaG6,miCeldaG7,miCeldaG8,miCeldaG9,miCeldaG10),
            arrayOf<TextView>(miCeldaH1,miCeldaH2,miCeldaH3,miCeldaH4,miCeldaH5,miCeldaH6,miCeldaH7,miCeldaH8,miCeldaH9,miCeldaH10),
            arrayOf<TextView>(miCeldaI1,miCeldaI2,miCeldaI3,miCeldaI4,miCeldaI5,miCeldaI6,miCeldaI7,miCeldaI8,miCeldaI9,miCeldaI10),
            arrayOf<TextView>(miCeldaJ1,miCeldaJ2,miCeldaJ3,miCeldaJ4,miCeldaJ5,miCeldaJ6,miCeldaJ7,miCeldaJ8,miCeldaJ9,miCeldaJ10)
        )

        val handler = View.OnClickListener { view ->
            if(view is TextView){
                for (i in 0 until 10) {
                    for (j in 0 until 10) {
                        if (view.id == celdasEnemigas[i][j].id) {
                            atacarCelda(PointF(i.toFloat(),j.toFloat()))
                        }
                    }
                }
            }
        }

        for (i in 0 until 10) {
            for (j in 0 until 10) {
                celdasEnemigas[i][j].setOnClickListener(handler)
            }
        }
    }

}

/*class Ingame_boards : AppCompatActivity() {
    private  val met = Metodos()
    private var misCeldas = arrayOf<Array<TextView>>()
    private var celdasEnemigas = arrayOf<Array<TextView>>()

    //Es la que obtiene al tablero amigo, es decir de este jugador
    var matrizAmiga : ArrayList<ArrayList<Boolean>> = ArrayList()

    //Es la que obtiene al tablero enemigo, es decir de este jugador
    var matrizEnemiga : ArrayList<ArrayList<Boolean>> = ArrayList()

    private var esMiTurno:Boolean = false //Variable usada para pasar la bandera de quién ataca

    private var numJugador: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingame_boards)
        numJugador = 1
        inicializarCeldas()
        //Recibimos tablero enemigo
        recibirTablero()
        // esMiTurno = false;
    }

    fun atacarCelda(coord: PointF){
        //Funcion a implementar con API
        if(!esMiTurno) return //Talvez mostrar el tiempo restante del enemigo en pantalla

        //Desactivar la celda atacada. (not clickable)

        //
    }

    fun actualizarMiTablero(celda: PointF, nuevoColor: Color){
        //Funcion a implementar con API
        CoroutineScope(Dispatchers.IO).launch {
            var numeroTablero: Int = numJugador
            val call = met.getRetrofit().create(APIService::class.java)
                .getTablero("/tablero/${numeroTablero}/").execute()
            //Tenemos ya el tablero
            val tablero = call.body() as tableroResponse
            //Lo guardamos en un arraylist de tipo booleano
            matrizAmiga = convertirTablero(tablero)
        }
    }



    public fun actualizarMiMarcador(fallos:Int, aciertos:Int){

    }

    fun actualizarMarcadorEnemigo(fallos:Int, aciertos:Int){

    }

    fun actualizarTableroAtaque(celda: PointF, nuevoColor: Color){
        //Funcion a implementar con API
        CoroutineScope(Dispatchers.IO).launch {
            var fila: Int = 0
            var numeroTablero: Int
            if(numJugador == 1)
                numeroTablero = 2
            else
                numeroTablero = 1

            val call = met.getRetrofit().create(APIService::class.java)
                .getTablero("/tablero/${numeroTablero}/").execute()

            //Tenemos ya el tablero
            val tablero = call.body() as tableroResponse
            //Lo guardamos en un arraylist de tipo booleano
            matrizEnemiga = convertirTablero(tablero)
        }

    }

    fun getMiTurno():Boolean{return esMiTurno}

    fun recibirTablero(){
        //Recibir el tablero enemigo desde la API.

        CoroutineScope(Dispatchers.IO).launch {
            var fila: Int = 0
            var numeroTablero: Int
            if(numJugador == 1)
                numeroTablero = 2
            else
                numeroTablero = 1

            val call = met.getRetrofit().create(APIService::class.java)
                .getTablero("/tablero/${numeroTablero}/").execute()

            //Tenemos ya el tablero
            val tablero = call.body() as tableroResponse
            //Lo guardamos en un arraylist de tipo booleano
            matrizEnemiga = convertirTablero(tablero)
        }
    }

    private fun convertirTablero(tablero : tableroResponse) : ArrayList<ArrayList<Boolean>> {
        var matriz : ArrayList<ArrayList<Boolean>> = ArrayList()

        //println("El tablero es: "+tablero)
        for(i in tablero.array){
            //println("Fila $fila col1 ${i.col1} col2 ${i.col2}")
            var filaLista : ArrayList<Boolean> = ArrayList()
            filaLista.add( toBoolean(i.col1))
            filaLista.add(toBoolean(i.col2))
            filaLista.add(toBoolean(i.col3))
            filaLista.add(toBoolean(i.col4))
            filaLista.add(toBoolean(i.col5))
            filaLista.add(toBoolean(i.col6))
            filaLista.add(toBoolean(i.col7))
            filaLista.add(toBoolean(i.col8))
            filaLista.add(toBoolean(i.col9))
            filaLista.add(toBoolean(i.col10))
            matriz.add(filaLista)
            //fila = fila+1;
        }
        /*println("Matriz: "+matriz)
        println("Comienza el ciclo  Tamaño filas= ${matriz.size}")
        println("Comienza el ciclo  Tamaño columnas = ${matriz[0].size}")
        for(  i in 0 until matriz.size){
            for( j in 0 until 10){
                print("${matriz[i][j]} ")
            }
            println()
        }*/
        return matriz
    }


    private fun inicializarCeldas(){
        var miCeldaA1 = findViewById(R.id.bttnCelda_A_1) as TextView
        var miCeldaA2 = findViewById(R.id.bttnCelda_A_2) as TextView
        var miCeldaA3 = findViewById(R.id.bttnCelda_A_3) as TextView
        var miCeldaA4 = findViewById(R.id.bttnCelda_A_4) as TextView
        var miCeldaA5 = findViewById(R.id.bttnCelda_A_5) as TextView
        var miCeldaA6 = findViewById(R.id.bttnCelda_A_6) as TextView
        var miCeldaA7 = findViewById(R.id.bttnCelda_A_7) as TextView
        var miCeldaA8 = findViewById(R.id.bttnCelda_A_8) as TextView
        var miCeldaA9 = findViewById(R.id.bttnCelda_A_9) as TextView
        var miCeldaA10 = findViewById(R.id.bttnCelda_A_10) as TextView

        var miCeldaB1 = findViewById(R.id.bttnCelda_B_1) as TextView
        var miCeldaB2 = findViewById(R.id.bttnCelda_B_2) as TextView
        var miCeldaB3 = findViewById(R.id.bttnCelda_B_3) as TextView
        var miCeldaB4 = findViewById(R.id.bttnCelda_B_4) as TextView
        var miCeldaB5 = findViewById(R.id.bttnCelda_B_5) as TextView
        var miCeldaB6 = findViewById(R.id.bttnCelda_B_6) as TextView
        var miCeldaB7 = findViewById(R.id.bttnCelda_B_7) as TextView
        var miCeldaB8 = findViewById(R.id.bttnCelda_B_8) as TextView
        var miCeldaB9 = findViewById(R.id.bttnCelda_B_9) as TextView
        var miCeldaB10 = findViewById(R.id.bttnCelda_B_10) as TextView

        var miCeldaC1 = findViewById(R.id.bttnCelda_C_1) as TextView
        var miCeldaC2 = findViewById(R.id.bttnCelda_C_2) as TextView
        var miCeldaC3 = findViewById(R.id.bttnCelda_C_3) as TextView
        var miCeldaC4 = findViewById(R.id.bttnCelda_C_4) as TextView
        var miCeldaC5 = findViewById(R.id.bttnCelda_C_5) as TextView
        var miCeldaC6 = findViewById(R.id.bttnCelda_C_6) as TextView
        var miCeldaC7 = findViewById(R.id.bttnCelda_C_7) as TextView
        var miCeldaC8 = findViewById(R.id.bttnCelda_C_8) as TextView
        var miCeldaC9 = findViewById(R.id.bttnCelda_C_9) as TextView
        var miCeldaC10 = findViewById(R.id.bttnCelda_C_10) as TextView

        var miCeldaD1 = findViewById(R.id.bttnCelda_D_1) as TextView
        var miCeldaD2 = findViewById(R.id.bttnCelda_D_2) as TextView
        var miCeldaD3 = findViewById(R.id.bttnCelda_D_3) as TextView
        var miCeldaD4 = findViewById(R.id.bttnCelda_D_4) as TextView
        var miCeldaD5 = findViewById(R.id.bttnCelda_D_5) as TextView
        var miCeldaD6 = findViewById(R.id.bttnCelda_D_6) as TextView
        var miCeldaD7 = findViewById(R.id.bttnCelda_D_7) as TextView
        var miCeldaD8 = findViewById(R.id.bttnCelda_D_8) as TextView
        var miCeldaD9 = findViewById(R.id.bttnCelda_D_9) as TextView
        var miCeldaD10 = findViewById(R.id.bttnCelda_D_10) as TextView

        var miCeldaE1 = findViewById(R.id.bttnCelda_E_1) as TextView
        var miCeldaE2 = findViewById(R.id.bttnCelda_E_2) as TextView
        var miCeldaE3 = findViewById(R.id.bttnCelda_E_3) as TextView
        var miCeldaE4 = findViewById(R.id.bttnCelda_E_4) as TextView
        var miCeldaE5 = findViewById(R.id.bttnCelda_E_5) as TextView
        var miCeldaE6 = findViewById(R.id.bttnCelda_E_6) as TextView
        var miCeldaE7 = findViewById(R.id.bttnCelda_E_7) as TextView
        var miCeldaE8 = findViewById(R.id.bttnCelda_E_8) as TextView
        var miCeldaE9 = findViewById(R.id.bttnCelda_E_9) as TextView
        var miCeldaE10 = findViewById(R.id.bttnCelda_E_10) as TextView

        var miCeldaF1 = findViewById(R.id.bttnCelda_F_1) as TextView
        var miCeldaF2 = findViewById(R.id.bttnCelda_F_2) as TextView
        var miCeldaF3 = findViewById(R.id.bttnCelda_F_3) as TextView
        var miCeldaF4 = findViewById(R.id.bttnCelda_F_4) as TextView
        var miCeldaF5 = findViewById(R.id.bttnCelda_F_5) as TextView
        var miCeldaF6 = findViewById(R.id.bttnCelda_F_6) as TextView
        var miCeldaF7 = findViewById(R.id.bttnCelda_F_7) as TextView
        var miCeldaF8 = findViewById(R.id.bttnCelda_F_8) as TextView
        var miCeldaF9 = findViewById(R.id.bttnCelda_F_9) as TextView
        var miCeldaF10 = findViewById(R.id.bttnCelda_F_10) as TextView

        var miCeldaG1 = findViewById(R.id.bttnCelda_G_1) as TextView
        var miCeldaG2 = findViewById(R.id.bttnCelda_G_2) as TextView
        var miCeldaG3 = findViewById(R.id.bttnCelda_G_3) as TextView
        var miCeldaG4 = findViewById(R.id.bttnCelda_G_4) as TextView
        var miCeldaG5 = findViewById(R.id.bttnCelda_G_5) as TextView
        var miCeldaG6 = findViewById(R.id.bttnCelda_G_6) as TextView
        var miCeldaG7 = findViewById(R.id.bttnCelda_G_7) as TextView
        var miCeldaG8 = findViewById(R.id.bttnCelda_G_8) as TextView
        var miCeldaG9 = findViewById(R.id.bttnCelda_G_9) as TextView
        var miCeldaG10 = findViewById(R.id.bttnCelda_G_10) as TextView

        var miCeldaH1 = findViewById(R.id.bttnCelda_H_1) as TextView
        var miCeldaH2 = findViewById(R.id.bttnCelda_H_2) as TextView
        var miCeldaH3 = findViewById(R.id.bttnCelda_H_3) as TextView
        var miCeldaH4 = findViewById(R.id.bttnCelda_H_4) as TextView
        var miCeldaH5 = findViewById(R.id.bttnCelda_H_5) as TextView
        var miCeldaH6 = findViewById(R.id.bttnCelda_H_6) as TextView
        var miCeldaH7 = findViewById(R.id.bttnCelda_H_7) as TextView
        var miCeldaH8 = findViewById(R.id.bttnCelda_H_8) as TextView
        var miCeldaH9 = findViewById(R.id.bttnCelda_H_9) as TextView
        var miCeldaH10 = findViewById(R.id.bttnCelda_H_10) as TextView

        var miCeldaI1 = findViewById(R.id.bttnCelda_I_1) as TextView
        var miCeldaI2 = findViewById(R.id.bttnCelda_I_2) as TextView
        var miCeldaI3 = findViewById(R.id.bttnCelda_I_3) as TextView
        var miCeldaI4 = findViewById(R.id.bttnCelda_I_4) as TextView
        var miCeldaI5 = findViewById(R.id.bttnCelda_I_5) as TextView
        var miCeldaI6 = findViewById(R.id.bttnCelda_I_6) as TextView
        var miCeldaI7 = findViewById(R.id.bttnCelda_I_7) as TextView
        var miCeldaI8 = findViewById(R.id.bttnCelda_I_8) as TextView
        var miCeldaI9 = findViewById(R.id.bttnCelda_I_9) as TextView
        var miCeldaI10 = findViewById(R.id.bttnCelda_I_10) as TextView

        var miCeldaJ1 = findViewById(R.id.bttnCelda_J_1) as TextView
        var miCeldaJ2 = findViewById(R.id.bttnCelda_J_2) as TextView
        var miCeldaJ3 = findViewById(R.id.bttnCelda_J_3) as TextView
        var miCeldaJ4 = findViewById(R.id.bttnCelda_J_4) as TextView
        var miCeldaJ5 = findViewById(R.id.bttnCelda_J_5) as TextView
        var miCeldaJ6 = findViewById(R.id.bttnCelda_J_6) as TextView
        var miCeldaJ7 = findViewById(R.id.bttnCelda_J_7) as TextView
        var miCeldaJ8 = findViewById(R.id.bttnCelda_J_8) as TextView
        var miCeldaJ9 = findViewById(R.id.bttnCelda_J_9) as TextView
        var miCeldaJ10 = findViewById(R.id.bttnCelda_J_10) as TextView


        misCeldas = arrayOf<Array<TextView>>(
            arrayOf<TextView>(miCeldaA1,miCeldaA2,miCeldaA3,miCeldaA4,miCeldaA5,miCeldaA6,miCeldaA7,miCeldaA8,miCeldaA9,miCeldaA10),
            arrayOf<TextView>(miCeldaB1,miCeldaB2,miCeldaB3,miCeldaB4,miCeldaB5,miCeldaB6,miCeldaB7,miCeldaB8,miCeldaB9,miCeldaB10),
            arrayOf<TextView>(miCeldaC1,miCeldaC2,miCeldaC3,miCeldaC4,miCeldaC5,miCeldaC6,miCeldaC7,miCeldaC8,miCeldaC9,miCeldaC10),
            arrayOf<TextView>(miCeldaD1,miCeldaD2,miCeldaD3,miCeldaD4,miCeldaD5,miCeldaD6,miCeldaD7,miCeldaD8,miCeldaD9,miCeldaD10),
            arrayOf<TextView>(miCeldaE1,miCeldaE2,miCeldaE3,miCeldaE4,miCeldaE5,miCeldaE6,miCeldaE7,miCeldaE8,miCeldaE9,miCeldaE10),
            arrayOf<TextView>(miCeldaF1,miCeldaF2,miCeldaF3,miCeldaF4,miCeldaF5,miCeldaF6,miCeldaF7,miCeldaF8,miCeldaF9,miCeldaF10),
            arrayOf<TextView>(miCeldaG1,miCeldaG2,miCeldaG3,miCeldaG4,miCeldaG5,miCeldaG6,miCeldaG7,miCeldaG8,miCeldaG9,miCeldaG10),
            arrayOf<TextView>(miCeldaH1,miCeldaH2,miCeldaH3,miCeldaH4,miCeldaH5,miCeldaH6,miCeldaH7,miCeldaH8,miCeldaH9,miCeldaH10),
            arrayOf<TextView>(miCeldaI1,miCeldaI2,miCeldaI3,miCeldaI4,miCeldaI5,miCeldaI6,miCeldaI7,miCeldaI8,miCeldaI9,miCeldaI10),
            arrayOf<TextView>(miCeldaJ1,miCeldaJ2,miCeldaJ3,miCeldaJ4,miCeldaJ5,miCeldaJ6,miCeldaJ7,miCeldaJ8,miCeldaJ9,miCeldaJ10)
        )

        miCeldaA1 = findViewById(R.id. bttnCeldaEnemiga_A_1) as TextView
        miCeldaA2 = findViewById(R.id. bttnCeldaEnemiga_A_2) as TextView
        miCeldaA3 = findViewById(R.id. bttnCeldaEnemiga_A_3) as TextView
        miCeldaA4 = findViewById(R.id. bttnCeldaEnemiga_A_4) as TextView
        miCeldaA5 = findViewById(R.id. bttnCeldaEnemiga_A_5) as TextView
        miCeldaA6 = findViewById(R.id. bttnCeldaEnemiga_A_6) as TextView
        miCeldaA7 = findViewById(R.id. bttnCeldaEnemiga_A_7) as TextView
        miCeldaA8 = findViewById(R.id. bttnCeldaEnemiga_A_8) as TextView
        miCeldaA9 = findViewById(R.id. bttnCeldaEnemiga_A_9) as TextView
        miCeldaA10 = findViewById(R.id. bttnCeldaEnemiga_A_10) as TextView

        miCeldaB1 = findViewById(R.id. bttnCeldaEnemiga_B_1) as TextView
        miCeldaB2 = findViewById(R.id. bttnCeldaEnemiga_B_2) as TextView
        miCeldaB3 = findViewById(R.id. bttnCeldaEnemiga_B_3) as TextView
        miCeldaB4 = findViewById(R.id. bttnCeldaEnemiga_B_4) as TextView
        miCeldaB5 = findViewById(R.id. bttnCeldaEnemiga_B_5) as TextView
        miCeldaB6 = findViewById(R.id. bttnCeldaEnemiga_B_6) as TextView
        miCeldaB7 = findViewById(R.id. bttnCeldaEnemiga_B_7) as TextView
        miCeldaB8 = findViewById(R.id. bttnCeldaEnemiga_B_8) as TextView
        miCeldaB9 = findViewById(R.id. bttnCeldaEnemiga_B_9) as TextView
        miCeldaB10 = findViewById(R.id. bttnCeldaEnemiga_B_10) as TextView

        miCeldaC1 = findViewById(R.id. bttnCeldaEnemiga_C_1) as TextView
        miCeldaC2 = findViewById(R.id. bttnCeldaEnemiga_C_2) as TextView
        miCeldaC3 = findViewById(R.id. bttnCeldaEnemiga_C_3) as TextView
        miCeldaC4 = findViewById(R.id. bttnCeldaEnemiga_C_4) as TextView
        miCeldaC5 = findViewById(R.id. bttnCeldaEnemiga_C_5) as TextView
        miCeldaC6 = findViewById(R.id. bttnCeldaEnemiga_C_6) as TextView
        miCeldaC7 = findViewById(R.id. bttnCeldaEnemiga_C_7) as TextView
        miCeldaC8 = findViewById(R.id. bttnCeldaEnemiga_C_8) as TextView
        miCeldaC9 = findViewById(R.id. bttnCeldaEnemiga_C_9) as TextView
        miCeldaC10 = findViewById(R.id. bttnCeldaEnemiga_C_10) as TextView

        miCeldaD1 = findViewById(R.id. bttnCeldaEnemiga_D_1) as TextView
        miCeldaD2 = findViewById(R.id. bttnCeldaEnemiga_D_2) as TextView
        miCeldaD3 = findViewById(R.id. bttnCeldaEnemiga_D_3) as TextView
        miCeldaD4 = findViewById(R.id. bttnCeldaEnemiga_D_4) as TextView
        miCeldaD5 = findViewById(R.id. bttnCeldaEnemiga_D_5) as TextView
        miCeldaD6 = findViewById(R.id. bttnCeldaEnemiga_D_6) as TextView
        miCeldaD7 = findViewById(R.id. bttnCeldaEnemiga_D_7) as TextView
        miCeldaD8 = findViewById(R.id. bttnCeldaEnemiga_D_8) as TextView
        miCeldaD9 = findViewById(R.id. bttnCeldaEnemiga_D_9) as TextView
        miCeldaD10 = findViewById(R.id. bttnCeldaEnemiga_D_10) as TextView

        miCeldaE1 = findViewById(R.id. bttnCeldaEnemiga_E_1) as TextView
        miCeldaE2 = findViewById(R.id. bttnCeldaEnemiga_E_2) as TextView
        miCeldaE3 = findViewById(R.id. bttnCeldaEnemiga_E_3) as TextView
        miCeldaE4 = findViewById(R.id. bttnCeldaEnemiga_E_4) as TextView
        miCeldaE5 = findViewById(R.id. bttnCeldaEnemiga_E_5) as TextView
        miCeldaE6 = findViewById(R.id. bttnCeldaEnemiga_E_6) as TextView
        miCeldaE7 = findViewById(R.id. bttnCeldaEnemiga_E_7) as TextView
        miCeldaE8 = findViewById(R.id. bttnCeldaEnemiga_E_8) as TextView
        miCeldaE9 = findViewById(R.id. bttnCeldaEnemiga_E_9) as TextView
        miCeldaE10 = findViewById(R.id. bttnCeldaEnemiga_E_10) as TextView

        miCeldaF1 = findViewById(R.id. bttnCeldaEnemiga_F_1) as TextView
        miCeldaF2 = findViewById(R.id. bttnCeldaEnemiga_F_2) as TextView
        miCeldaF3 = findViewById(R.id. bttnCeldaEnemiga_F_3) as TextView
        miCeldaF4 = findViewById(R.id. bttnCeldaEnemiga_F_4) as TextView
        miCeldaF5 = findViewById(R.id. bttnCeldaEnemiga_F_5) as TextView
        miCeldaF6 = findViewById(R.id. bttnCeldaEnemiga_F_6) as TextView
        miCeldaF7 = findViewById(R.id. bttnCeldaEnemiga_F_7) as TextView
        miCeldaF8 = findViewById(R.id. bttnCeldaEnemiga_F_8) as TextView
        miCeldaF9 = findViewById(R.id. bttnCeldaEnemiga_F_9) as TextView
        miCeldaF10 = findViewById(R.id. bttnCeldaEnemiga_F_10) as TextView

        miCeldaG1 = findViewById(R.id. bttnCeldaEnemiga_G_1) as TextView
        miCeldaG2 = findViewById(R.id. bttnCeldaEnemiga_G_2) as TextView
        miCeldaG3 = findViewById(R.id. bttnCeldaEnemiga_G_3) as TextView
        miCeldaG4 = findViewById(R.id. bttnCeldaEnemiga_G_4) as TextView
        miCeldaG5 = findViewById(R.id. bttnCeldaEnemiga_G_5) as TextView
        miCeldaG6 = findViewById(R.id. bttnCeldaEnemiga_G_6) as TextView
        miCeldaG7 = findViewById(R.id. bttnCeldaEnemiga_G_7) as TextView
        miCeldaG8 = findViewById(R.id. bttnCeldaEnemiga_G_8) as TextView
        miCeldaG9 = findViewById(R.id. bttnCeldaEnemiga_G_9) as TextView
        miCeldaG10 = findViewById(R.id. bttnCeldaEnemiga_G_10) as TextView

        miCeldaH1 = findViewById(R.id. bttnCeldaEnemiga_H_1) as TextView
        miCeldaH2 = findViewById(R.id. bttnCeldaEnemiga_H_2) as TextView
        miCeldaH3 = findViewById(R.id. bttnCeldaEnemiga_H_3) as TextView
        miCeldaH4 = findViewById(R.id. bttnCeldaEnemiga_H_4) as TextView
        miCeldaH5 = findViewById(R.id. bttnCeldaEnemiga_H_5) as TextView
        miCeldaH6 = findViewById(R.id. bttnCeldaEnemiga_H_6) as TextView
        miCeldaH7 = findViewById(R.id. bttnCeldaEnemiga_H_7) as TextView
        miCeldaH8 = findViewById(R.id. bttnCeldaEnemiga_H_8) as TextView
        miCeldaH9 = findViewById(R.id. bttnCeldaEnemiga_H_9) as TextView
        miCeldaH10 = findViewById(R.id. bttnCeldaEnemiga_H_10) as TextView

        miCeldaI1 = findViewById(R.id. bttnCeldaEnemiga_I_1) as TextView
        miCeldaI2 = findViewById(R.id. bttnCeldaEnemiga_I_2) as TextView
        miCeldaI3 = findViewById(R.id. bttnCeldaEnemiga_I_3) as TextView
        miCeldaI4 = findViewById(R.id. bttnCeldaEnemiga_I_4) as TextView
        miCeldaI5 = findViewById(R.id. bttnCeldaEnemiga_I_5) as TextView
        miCeldaI6 = findViewById(R.id. bttnCeldaEnemiga_I_6) as TextView
        miCeldaI7 = findViewById(R.id. bttnCeldaEnemiga_I_7) as TextView
        miCeldaI8 = findViewById(R.id. bttnCeldaEnemiga_I_8) as TextView
        miCeldaI9 = findViewById(R.id. bttnCeldaEnemiga_I_9) as TextView
        miCeldaI10 = findViewById(R.id. bttnCeldaEnemiga_I_10) as TextView

        miCeldaJ1 = findViewById(R.id. bttnCeldaEnemiga_J_1) as TextView
        miCeldaJ2 = findViewById(R.id. bttnCeldaEnemiga_J_2) as TextView
        miCeldaJ3 = findViewById(R.id. bttnCeldaEnemiga_J_3) as TextView
        miCeldaJ4 = findViewById(R.id. bttnCeldaEnemiga_J_4) as TextView
        miCeldaJ5 = findViewById(R.id. bttnCeldaEnemiga_J_5) as TextView
        miCeldaJ6 = findViewById(R.id. bttnCeldaEnemiga_J_6) as TextView
        miCeldaJ7 = findViewById(R.id. bttnCeldaEnemiga_J_7) as TextView
        miCeldaJ8 = findViewById(R.id. bttnCeldaEnemiga_J_8) as TextView
        miCeldaJ9 = findViewById(R.id. bttnCeldaEnemiga_J_9) as TextView
        miCeldaJ10 = findViewById(R.id. bttnCeldaEnemiga_J_10) as TextView


        celdasEnemigas = arrayOf<Array<TextView>>(
            arrayOf<TextView>(miCeldaA1,miCeldaA2,miCeldaA3,miCeldaA4,miCeldaA5,miCeldaA6,miCeldaA7,miCeldaA8,miCeldaA9,miCeldaA10),
            arrayOf<TextView>(miCeldaB1,miCeldaB2,miCeldaB3,miCeldaB4,miCeldaB5,miCeldaB6,miCeldaB7,miCeldaB8,miCeldaB9,miCeldaB10),
            arrayOf<TextView>(miCeldaC1,miCeldaC2,miCeldaC3,miCeldaC4,miCeldaC5,miCeldaC6,miCeldaC7,miCeldaC8,miCeldaC9,miCeldaC10),
            arrayOf<TextView>(miCeldaD1,miCeldaD2,miCeldaD3,miCeldaD4,miCeldaD5,miCeldaD6,miCeldaD7,miCeldaD8,miCeldaD9,miCeldaD10),
            arrayOf<TextView>(miCeldaE1,miCeldaE2,miCeldaE3,miCeldaE4,miCeldaE5,miCeldaE6,miCeldaE7,miCeldaE8,miCeldaE9,miCeldaE10),
            arrayOf<TextView>(miCeldaF1,miCeldaF2,miCeldaF3,miCeldaF4,miCeldaF5,miCeldaF6,miCeldaF7,miCeldaF8,miCeldaF9,miCeldaF10),
            arrayOf<TextView>(miCeldaG1,miCeldaG2,miCeldaG3,miCeldaG4,miCeldaG5,miCeldaG6,miCeldaG7,miCeldaG8,miCeldaG9,miCeldaG10),
            arrayOf<TextView>(miCeldaH1,miCeldaH2,miCeldaH3,miCeldaH4,miCeldaH5,miCeldaH6,miCeldaH7,miCeldaH8,miCeldaH9,miCeldaH10),
            arrayOf<TextView>(miCeldaI1,miCeldaI2,miCeldaI3,miCeldaI4,miCeldaI5,miCeldaI6,miCeldaI7,miCeldaI8,miCeldaI9,miCeldaI10),
            arrayOf<TextView>(miCeldaJ1,miCeldaJ2,miCeldaJ3,miCeldaJ4,miCeldaJ5,miCeldaJ6,miCeldaJ7,miCeldaJ8,miCeldaJ9,miCeldaJ10)
        )

        val handler = View.OnClickListener { view ->
            if(view is TextView){
                for (i in 0 until 10) {
                    for (j in 0 until 10) {
                        if (view.id == celdasEnemigas[i][j].id) {
                            atacarCelda(PointF(i.toFloat(),j.toFloat()))
                        }
                    }
                }
            }
        }

        for (i in 0 until 10) {
            for (j in 0 until 10) {
                celdasEnemigas[i][j].setOnClickListener(handler)
            }
        }
    }


    fun toBoolean(valor : Int) : Boolean{
        //David editó esta línea.
        if(valor==1){
            return true
        }
        return false
    }
}*/