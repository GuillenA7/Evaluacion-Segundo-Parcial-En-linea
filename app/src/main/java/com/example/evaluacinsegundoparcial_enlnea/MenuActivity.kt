package com.example.evaluacinsegundoparcial_enlnea

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MenuActivity : AppCompatActivity() {

    private val REQUEST_CODE_REGISTRAR = 1
    private val listaPacientes = ArrayList<Paciente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_registrar -> {
                val intent = Intent(this, RegistrarActivity::class.java)
                intent.putParcelableArrayListExtra("listaPacientes", listaPacientes)
                startActivityForResult(intent, REQUEST_CODE_REGISTRAR)
                true
            }
            R.id.action_consultar -> {
                val intent = Intent(this, ConsultarActivity::class.java)
                intent.putParcelableArrayListExtra("listaPacientes", listaPacientes)
                startActivity(intent)
                true
            }
            R.id.action_salir -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_REGISTRAR && resultCode == Activity.RESULT_OK) {
            data?.getParcelableArrayListExtra<Paciente>("listaPacientes")?.let {
                listaPacientes.clear()
                listaPacientes.addAll(it)
            }
        }
    }
}