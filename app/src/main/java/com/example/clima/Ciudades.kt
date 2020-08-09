package com.example.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {
    val TAG = "com.example.clima.ciudades.CIUDAD"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bMexico = findViewById<Button>(R.id.btnMexico)
        val bLiverpool = findViewById<Button>(R.id.btnLiverpool)

        bMexico.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this,"Ciudad de México", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(TAG,"mexico")
            startActivity(intent)
        })

        bLiverpool.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this, "Ciudad de Liverpool", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG,"liverpool")
            startActivity(intent)
        })
    }
}