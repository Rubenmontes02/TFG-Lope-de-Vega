package com.lopedevega.ProyectoFinalLopedeVega.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

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
}
