package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Modo_alumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_alumno);
    }

    public void funcion_contacto(View view) {
        Intent intent = new Intent(Modo_alumno.this, Contacto.class);
        startActivity(intent);

    }

    public void funcion_ubicacion(View view) {
        Intent intent = new Intent(Modo_alumno.this, ubication.class);
        startActivity(intent);
    }

    public void funcion_matricula(View view) {
        Intent intent = new Intent(Modo_alumno.this, Datos_alumno.class);
        startActivity(intent);
    }
}