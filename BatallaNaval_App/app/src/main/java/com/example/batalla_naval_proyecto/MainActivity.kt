package com.example.batalla_naval_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    val met = Metodos()
    var matriz : ArrayList<ArrayList<Boolean>> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cargarTablero()
    }

    private fun cargarTablero() {
        CoroutineScope(Dispatchers.IO).launch {

            var fila: Int = 0
            val call = met.getRetrofit().create(APIService::class.java).getTablero("").execute()
            val tablero = call.body() as tableroResponse
            //println("El tablero es: "+tablero)
            for(i in tablero.array){
                println("Fila $fila col1 ${i.col1} col2 ${i.col2}")
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

                //filaLista.clear()
                fila = fila+1;
            }
            println("Matriz: "+matriz)
            println("Comienza el ciclo  Tamaño filas= ${matriz.size}")
            println("Comienza el ciclo  Tamaño columnas = ${matriz[0].size}")
            for(  i in 0 until matriz.size){
                for( j in 0 until 10){
                    print("${matriz[i][j]} ")
                }
                println()
            }
        }
        /*doAsync {
            val call = met.getRetrofit().create(APIService::class.java).getTablero("$query/images").execute()
            val puppies = call.body() as tableroResponse
            uiThread {
                if(puppies.status == "success") {
                    //initCharacter(puppies)
                }else{
                    //showErrorDialog()
                }
                //hideKeyboard()
            }
        }
        */

    }

    fun toBoolean(valor : Int) : Boolean{
        if(valor==1){
            return true
        }
        return false
    }
}