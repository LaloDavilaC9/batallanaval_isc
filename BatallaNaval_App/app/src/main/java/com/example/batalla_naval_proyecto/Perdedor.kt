package com.example.batalla_naval_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Perdedor : AppCompatActivity() {
    private lateinit var regresar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perdedor)

        regresar = findViewById(R.id.btnR)

        regresar.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}