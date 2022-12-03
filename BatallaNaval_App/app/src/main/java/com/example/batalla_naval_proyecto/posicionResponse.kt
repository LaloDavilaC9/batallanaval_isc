package com.example.batalla_naval_proyecto
import com.google.gson.annotations.SerializedName
/*data class objeto(

    var indice: Int,
    var col1 : Int,
    var col2 : Int,
    var col3 : Int,
    var col4 : Int,
    var col5 : Int,
    var col6 : Int,
    var col7 : Int,
    var col8 : Int,
    var col9 : Int,
    var col10 : Int,
    )


data class tableroResponse (@SerializedName("array") var array:List<objeto>, @SerializedName("success") var success: String)*/

data class posicionObject(

    var numero_jugada : Int,
    var turno_jugada : Int,
    var pos_x : Int,
    var pos_y : Int
)

data class certezaObject(
    var indice : Int,
    var no_jugada : Int,
    var ataqueCertero : Int
)


data class posicionResponse (@SerializedName("array") var array:List<posicionObject>, @SerializedName("success") var success: String)

data class certezaResponse (@SerializedName("array") var array:List<certezaObject>, @SerializedName("success") var success: String)

