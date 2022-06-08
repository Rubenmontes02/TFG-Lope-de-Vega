package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Datos_alumno extends AppCompatActivity {

    EditText id;
    EditText nombre;
    EditText clave;
    Button insertar;

    funcionalidadbd funcionalidadbd = new funcionalidadbd(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_alumno);

        id = (EditText) findViewById(R.id.etId);
        nombre = (EditText) findViewById(R.id.etNombre);
        clave = (EditText) findViewById(R.id.etClave);


    }


    public void funcionInsertar(View view) {

        SQLiteDatabase db = funcionalidadbd.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DbInfo.CAMPO_ID, id.getText().toString());
        values.put(DbInfo.CAMPO_NOMBRE, nombre.getText().toString());
        values.put(DbInfo.CAMPO_CLAVE, clave.getText().toString());


        long newRowId = db.insert(DbInfo.NOMBRE_TABLA, null, values);
        Toast.makeText(this, "Insertando:"+newRowId, Toast.LENGTH_SHORT).show();

        db.close();

        id.setText("");
        nombre.setText("");
        clave.setText("");

    }


}