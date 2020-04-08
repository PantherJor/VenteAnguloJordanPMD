package com.example.ejemplo1.activities

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejemplo1.R
import com.example.ejemplo1.adapters.PeliculaListAdapter
import com.example.ejemplo1.entities.Pelicula
import kotlinx.android.synthetic.main.activity_list_peliculas.*


class PeliculaListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_peliculas)
            rvPeliculaList.layoutManager = LinearLayoutManager(this)

        val peliculas = mockPeliculas()

        var adapter = PeliculaListAdapter(peliculas, this)

        var sharedPref = getSharedPreferences("appPelis", Context.MODE_PRIVATE)

        floatingActionButton2.setOnClickListener{
            val i3 = Intent(this, NuevaPeliculaActivity::class.java )
            startActivity(i3)
        }


        rvPeliculaList.adapter = adapter


        val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.bad_boys, null)
        val drawable1: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.joker, null)
        val drawable2: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.panther, null)
        val drawable3: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.mi_villano_favorito, null)
        val drawable4: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.un_monstruo_viene_a_verme, null)


    }


    private fun mockPeliculas(): List<Pelicula> {
        return listOf(
            Pelicula("Bad Boys", "Acción/comedia", 2020, "Estados Unidos", imagen = getDrawable(R.drawable.bad_boys) ),
            Pelicula("Joker", "Drama", 2019, "Estados Unidos", imagen = getDrawable(R.drawable.joker)),
            Pelicula("Black Panther", "Acción", 2018, "Estados Unidos", imagen = getDrawable(R.drawable.panther)),
            Pelicula("Mi Villano Favorito 3", "Animación/comedia", 2017, "Estados Unidos", imagen = getDrawable(R.drawable.mi_villano_favorito)),
            Pelicula("Un monstruo viene a verme", "Fantasía", 2016, "España", imagen = getDrawable(R.drawable.un_monstruo_viene_a_verme) )

        )
    }


}