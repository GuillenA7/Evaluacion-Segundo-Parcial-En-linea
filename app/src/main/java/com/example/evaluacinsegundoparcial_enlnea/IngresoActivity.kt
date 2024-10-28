package com.example.evaluacinsegundoparcial_enlnea

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IngresoActivity : AppCompatActivity() {

    private lateinit var spinnerUsuarios: Spinner
    private lateinit var editTextPassword: EditText
    private lateinit var buttonIngresar: Button
    private lateinit var buttonLimpiar: Button
    private val passwordCorrecta = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        // Inicializar vistas
        spinnerUsuarios = findViewById(R.id.spinnerUsuarios)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonIngresar = findViewById(R.id.buttonIngresar)
        buttonLimpiar = findViewById(R.id.buttonLimpiar)

        // Lista de usuarios para el Spinner
        val usuarios = arrayOf("Usuario1", "Usuario2", "Usuario3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, usuarios)
        spinnerUsuarios.adapter = adapter

        // Configurar el botón Ingresar
        buttonIngresar.setOnClickListener {
            val password = editTextPassword.text.toString()
            if (password == passwordCorrecta) {
                // Contraseña correcta, navegar al menú
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                // Contraseña incorrecta, mostrar mensaje de error
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el botón Limpiar
        buttonLimpiar.setOnClickListener {
            editTextPassword.text.clear()
        }
    }
}