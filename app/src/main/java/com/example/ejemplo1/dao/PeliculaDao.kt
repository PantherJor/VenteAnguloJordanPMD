package com.example.ejemplo1.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ejemplo1.entities.Pelicula

@Dao
interface PeliculaDao {

    @Query ( " SELECT * FROM Pelicula " )
    fun getAll () : LiveData<List<Pelicula>>

    @Query ( " SELECT * FROM Pelicula WHERE id LIKE :id")
    fun findByid ( id : String ) : Pelicula

    @Insert
    fun insertAll ( vararg pelicula : Pelicula)

    @Delete
    fun eliminar ( pelicula : Pelicula )

    @Update
    fun UpdateAll (vararg pelicula : Pelicula )

}