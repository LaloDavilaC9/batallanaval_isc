package com.example.batalla_naval_proyecto

import android.content.Intent
import android.graphics.Color
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class colocar_barcos : AppCompatActivity() {
    private var celdas = arrayOf<Array<TextView>>()
    private var barcos = arrayOf<Barco>()
    private var celdasOcupadas: Array<BooleanArray> = Array(10){BooleanArray(10)}
    private var direccActual: PointF = PointF(0f,1f)

    private var indexBarcoActual:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colocar_barcos)

        var botonIniciar = findViewById(R.id.botonConfirmar) as TextView

        var celdaA1 = findViewById(R.id.bttnCelda_A_1) as TextView
        var celdaA2 = findViewById(R.id.bttnCelda_A_2) as TextView
        var celdaA3 = findViewById(R.id.bttnCelda_A_3) as TextView
        var celdaA4 = findViewById(R.id.bttnCelda_A_4) as TextView
        var celdaA5 = findViewById(R.id.bttnCelda_A_5) as TextView
        var celdaA6 = findViewById(R.id.bttnCelda_A_6) as TextView
        var celdaA7 = findViewById(R.id.bttnCelda_A_7) as TextView
        var celdaA8 = findViewById(R.id.bttnCelda_A_8) as TextView
        var celdaA9 = findViewById(R.id.bttnCelda_A_9) as TextView
        var celdaA10 = findViewById(R.id.bttnCelda_A_10) as TextView

        var celdaB1 = findViewById(R.id.bttnCelda_B_1) as TextView
        var celdaB2 = findViewById(R.id.bttnCelda_B_2) as TextView
        var celdaB3 = findViewById(R.id.bttnCelda_B_3) as TextView
        var celdaB4 = findViewById(R.id.bttnCelda_B_4) as TextView
        var celdaB5 = findViewById(R.id.bttnCelda_B_5) as TextView
        var celdaB6 = findViewById(R.id.bttnCelda_B_6) as TextView
        var celdaB7 = findViewById(R.id.bttnCelda_B_7) as TextView
        var celdaB8 = findViewById(R.id.bttnCelda_B_8) as TextView
        var celdaB9 = findViewById(R.id.bttnCelda_B_9) as TextView
        var celdaB10 = findViewById(R.id.bttnCelda_B_10) as TextView

        var celdaC1 = findViewById(R.id.bttnCelda_C_1) as TextView
        var celdaC2 = findViewById(R.id.bttnCelda_C_2) as TextView
        var celdaC3 = findViewById(R.id.bttnCelda_C_3) as TextView
        var celdaC4 = findViewById(R.id.bttnCelda_C_4) as TextView
        var celdaC5 = findViewById(R.id.bttnCelda_C_5) as TextView
        var celdaC6 = findViewById(R.id.bttnCelda_C_6) as TextView
        var celdaC7 = findViewById(R.id.bttnCelda_C_7) as TextView
        var celdaC8 = findViewById(R.id.bttnCelda_C_8) as TextView
        var celdaC9 = findViewById(R.id.bttnCelda_C_9) as TextView
        var celdaC10 = findViewById(R.id.bttnCelda_C_10) as TextView

        var celdaD1 = findViewById(R.id.bttnCelda_D_1) as TextView
        var celdaD2 = findViewById(R.id.bttnCelda_D_2) as TextView
        var celdaD3 = findViewById(R.id.bttnCelda_D_3) as TextView
        var celdaD4 = findViewById(R.id.bttnCelda_D_4) as TextView
        var celdaD5 = findViewById(R.id.bttnCelda_D_5) as TextView
        var celdaD6 = findViewById(R.id.bttnCelda_D_6) as TextView
        var celdaD7 = findViewById(R.id.bttnCelda_D_7) as TextView
        var celdaD8 = findViewById(R.id.bttnCelda_D_8) as TextView
        var celdaD9 = findViewById(R.id.bttnCelda_D_9) as TextView
        var celdaD10 = findViewById(R.id.bttnCelda_D_10) as TextView

        var celdaE1 = findViewById(R.id.bttnCelda_E_1) as TextView
        var celdaE2 = findViewById(R.id.bttnCelda_E_2) as TextView
        var celdaE3 = findViewById(R.id.bttnCelda_E_3) as TextView
        var celdaE4 = findViewById(R.id.bttnCelda_E_4) as TextView
        var celdaE5 = findViewById(R.id.bttnCelda_E_5) as TextView
        var celdaE6 = findViewById(R.id.bttnCelda_E_6) as TextView
        var celdaE7 = findViewById(R.id.bttnCelda_E_7) as TextView
        var celdaE8 = findViewById(R.id.bttnCelda_E_8) as TextView
        var celdaE9 = findViewById(R.id.bttnCelda_E_9) as TextView
        var celdaE10 = findViewById(R.id.bttnCelda_E_10) as TextView

        var celdaF1 = findViewById(R.id.bttnCelda_F_1) as TextView
        var celdaF2 = findViewById(R.id.bttnCelda_F_2) as TextView
        var celdaF3 = findViewById(R.id.bttnCelda_F_3) as TextView
        var celdaF4 = findViewById(R.id.bttnCelda_F_4) as TextView
        var celdaF5 = findViewById(R.id.bttnCelda_F_5) as TextView
        var celdaF6 = findViewById(R.id.bttnCelda_F_6) as TextView
        var celdaF7 = findViewById(R.id.bttnCelda_F_7) as TextView
        var celdaF8 = findViewById(R.id.bttnCelda_F_8) as TextView
        var celdaF9 = findViewById(R.id.bttnCelda_F_9) as TextView
        var celdaF10 = findViewById(R.id.bttnCelda_F_10) as TextView

        var celdaG1 = findViewById(R.id.bttnCelda_G_1) as TextView
        var celdaG2 = findViewById(R.id.bttnCelda_G_2) as TextView
        var celdaG3 = findViewById(R.id.bttnCelda_G_3) as TextView
        var celdaG4 = findViewById(R.id.bttnCelda_G_4) as TextView
        var celdaG5 = findViewById(R.id.bttnCelda_G_5) as TextView
        var celdaG6 = findViewById(R.id.bttnCelda_G_6) as TextView
        var celdaG7 = findViewById(R.id.bttnCelda_G_7) as TextView
        var celdaG8 = findViewById(R.id.bttnCelda_G_8) as TextView
        var celdaG9 = findViewById(R.id.bttnCelda_G_9) as TextView
        var celdaG10 = findViewById(R.id.bttnCelda_G_10) as TextView

        var celdaH1 = findViewById(R.id.bttnCelda_H_1) as TextView
        var celdaH2 = findViewById(R.id.bttnCelda_H_2) as TextView
        var celdaH3 = findViewById(R.id.bttnCelda_H_3) as TextView
        var celdaH4 = findViewById(R.id.bttnCelda_H_4) as TextView
        var celdaH5 = findViewById(R.id.bttnCelda_H_5) as TextView
        var celdaH6 = findViewById(R.id.bttnCelda_H_6) as TextView
        var celdaH7 = findViewById(R.id.bttnCelda_H_7) as TextView
        var celdaH8 = findViewById(R.id.bttnCelda_H_8) as TextView
        var celdaH9 = findViewById(R.id.bttnCelda_H_9) as TextView
        var celdaH10 = findViewById(R.id.bttnCelda_H_10) as TextView

        var celdaI1 = findViewById(R.id.bttnCelda_I_1) as TextView
        var celdaI2 = findViewById(R.id.bttnCelda_I_2) as TextView
        var celdaI3 = findViewById(R.id.bttnCelda_I_3) as TextView
        var celdaI4 = findViewById(R.id.bttnCelda_I_4) as TextView
        var celdaI5 = findViewById(R.id.bttnCelda_I_5) as TextView
        var celdaI6 = findViewById(R.id.bttnCelda_I_6) as TextView
        var celdaI7 = findViewById(R.id.bttnCelda_I_7) as TextView
        var celdaI8 = findViewById(R.id.bttnCelda_I_8) as TextView
        var celdaI9 = findViewById(R.id.bttnCelda_I_9) as TextView
        var celdaI10 = findViewById(R.id.bttnCelda_I_10) as TextView

        var celdaJ1 = findViewById(R.id.bttnCelda_J_1) as TextView
        var celdaJ2 = findViewById(R.id.bttnCelda_J_2) as TextView
        var celdaJ3 = findViewById(R.id.bttnCelda_J_3) as TextView
        var celdaJ4 = findViewById(R.id.bttnCelda_J_4) as TextView
        var celdaJ5 = findViewById(R.id.bttnCelda_J_5) as TextView
        var celdaJ6 = findViewById(R.id.bttnCelda_J_6) as TextView
        var celdaJ7 = findViewById(R.id.bttnCelda_J_7) as TextView
        var celdaJ8 = findViewById(R.id.bttnCelda_J_8) as TextView
        var celdaJ9 = findViewById(R.id.bttnCelda_J_9) as TextView
        var celdaJ10 = findViewById(R.id.bttnCelda_J_10) as TextView

        var direccHorizontal = findViewById(R.id.botonHorizontal) as RadioButton
        var direccVertical = findViewById(R.id.botonVertical) as RadioButton

        var selecBarco0 = findViewById(R.id.barco0) as RadioButton
        var selecBarco1 = findViewById(R.id.barco1) as RadioButton
        var selecBarco2 = findViewById(R.id.barco2) as RadioButton
        var selecBarco3 = findViewById(R.id.barco3) as RadioButton
        var selecBarco4 = findViewById(R.id.barco4) as RadioButton

        celdas = arrayOf<Array<TextView>>(
            arrayOf<TextView>(celdaA1,celdaA2,celdaA3,celdaA4,celdaA5,celdaA6,celdaA7,celdaA8,celdaA9,celdaA10),
            arrayOf<TextView>(celdaB1,celdaB2,celdaB3,celdaB4,celdaB5,celdaB6,celdaB7,celdaB8,celdaB9,celdaB10),
            arrayOf<TextView>(celdaC1,celdaC2,celdaC3,celdaC4,celdaC5,celdaC6,celdaC7,celdaC8,celdaC9,celdaC10),
            arrayOf<TextView>(celdaD1,celdaD2,celdaD3,celdaD4,celdaD5,celdaD6,celdaD7,celdaD8,celdaD9,celdaD10),
            arrayOf<TextView>(celdaE1,celdaE2,celdaE3,celdaE4,celdaE5,celdaE6,celdaE7,celdaE8,celdaE9,celdaE10),
            arrayOf<TextView>(celdaF1,celdaF2,celdaF3,celdaF4,celdaF5,celdaF6,celdaF7,celdaF8,celdaF9,celdaF10),
            arrayOf<TextView>(celdaG1,celdaG2,celdaG3,celdaG4,celdaG5,celdaG6,celdaG7,celdaG8,celdaG9,celdaG10),
            arrayOf<TextView>(celdaH1,celdaH2,celdaH3,celdaH4,celdaH5,celdaH6,celdaH7,celdaH8,celdaH9,celdaH10),
            arrayOf<TextView>(celdaI1,celdaI2,celdaI3,celdaI4,celdaI5,celdaI6,celdaI7,celdaI8,celdaI9,celdaI10),
            arrayOf<TextView>(celdaJ1,celdaJ2,celdaJ3,celdaJ4,celdaJ5,celdaJ6,celdaJ7,celdaJ8,celdaJ9,celdaJ10)
        )

        val handler = View.OnClickListener { view ->
            if(view is TextView){
                var coord = PointF()
                for (i in 0 until 10) {
                    for (j in 0 until 10) {
                        if (view.id == celdas[i][j].id) {
                            //Toast.makeText(this,"Celda: "+i+","+j,Toast.LENGTH_SHORT).show()
                            //Las direcciones son variables de clase que se asignan dependiendo al radio button de direccion seleccionado.
                            IntentarColocarBarco(direccActual.x.toInt(),direccActual.y.toInt(),indexBarcoActual,i,j)

                        }
                    }
                }
            }
        }

        botonIniciar.setOnClickListener{
            for(barco in barcos){
                if(!barco.estaPosicionado()) return@setOnClickListener
            }

            val intent = Intent(this, Ingame_boards::class.java)
            intent.putExtra("misCeldas",celdasOcupadas)
            startActivity(intent)

        }

        val handlerDireccionesYSelector = View.OnClickListener{ view->
            if(view is RadioButton){
                when(view.id){
                    R.id.botonHorizontal -> direccActual = PointF(0f,1f)
                    R.id.botonVertical ->  direccActual = PointF(-1f,0f)
                    R.id.barco0 -> indexBarcoActual = 0
                    R.id.barco1 -> indexBarcoActual = 1
                    R.id.barco2 -> indexBarcoActual = 2
                    R.id.barco3 -> indexBarcoActual = 3
                    R.id.barco4 -> indexBarcoActual = 4
                }
            }
        }


        direccHorizontal.setOnClickListener(handlerDireccionesYSelector)
        direccVertical.setOnClickListener(handlerDireccionesYSelector)
        selecBarco0.setOnClickListener(handlerDireccionesYSelector)
        selecBarco1.setOnClickListener(handlerDireccionesYSelector)
        selecBarco2.setOnClickListener(handlerDireccionesYSelector)
        selecBarco3.setOnClickListener(handlerDireccionesYSelector)
        selecBarco4.setOnClickListener(handlerDireccionesYSelector)

        for (i in 0 until 10) {
            for (j in 0 until 10) {
                celdas[i][j].setOnClickListener(handler)
            }
        }

        //Inicializar vector de barcos
        barcos = arrayOf(Barco(5), Barco(4),Barco(3),Barco(3),Barco(1))

    }

    private fun IntentarColocarBarco(direcX:Int,direcY:Int,indexBarco:Int,i:Int,j:Int){
        if(celdasOcupadas[i][j] == true){
            return
        }
        if(barcos[indexBarco].estaPosicionado()){
            //Resetear el barco en el tablero y borrar posiciones.
            println("Barco RESETEADO")
            for(i in barcos[indexBarco].getCeldasOcupadas()){
                println("Celda: ("+i.x+","+i.y+") cambiada")
                celdas[i.x.toInt()][i.y.toInt()].setBackgroundColor(Color.parseColor("#00000000"))
                celdasOcupadas[i.x.toInt()][i.y.toInt()] = false
            }
            barcos[indexBarco].ReiniciarBarco()

        }

        //DFS para intentar colocar barco con posicion
        if(Dfs(direcX,direcY,indexBarco,i,j)){
            var n = 0
            barcos[indexBarco].PosicionarBarco(i.toFloat(),j.toFloat(),direcX.toFloat(),direcY.toFloat())
            OcuparCeldas(i.toFloat(),j.toFloat(),direcX.toFloat(),direcY.toFloat(),barcos[indexBarco].getTamano())
            Toast.makeText(this,"Barco Posicionado", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Celda No Permitida", Toast.LENGTH_SHORT).show()
        }
        //Si se puede, colorear nuevas celdas al mismo tiempo que se añaden a las posiciones del barco
    }

    private fun OcuparCeldas(startX: Float, startY:Float, dirX:Float, dirY:Float, tam:Int){
        var inicioX = startX
        var inicioY = startY
        var i = 0
        while(i < tam){
            celdasOcupadas[inicioX.toInt()][inicioY.toInt()] = true
            celdas[inicioX.toInt()][inicioY.toInt()].setBackgroundColor(Color.BLACK)
            inicioX+=dirX
            inicioY+=dirY
            i++
        }
    }

    private fun Dfs(direcX:Int,direcY:Int,indexBarco:Int,i:Int,j:Int):Boolean{
        var inicioX = i
        var inicioY = j
        var n = 0
        var tamano = barcos[indexBarco].getTamano()
        var direcciones = arrayOf(PointF(1f,0f), PointF(0f,1f), PointF(-1f,0f), PointF(0f,-1f))
        while(n < tamano){
            //Si el barco está fuera de limites, return false.
            if(inicioX >= 10 || inicioX < 0 || inicioY >= 10 || inicioY <0 ) return false
            //Revisar periferia de la celda
            for (dir in direcciones){
                var nuevoX = inicioX + dir.x
                var nuevoY = inicioY + dir.y
                if(nuevoX >= 10 || nuevoX < 0 || nuevoY >= 10 || nuevoY < 0) continue
                if(celdasOcupadas[nuevoX.toInt()][nuevoY.toInt()] == true) return false
            }
            inicioX += direcX
            inicioY += direcY
            n++
        }
        //Si el barco está dentro de límites, return true.
        return true
    }

}