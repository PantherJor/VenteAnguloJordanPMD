package com.example.ejemplo1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.ejemplo1.activities.PeliculaListActivity
import kotlinx.android.synthetic.main.activity_list_peliculas.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val sharedPref = getPreferences(Context.MODE_PRIVATE)



        btnAcceder.setOnClickListener {
          val i = Intent(this, PeliculaListActivity::class.java)

            startActivity(i);

        }


        btnRegistro.setOnClickListener {
            val i2 = Intent( this, RegistroActivity::class.java)

            startActivity(i2);
        }













    }
}
