package com.example.ejemplo1.entities

import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pelicula(

    @PrimaryKey(autoGenerate = true) var id: Long,

    var title:String,
    var type:String,
    var year: Int,
    var country:String,
    val imagen: Drawable?
) {}