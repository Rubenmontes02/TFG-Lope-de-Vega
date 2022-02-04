package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void funcion_contacto(View view) {
        Intent intent = new Intent(MainActivity.this, Contacto.class);
        startActivity(intent);

    }

    public void funcion_ubicacion(View view) {
        Intent intent = new Intent(MainActivity.this, ubication.class);
        startActivity(intent);
    }

    public void funcion_matricula(View view) {
        Intent intent = new Intent(MainActivity.this, Matricula.class);
        startActivity(intent);
    }
}