package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegistroActivity extends AppCompatActivity {
    private Button btnRegistrarse;
    private EditText etEmail;
    private EditText etPass;


    private SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etContraseña);


        sharedPref = getSharedPreferences(
                "appPelis",
                Context.MODE_PRIVATE
        );


        String em = sharedPref.getString("email", "");
        String pw = sharedPref.getString("contrasenha", "");


        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String correo = etEmail.getText().toString();
                String contrasenha = etPass.getText().toString();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("email", correo);
                editor.putString("contrasenha", contrasenha);


                editor.apply();

                Intent i = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(i);




            }
        });


        Button btn2 = findViewById(R.id.btnRegistrarse);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent2, 0);


            }
        });
    }
}
