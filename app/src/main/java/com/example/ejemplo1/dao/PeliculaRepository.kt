package com.example.ejemplo1.dao

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ejemplo1.entities.Pelicula

class PeliculaRepository (application : Application ) {
    private val peliculaDao: PeliculaDao? = AppDatabase.getDatabase(application)?.peliculaDao()
    fun insert(pelicula: Pelicula) {
        if (peliculaDao != null) (peliculaDao).insertAll(pelicula)
    }
    fun getPeliculas(): LiveData<List<Pelicula>> {
        return peliculaDao?.getAll() ?: MutableLiveData<List<Pelicula>>()
    }
    private class InsertAsyncTask(private val peliculaDao: PeliculaDao) :
        AsyncTask<Pelicula, Void, Void>() {
        override fun doInBackground(vararg peliculas: Pelicula?): Void? {
            for (pelicula in peliculas) {
                if (pelicula != null) peliculaDao.insertAll(pelicula)
            }
            return null
        }
    }
}