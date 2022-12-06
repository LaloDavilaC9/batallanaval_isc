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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enlazar_jugadores)

        //Esto tiene que ser enviado por parámetro de la otra actividad
        txtCorreoHost = "david@gmail.com"
        btnInvitar = findViewById(R.id.btnInvitar)
        txtCorreoInvitado = findViewById(R.id.textCorreo)
        btnInvitar.setOnClickListener {
            invitarJugador()
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

        //Mandamos llamar a atacar la celda, con el JSON que se generó arriba
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
                }
            }
        }
    }
}