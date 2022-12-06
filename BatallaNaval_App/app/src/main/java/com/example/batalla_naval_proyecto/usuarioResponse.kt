package com.example.batalla_naval_proyecto

import com.google.gson.annotations.SerializedName

data class usuarioObject(

    var id_jugador : Int,
    var nombre : String,
    var correo : String,
    var password : String
)


data class usuarioResponse (@SerializedName("array") var array:List<usuarioObject>, @SerializedName("success") var success: String)
data class invitacionResponse(@SerializedName("array") var array:List<usuarioObject>, @SerializedName("success") var success: String)