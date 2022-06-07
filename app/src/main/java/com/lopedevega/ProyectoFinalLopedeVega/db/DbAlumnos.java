package com.lopedevega.ProyectoFinalLopedeVega.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.lopedevega.ProyectoFinalLopedeVega.entities.Alumnos;

import java.util.ArrayList;

public class DbAlumnos extends DbHelper{

    Context context;


    public DbAlumnos(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long insertarAlumno(String nombre, String telefono, String correo_electronico){

        long id = 0;

    try{

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("telefono", telefono);
        values.put("correo_electronico", correo_electronico);

        id = db.insert(TABLE_ALUMNOS, null, values);

    }catch (Exception e){
        e.toString();
    }

        return id;
    }

    public ArrayList<Alumnos> leerAlumnos(){


        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Alumnos> listaAlumnos = new ArrayList<>();
        Alumnos alumno = null;
        Cursor cursorAlumnos = null;

        cursorAlumnos = db.rawQuery("SELECT * FROM " + TABLE_ALUMNOS, null);

        if(cursorAlumnos.moveToFirst()){
            do{
                alumno = new Alumnos();
                alumno.setId(cursorAlumnos.getInt(0));
                alumno.setNombre(cursorAlumnos.getString(1));
                alumno.setTelefono(cursorAlumnos.getString(2));
                alumno.setCorreo_electronico(cursorAlumnos.getString(3));
                listaAlumnos.add(alumno);

            }while (cursorAlumnos.moveToNext());
        }

        cursorAlumnos.close();

        return listaAlumnos;

    }

}
