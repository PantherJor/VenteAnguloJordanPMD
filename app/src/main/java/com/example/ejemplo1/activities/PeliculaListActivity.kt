package com.example.ejemplo1.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemplo1.R
import com.example.ejemplo1.adapters.PeliculaListAdapter
import com.example.ejemplo1.bbdd.AppDatabase
import com.example.ejemplo1.entities.Pelicula
import kotlinx.android.synthetic.main.activity_list_peliculas.*
import kotlinx.android.synthetic.main.item_pelicula.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PeliculaListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_peliculas)

        GlobalScope.launch(Dispatchers.IO) {
            val peliculas =
                AppDatabase.getDatabase(this@PeliculaListActivity)?.getPeliculaDao()?.getAll()

            runOnUiThread {
                rvPeliculaList.layoutManager = LinearLayoutManager(this@PeliculaListActivity)


                var adapter = PeliculaListAdapter(peliculas.orEmpty(), this@PeliculaListActivity)

                rvPeliculaList.adapter = adapter

                //val peliculas = mockPeliculas()
                //tvPeliculaTitle.text = peliculas?.toString()
                //tvPeliculaYear.text = peliculas?.toString()
                //tvPeliculaCountry.text = peliculas?.toString()
                //tvPeliculaType.text = peliculas?.toString()
            }
        }


        //getSharedPreferences("appPelis", Context.MODE_PRIVATE)

        floatingActionButton2.setOnClickListener {
            val i3 = Intent(this, NuevaPeliculaActivity::class.java)
            startActivity(i3)
        }


        //val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.bad_boys, null)
        //val drawable1: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.joker, null)
        //val drawable2: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.panther, null)
        //val drawable3: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.mi_villano_favorito, null)
        //val drawable4: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.un_monstruo_viene_a_verme, null)


    }


    private fun mockPeliculas(): List<Pelicula> {
        return listOf(
            Pelicula("Bad Boys", "Acción/comedia", 2020, "Estados Unidos"),
            Pelicula("Joker", "Drama", 2019, "Estados Unidos"),
            Pelicula("Black Panther", "Acción", 2018, "Estados Unidos"),
            Pelicula("Mi Villano Favorito 3", "Animación/comedia", 2017, "Estados Unidos"),
            Pelicula("Un monstruo viene a verme", "Fantasía", 2016, "España")

        )
    }


}