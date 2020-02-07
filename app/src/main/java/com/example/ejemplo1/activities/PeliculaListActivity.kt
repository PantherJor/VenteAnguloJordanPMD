package com.example.ejemplo1.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        val peliculas =  mockPeliculas()

        var adapter = PeliculaListAdapter(peliculas, this)

        rvPeliculaList.adapter = adapter

    }

    private fun mockPeliculas(): List<Pelicula>{
        return listOf(
           Pelicula("Bad Boys for Life", "Acción/comedia",2020, "Estados Unidos" ),
           Pelicula("Joker", "Drama",2019, "Estados Unidos" ),
           Pelicula("Black Panther", "Acción",2018, "Estados Unidos" ),
           Pelicula("Mi Villano Favorito 3", "Animación/comedia",2017, "Estados Unidos" ),
           Pelicula("Un monstruo viene a verme", "Fantasía",2016, "España" )

        )
    }
}