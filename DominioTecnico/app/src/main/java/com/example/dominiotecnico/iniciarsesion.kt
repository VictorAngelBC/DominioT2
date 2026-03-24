package com.example.dominiotecnico

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class iniciarsesion : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragmento_login, container, false)

        val etCorreo = view.findViewById<EditText>(R.id.etCorreoIn)
        val etContra = view.findViewById<EditText>(R.id.etContraIn)
        val btnIniciar = view.findViewById<Button>(R.id.btnIniciar)

        btnIniciar.setOnClickListener {
            val correo = etCorreo.text.toString()
            val contra = etContra.text.toString()

            val usuario = MainActivity.usuariosRegistrados.find { it.correo == correo && it.contra == contra }

            if (usuario != null) {
                val intent = Intent(requireContext(), bienvenida::class.java)
                intent.putExtra("USER_NAME", usuario.nombre)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Algun dato tuyo esta incorrecto", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}