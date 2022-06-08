package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Alumnos_registrados extends AppCompatActivity{

    TextView numero;
    EditText etCodigo;
    funcionalidadbd funcionalidadbd = new funcionalidadbd(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos_registrados);
        etCodigo = (EditText) findViewById(R.id.etCodigo);
        numero = (TextView) findViewById(R.id.tvNum);
        funcionContar();
    }

    public void funcionContar(){
        SQLiteDatabase db = funcionalidadbd.getWritableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DbInfo.NOMBRE_TABLA);
        numero.setText(String.valueOf(numRows));
    }


    public void funcionConsultar(View view) {

        SQLiteDatabase db = funcionalidadbd.getWritableDatabase();

        String codigo;
        codigo = etCodigo.getText().toString();

        Cursor numerofila = db.rawQuery(
                "select nombre, clave from alumnos where id="+codigo, null);


        if(numerofila.moveToFirst()){
            etCodigo.setText(numerofila.getString(0));
        }else{
            Toast.makeText(this, "Id no encontrado", Toast.LENGTH_SHORT).show();
            etCodigo.setText("");
        }
        db.close();

    }


    public void funcionEliminar(View view) {
        
        SQLiteDatabase db = funcionalidadbd.getWritableDatabase();
        
        String codigo;
        codigo = etCodigo.getText().toString();
        
        int elementosEliminados = 0;
        
        elementosEliminados = db.delete("alumnos", "id="+codigo, null);
        
        db.close();
        
        etCodigo.setText("");
        
        if (elementosEliminados == 0){
            Toast.makeText(this, "Alumno no eliminado", Toast.LENGTH_SHORT).show();
            funcionContar();
        }else{
            Toast.makeText(this, "Alumno eliminado", Toast.LENGTH_SHORT).show();
            funcionContar();
        }
        
    }
}