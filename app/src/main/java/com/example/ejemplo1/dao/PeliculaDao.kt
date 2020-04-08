package com.example.ejemplo1.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ejemplo1.entities.Pelicula

@Dao
interface PeliculaDao {



    @Query ( " SELECT * FROM Pelicula " )
    fun getAll () : LiveData<List<Pelicula>>

    @Query ( " SELECT * FROM Pelicula WHERE id = :id")
    fun findByid ( id : Long ) : Pelicula?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun update (pelicula : Pelicula)

    @Delete
    fun eliminar ( pelicula : Pelicula )



}

