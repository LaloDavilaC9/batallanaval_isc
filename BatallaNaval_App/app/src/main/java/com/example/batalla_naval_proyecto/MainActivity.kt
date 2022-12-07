package com.example.batalla_naval_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val met = Metodos()
    private lateinit var jvj : Button
    private lateinit var ia : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jvj = findViewById(R.id.btnJvj)
        ia = findViewById(R.id.btnIa)

        jvj.setOnClickListener {
            val intent = Intent(applicationContext, InicioSesion::class.java)
            startActivity(intent)
        }
        ia.setOnClickListener{
            val intent = Intent(applicationContext, InicioSesion::class.java)
            startActivity(intent)
        }


    }





}