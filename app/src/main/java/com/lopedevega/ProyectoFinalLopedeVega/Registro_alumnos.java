package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lopedevega.ProyectoFinalLopedeVega.adapter.ListaAlumnosAdapter;
import com.lopedevega.ProyectoFinalLopedeVega.db.DbAlumnos;
import com.lopedevega.ProyectoFinalLopedeVega.db.DbHelper;
import com.lopedevega.ProyectoFinalLopedeVega.entities.Alumnos;

import java.util.ArrayList;

public class Registro_alumnos extends AppCompatActivity {

    RecyclerView recycler;
    ArrayList<Alumnos> listaAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alumnos);

        recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        DbAlumnos dbAlumnos = new DbAlumnos(Registro_alumnos.this);

        listaAlumnos = new ArrayList<>();

        ListaAlumnosAdapter adapter = new ListaAlumnosAdapter(dbAlumnos.leerAlumnos());

        recycler.setAdapter(adapter);


    }
}