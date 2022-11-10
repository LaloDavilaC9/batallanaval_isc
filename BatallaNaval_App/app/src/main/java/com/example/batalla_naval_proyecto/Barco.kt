package com.example.batalla_naval_proyecto

import android.graphics.PointF

class Barco {
    private var tam:Int
    private var celdasOcupadas:ArrayList<PointF>
    private lateinit var direccion:PointF
    private var posicionado:Boolean

    constructor(tamano:Int){
        this.tam = tamano
        celdasOcupadas = arrayListOf()
        posicionado = false
    }

    public fun ReiniciarBarco(){
        //Reiniciamos los datos del barco para volver a ser posicionado
        posicionado = false
        celdasOcupadas.clear()
        direccion = PointF()
    }

    public fun estaPosicionado():Boolean{
        return this.posicionado
    }

    public fun getCeldasOcupadas():ArrayList<PointF>{
        return this.celdasOcupadas
    }

    public fun getTamano():Int{
        return this.tam
    }

    public fun PosicionarBarco(startX: Float, startY:Float, dirX:Float, dirY:Float){
        var inicioX = startX
        var inicioY = startY
        var i = 0
        while(i < tam){
            celdasOcupadas.add(PointF(inicioX,inicioY))
            inicioX+=dirX
            inicioY+=dirY
            i++
        }
        posicionado = true
    }
}