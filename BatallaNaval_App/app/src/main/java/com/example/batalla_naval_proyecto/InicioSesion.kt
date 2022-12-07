package com.example.batalla_naval_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class InicioSesion : AppCompatActivity() {
    private val met = Metodos()
    private lateinit var btnIniciar : Button
    private lateinit var txtCorreo : EditText
    private lateinit var txtContrasena : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        btnIniciar = findViewById(R.id.btnIniciar)
        txtCorreo = findViewById(R.id.correo)
        txtContrasena = findViewById(R.id.contrasena)
        btnIniciar.setOnClickListener {
            verificarSesion()
        }

    }

    fun verificarSesion(){

        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<usuarioResponse> = met.getRetrofit().create(APIService::class.java).preguntarInfoUsuario("/jugador/${txtCorreo.text.toString()}")
            val info = call.body() as usuarioResponse
            if(info.array.size > 0){
                println("Compara ${info.array[0].password} VS ${txtContrasena.text.toString()}")
                if(info.array[0].password == txtContrasena.text.toString()){
                    println("Inicio correcto")

                    val intent = Intent(applicationContext, EnlazarJugadores::class.java)
                    intent.putExtra("correoHost",txtCorreo.text.toString())
                    startActivity(intent)

                }
                else{
                    println("Inicio INCORRECTO")
                }
            }
        }
    }
}