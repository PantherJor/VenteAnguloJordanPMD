package com.example.ejemplo1.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplo1.R
import com.example.ejemplo1.activities.NuevaPeliculaActivity
import com.example.ejemplo1.entities.Pelicula
import kotlinx.android.synthetic.main.activity_list_peliculas.*
import kotlinx.android.synthetic.main.item_pelicula.view.*



class PeliculaListAdapter(val peliculas : List<Pelicula>, val context: Context) :
    RecyclerView.Adapter<PeliculaListAdapter.PeliculaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaHolder {
        return PeliculaHolder(LayoutInflater.from(context).inflate(R.layout.item_pelicula, parent, false))

    }

    override fun getItemCount() = peliculas.size

    override fun onBindViewHolder(holder: PeliculaHolder, position: Int) {
        holder.imageView4?.setImageDrawable(peliculas[position].imagen)
        holder.tvPeliculaTitle?.text = peliculas[position].title
        holder.tvPeliculaType?.text = peliculas[position].type
        holder.tvPeliculaYear?.text = peliculas[position].year.toString()
        holder.tvPeliculaCountry?.text = peliculas[position].country



    }

    class PeliculaHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView4 = view.imageView4
        val tvPeliculaTitle = view.tvPeliculaTitle
        val tvPeliculaType = view.tvPeliculaType
        val tvPeliculaYear = view.tvPeliculaYear
        val tvPeliculaCountry = view.tvPeliculaCountry
    }


}