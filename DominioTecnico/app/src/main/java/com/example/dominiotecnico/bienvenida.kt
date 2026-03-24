package com.example.dominiotecnico

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bienvenida)

        val nombreUs = intent.getStringExtra("USER_NAME")
        val bienvenido = findViewById<TextView>(R.id.textViewhola)
        
        bienvenido.text = "bienvenido: ${nombreUs}"
    }
}