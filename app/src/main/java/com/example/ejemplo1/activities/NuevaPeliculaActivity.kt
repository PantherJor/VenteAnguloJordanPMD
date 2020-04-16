package com.example.ejemplo1.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejemplo1.R
import com.example.ejemplo1.bbdd.AppDatabase
import com.example.ejemplo1.entities.Pelicula
import kotlinx.android.synthetic.main.formulario_nueva_pelicula.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NuevaPeliculaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.formulario_nueva_pelicula)

        GlobalScope.launch(Dispatchers.IO) {
            val p = AppDatabase.getDatabase(this@NuevaPeliculaActivity)?.getPeliculaDao()
                ?.findByid(id = 1)

            editTextnewtitle.setText(p?.title)
            editTextgenero.setText(p?.type)
            editTextano.setText(p?.year.toString())
            editTextPais.setText(p?.country)
        }


        btnGuardardatos.setOnClickListener {
            //construir el objeto Pelicula
            val title = editTextnewtitle.text.toString()
            val type = editTextgenero.text.toString()
            val year = editTextano.text.toString().toInt()
            val country = editTextPais.text.toString()


            val p2 = Pelicula(title, type, year, country)

            Log.d("NuevaPeliculaActivity", p2.toString())
            GlobalScope.launch(Dispatchers.IO) {
                val peliculaDao =
                    AppDatabase.getDatabase(this@NuevaPeliculaActivity)?.getPeliculaDao()
                peliculaDao?.update(p2)

                runOnUiThread {
                    Toast.makeText(
                        this@NuevaPeliculaActivity,
                        "La pelicula" + p2.title + "ha sido añadida correctamente",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

        btnAnadir.setOnClickListener {
            val i = Intent(this@NuevaPeliculaActivity, PeliculaListActivity::class.java)
            startActivity(i)

        }


    }


}