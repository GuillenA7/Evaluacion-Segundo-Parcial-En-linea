package com.example.evaluacinsegundoparcial_enlnea

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConsultarActivity : AppCompatActivity() {

    private lateinit var textViewPacientes: TextView
    private lateinit var buttonRegresarConsultar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        textViewPacientes = findViewById(R.id.textViewPacientes)
        buttonRegresarConsultar = findViewById(R.id.buttonRegresarConsultar)

        val listaPacientes = intent.getParcelableArrayListExtra<Paciente>("listaPacientes")
        val stringBuilder = StringBuilder()
        listaPacientes?.forEach { paciente ->
            stringBuilder.append("Nombre: ${paciente.nombre}\n")
            stringBuilder.append("Edad: ${paciente.edad}\n")
            stringBuilder.append("Género: ${paciente.genero}\n")
            stringBuilder.append("Tipo de Sangre: ${paciente.tipoSangre}\n")
            stringBuilder.append("---\n")
        }
        textViewPacientes.text = if (stringBuilder.isNotEmpty()) {
            stringBuilder.toString()
        } else {
            "No hay pacientes registrados"
        }

        buttonRegresarConsultar.setOnClickListener {
            finish()
        }
    }
}