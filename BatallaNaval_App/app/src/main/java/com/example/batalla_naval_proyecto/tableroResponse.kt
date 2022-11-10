package com.example.batalla_naval_proyecto
import com.google.gson.annotations.SerializedName
data class objeto(

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


data class tableroResponse (@SerializedName("array") var array:List<objeto>, @SerializedName("success") var success: String)