package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //componentes
    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.example.clima.ciudades.CIUDAD")
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()
        val cdmx = Ciudad("Ciudad de México", 15, "Soleado")
        val liverpool = Ciudad("Liverpool", 10, "Nublado")
        if(ciudad == "mexico"){
            tvCiudad?.text = cdmx.nombre
            tvGrados?.text = cdmx.grados.toString()+"°C"
            tvEstatus?.text = cdmx.estatus
        }
        else if (ciudad == "liverpool"){
            tvCiudad?.text = liverpool.nombre
            tvGrados?.text = liverpool.grados.toString()+"°C"
            tvEstatus?.text = liverpool.estatus
        }
        else{
            Toast.makeText(this, "No se encuentra la información", Toast.LENGTH_SHORT).show()

        }
    }
}