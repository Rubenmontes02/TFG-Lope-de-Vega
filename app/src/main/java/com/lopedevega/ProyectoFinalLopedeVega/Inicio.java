package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void funcion_alumno(View view) {

        Intent intent = new Intent(Inicio.this, Modo_alumno.class);
        startActivity(intent);
    }

    public void funcion_profesor(View view) {
        Intent intent = new Intent(Inicio.this, Modo_profesor.class);
        startActivity(intent);

    }
}