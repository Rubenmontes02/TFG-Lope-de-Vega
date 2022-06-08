package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lopedevega.ProyectoFinalLopedeVega.db.DbHelper;

public class Registro_alumnos extends AppCompatActivity {

    Button btncrear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumnos);
        btncrear = (Button) findViewById(R.id.crearbbdd);

        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHelper dbHelper = new DbHelper(Registro_alumnos.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(Registro_alumnos.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Registro_alumnos.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}