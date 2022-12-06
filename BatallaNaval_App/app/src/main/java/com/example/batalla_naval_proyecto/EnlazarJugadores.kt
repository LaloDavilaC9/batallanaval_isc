package com.example.batalla_naval_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Response

class EnlazarJugadores : AppCompatActivity() {
    private val met = Metodos()

    private lateinit var btnInvitar : Button
    private lateinit var txtCorreoInvitado : EditText
    private lateinit var txtCorreoHost : String
    private  var controlEscuchar : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enlazar_jugadores)

        //Esto tiene que ser enviado por parámetro de la otra actividad
        txtCorreoHost = "david@gmail.com"
        txtCorreoHost = "adrian@gmail.com"
        btnInvitar = findViewById(R.id.btnInvitar)
        txtCorreoInvitado = findViewById(R.id.textCorreo)
        escucharInvitacion()
        btnInvitar.setOnClickListener {
            invitarJugador()
        }

    }

    //Está a la espera de que reciba una invitación a jugar
    fun escucharInvitacion(){
        var bandera = 0
        CoroutineScope(Dispatchers.IO).launch {
            //withContext(Dispatchers.Main) {

            while (bandera == 0 && controlEscuchar) {
                println("ESPERANDO INVITACIÓN DE ALGUIEN")
                val call: Response<invitacionResponse> = met.getRetrofit().create(APIService::class.java).preguntarInvitacion("/invitaciones/${txtCorreoHost}")
                val invitacion = call.body() as invitacionResponse
                if(invitacion.array.size>0){
                    println("ME ESTÁ INVITANDO A JUGAR ${invitacion.array[0].invita}")
                    //Invitación se acepta por default
                    val jsonObject = JSONObject()
                    jsonObject.put("invitado", txtCorreoHost)
                    jsonObject.put("invita", invitacion.array[0].invita)
                    jsonObject.put("enlazado", 1)

                    //Se convierte el objeto Json a String
                    var jsonString = jsonObject.toString()

                    val requestBody = jsonString.toRequestBody("application/json".toMediaTypeOrNull())
                    val retrofit = met.getRetrofit()
                    print("El json: "+jsonString)

                    val service = retrofit.create(APIService::class.java)

                    CoroutineScope(Dispatchers.IO).launch {

                        val response = service.confirmarInvitacion(requestBody)
                        //El siguiente IF controla si se pudo conectar a la API o no
                        if (response.isSuccessful) {
                            // Convert raw JSON to pretty JSON using GSON library
                            val gson = GsonBuilder().setPrettyPrinting().create()
                            val prettyJson = gson.toJson(
                                JsonParser.parseString(
                                    response.body()?.string()
                                )
                            )
                            Log.d("Pretty Printed JSON :", prettyJson)
                            println("Invitación confirmada")
                            bandera = 1
                        }
                    }
                }
                //println("turnoNuevo = ${turnoNuevo} vs turnoJugada = ${turnoJugada}")
                Thread.sleep(2000)
            }
            println("Dejó de recibir invitaciones")
        }
    }
    fun invitarJugador(){
        val jsonObject = JSONObject()
        jsonObject.put("invita", this.txtCorreoHost)
        jsonObject.put("invitado", this.txtCorreoInvitado.text.toString())
        jsonObject.put("enlazado", 0)

        //Se convierte el objeto Json a String
        var jsonString = jsonObject.toString()

        val requestBody = jsonString.toRequestBody("application/json".toMediaTypeOrNull())
        val retrofit = met.getRetrofit()


        val service = retrofit.create(APIService::class.java)

        //Se manda la invitación
        CoroutineScope(Dispatchers.IO).launch {

            val response = service.invitarJugador(requestBody)
            withContext(Dispatchers.Main) {
                //El siguiente IF controla si se pudo conectar a la API o no
                if (response.isSuccessful) {
                    // Convert raw JSON to pretty JSON using GSON library
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val prettyJson = gson.toJson(
                        JsonParser.parseString(
                            response.body()?.string()
                        )
                    )
                    Log.d("Pretty Printed JSON :", prettyJson)

                    //Ahora tiene que esperar a que se acepte o rechaze la invitación
                    CoroutineScope(Dispatchers.IO).launch {
                        //withContext(Dispatchers.Main) {
                        var respuesta = 0
                        while (respuesta == 0) {
                            println("ESPERANDO A QUE SE ACEPTE O SE RECHAZE LA INVITACIÓN")
                            // println("${txtCorreoHost} a ${txtCorreoInvitado}")
                            val call: Response<invitacionResponse> = met.getRetrofit().create(APIService::class.java).preguntarConfirmacion("/invitacion/${txtCorreoInvitado.text.toString()}/${txtCorreoHost}")
                            val invitacion = call.body() as invitacionResponse
                            if(invitacion.array.size > 0){
                                respuesta = invitacion.array[0].enlazado
                            }
                            Thread.sleep(2000)

                        }

                        if(respuesta == 1){
                            //ACEPTÓ LA INVITACIÓN
                            println("La invitación fue aceptada")
                            controlEscuchar = false
                        }
                        else{
                            //Rechazó la invitación
                            println("La invitación fue rechazada")
                        }

                    }
                }
            }
        }
    }
}