package com.example.batalla_naval_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
            val call: Response<usuarioResponse> = met.getRetrofit().create(APIService::class.java).preguntarInfoUsuario("/preguntarPosicion")
            val info = call.body() as usuarioResponse
            if(info.array.size > 0){
                if(info.array[0].contrasena == txtContrasena.text.toString()){
                    println("Inicio correcto")
                }
                else{
                    println("Inicio INCORRECTO")
                }
            }

        }
    }
}