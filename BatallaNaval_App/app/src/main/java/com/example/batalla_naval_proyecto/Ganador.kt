package com.example.batalla_naval_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ganador : AppCompatActivity() {
    private lateinit var btnRegresar : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganador)
        btnRegresar = findViewById(R.id.botton)

        btnRegresar.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}