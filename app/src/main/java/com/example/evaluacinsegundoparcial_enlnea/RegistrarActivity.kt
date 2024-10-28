package com.example.evaluacinsegundoparcial_enlnea

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegistrarActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextEdad: EditText
    private lateinit var toggleButtonGenero: ToggleButton
    private lateinit var spinnerTipoSangre: Spinner
    private lateinit var buttonRegistrar: Button
    private lateinit var buttonLimpiar: Button
    private lateinit var buttonRegresar: Button
    private val listaPacientes = ArrayList<Paciente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        // Inicializar vistas
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextEdad = findViewById(R.id.editTextEdad)
        toggleButtonGenero = findViewById(R.id.toggleButtonGenero)
        spinnerTipoSangre = findViewById(R.id.spinnerTipoSangre)
        buttonRegistrar = findViewById(R.id.buttonRegistrar)
        buttonLimpiar = findViewById(R.id.buttonLimpiar)
        buttonRegresar = findViewById(R.id.buttonRegresar)

        // Recibir lista de pacientes actual
        intent.getParcelableArrayListExtra<Paciente>("listaPacientes")?.let {
            listaPacientes.addAll(it)
        }

        // Configuración del Spinner de tipo de sangre
        val tiposSangre = arrayOf("A", "B", "AB", "O")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposSangre)
        spinnerTipoSangre.adapter = adapter

        // Configurar botón Registrar
        buttonRegistrar.setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val edad = editTextEdad.text.toString().toIntOrNull()
            val genero = if (toggleButtonGenero.isChecked) "Masculino" else "Femenino"
            val tipoSangre = spinnerTipoSangre.selectedItem.toString()

            if (nombre.isNotEmpty() && edad != null) {
                val paciente = Paciente(nombre, edad, genero, tipoSangre)
                listaPacientes.add(paciente)
                Toast.makeText(this, "Paciente registrado", Toast.LENGTH_SHORT).show()
                limpiarCampos()
            } else {
                Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar botón Limpiar
        buttonLimpiar.setOnClickListener { limpiarCampos() }

        // Configurar botón Regresar
        buttonRegresar.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putParcelableArrayListExtra("listaPacientes", listaPacientes)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun limpiarCampos() {
        editTextNombre.text.clear()
        editTextEdad.text.clear()
        toggleButtonGenero.isChecked = false
        spinnerTipoSangre.setSelection(0)
    }
}