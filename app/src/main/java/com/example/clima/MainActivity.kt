package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject

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

        val ciudad_id = intent.getStringExtra("com.example.clima.ciudades.CIUDAD")
        Toast.makeText(this, ciudad_id, Toast.LENGTH_SHORT).show()
//        val cdmx = Ciudad("Ciudad de México", 15, "Soleado") //3530597
//        val liverpool = Ciudad("Liverpool", 10, "Nublado") //2644210
        if (Network.hayRed(this)){
            solicitudHttpVolley("https://api.openweathermap.org/data/2.5/weather?id="+ciudad_id+"&appid=298bc281b4e7a53d642d065b5d8f3fe7")
        }else{
            Toast.makeText(this,"No hay conexión a internet",Toast.LENGTH_SHORT).show()
        }

    }

    /*Metodo para volley*/
    private  fun solicitudHttpVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
                response ->
            try{
                val json = JSONObject(response)
                val ciudad:Ciudad = Gson().fromJson(response.toString(),Ciudad::class.java)
                tvCiudad?.text = ciudad.name
                tvGrados?.text = String.format("%.2f",ciudad.main?.temp_centigrados()).toString()+"°C"
                tvEstatus?.text = ciudad.weather?.get(0)?.main
                Log.d("http volley",ciudad.name)

            }catch (e: Exception){
                Log.d("error",e.toString())
            }

        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }

}