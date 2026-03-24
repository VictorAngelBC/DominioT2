package com.example.dominiotecnico

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    companion object {
        val usuariosRegistrados = mutableListOf<usuario>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin = findViewById<Button>(R.id.btnIniciarSesion)
        val btnRegister = findViewById<Button>(R.id.btnRegistrarse)

        btnLogin.setOnClickListener {
            replaceFragment(iniciarsesion())
        }

        btnRegister.setOnClickListener {
            replaceFragment(registro())
        }

        // Show registration by default
        if (savedInstanceState == null) {
            replaceFragment(registro())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

data class usuario(val nombre: String, val correo: String, val contra: String)