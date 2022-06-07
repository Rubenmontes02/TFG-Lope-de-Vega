package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lopedevega.ProyectoFinalLopedeVega.db.DbAlumnos;

public class Datos_alumnos extends AppCompatActivity {


    EditText nombre, telefono, correo;
    Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_alumnos);

        nombre = (EditText) findViewById(R.id.etNombre);
        telefono = (EditText) findViewById(R.id.etTelefono);
        correo = (EditText) findViewById(R.id.etCorreo);
        guardar = (Button) findViewById(R.id.btguardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbAlumnos dbAlumnos = new DbAlumnos(Datos_alumnos.this);
                long id = dbAlumnos.insertarAlumno(nombre.getText().toString(), telefono.getText().toString(), correo.getText().toString());

                if(id < 0){
                    Toast.makeText(Datos_alumnos.this, "ALUMNO REGISTRADO CON EXITO", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Datos_alumnos.this, Modo_alumno.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Datos_alumnos.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


}