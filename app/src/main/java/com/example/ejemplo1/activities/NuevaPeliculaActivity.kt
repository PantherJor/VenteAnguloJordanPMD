package com.example.ejemplo1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo1.R
import com.example.ejemplo1.dao.AppDatabase
import kotlinx.android.synthetic.main.activity_list_peliculas.*
import kotlinx.android.synthetic.main.formulario_nueva_pelicula.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        GlobalScope.launch(Dispatchers.IO) {
            val p = AppDatabase.getDatabase(this@NuevaPeliculaActivity)?.getPeliculaDao()?.getAll()

            runOnUiThread() {
                editTextnewtitle.setText(p?.toString())
                editTextgenero.setText(p?.toString())
                editTextano.setText(p?.toString())
                editTextPais.setText(p?.toString())
            }
        }

        if (EDITAR_PELICULA.equals(accion)) {

        }


    }


}