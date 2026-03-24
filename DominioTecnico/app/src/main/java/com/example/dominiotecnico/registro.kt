package com.example.dominiotecnico

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class registro : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val etNombre = view.findViewById<EditText>(R.id.etNombre)
        val etCorreo = view.findViewById<EditText>(R.id.etCorreo)
        val etContra = view.findViewById<EditText>(R.id.etContra)
        val btnRegistrar = view.findViewById<Button>(R.id.btnRegistrarse)

        btnRegistrar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val correo = etCorreo.text.toString()
            val contra = etContra.text.toString()

            if (nombre.isNotEmpty() && correo.isNotEmpty() && contra.isNotEmpty()) {
                val nuevoUs = usuario(nombre, correo, contra)
                MainActivity.usuariosRegistrados.add(nuevoUs)
                Toast.makeText(requireContext(), "Usuario registrado: $nombre", Toast.LENGTH_SHORT).show()

                etNombre.text.clear()
                etCorreo.text.clear()
                etContra.text.clear()
            }
        }

        return view
    }
}