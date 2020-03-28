package com.example.ejemplo1.dao

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.ejemplo1.entities.Pelicula

class PeliculasViewModel (application: Application) : AndroidViewModel(application) {
    private val repository = PeliculaRepository(application)
    val peliculas = repository.getPeliculas()
    fun savePelicula(pelicula: Pelicula) {
        repository.insert(pelicula)
    }
}