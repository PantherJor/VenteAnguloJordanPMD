package com.example.ejemplo1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo1.R
import kotlinx.android.synthetic.main.activity_list_peliculas.*

class NuevaPeliculaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario_nueva_pelicula);


        var sharedPref = getSharedPreferences("appPelis", Context.MODE_PRIVATE)

        floatingActionButton2.setOnClickListener{
            val i3 = Intent(this, NuevaPeliculaActivity::class.java )
            startActivity(i3)
        }





    }


}