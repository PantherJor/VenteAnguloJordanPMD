package com.example.ejemplo1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ejemplo1.activities.PeliculaListActivity
import com.example.ejemplo1.dao.AppDatabase
import com.example.ejemplo1.entities.Pelicula
import kotlinx.android.synthetic.main.activity_list_peliculas.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.etContraseña
import kotlinx.android.synthetic.main.activity_main.etEmail
import kotlinx.android.synthetic.main.formulario_nueva_pelicula.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

      val p =   AppDatabase.getDatabase(this@MainActivity)?.getPeliculaDao()?.getAll()
        editTextnewtitle.setText(p?.toString())
        editTextgenero.setText(p?.toString())
        editTextano.setText(p?.toString())
        editTextPais.setText(p?.toString())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        floatingActionButton2
        var sharedPref = getSharedPreferences("appPelis", Context.MODE_PRIVATE)

        //log.d(tag: "MainActivity", msg:"Usuario guardado "+ preferences.)


        btnAcceder.setOnClickListener {

            val emailGuardado = sharedPref.getString("email","")
            val emailIntroducido = etEmail.getText().toString()

            val contrasenaGuardada = sharedPref.getString( "contrasenha","")
            val contrasenaIntroducida = etContraseña.getText().toString()

            Log.d("ContrasenhaGuardada", contrasenaGuardada)
            Log.d("ContrasenhaIntroducida", contrasenaIntroducida)


            if(emailGuardado.equals(emailIntroducido)
                 && contrasenaGuardada.equals(contrasenaIntroducida)){

                val i = Intent(this, PeliculaListActivity::class.java)
                startActivity(i)

            }else{
                Toast.makeText(this," error/datos introducidos incorrectos", Toast.LENGTH_LONG).show()

            }



            //val i = Intent(this, PeliculaListActivity::class.java)
            //startActivity(i)



        }


        btnRegistro.setOnClickListener {

            val i2 = Intent(this, RegistroActivity::class.java)
            startActivity(i2)
        }





















    }


}

