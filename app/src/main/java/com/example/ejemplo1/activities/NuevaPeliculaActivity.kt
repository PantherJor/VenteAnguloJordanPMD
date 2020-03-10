package com.example.ejemplo1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo1.R
import kotlinx.android.synthetic.main.activity_list_peliculas.*

class NuevaPeliculaActivity : AppCompatActivity() {

    companion object {
        val ACCION_PELICULA = "formulario_nueva_pelicula"
        val ANHADIR_PELICULA = 0
        val EDITAR_PELICULA = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario_nueva_pelicula);

        val accion = intent.extras?.get(ACCION_PELICULA)


        if (EDITAR_PELICULA.equals(accion)){

        }





    }


}