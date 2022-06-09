package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Spliterator;

public class Datos_alumno extends AppCompatActivity {

    EditText dni, nombre, apellidos, nacionalidad, nacimiento, profesion,
            domicilio, localidad, provincia, pais, codigo_postal, telefono, correo,
            nombrePadre, apellidosPadre, correoPAdre, dniPadre, nombreMadre, apellidosMadre,
            correoMadre, dniMadre, ultimos_estudios, cursoea, centroea, localidadea, centroEN, localidadEN;

    RadioButton hombre, mujer, medio, superior, primero, segundo, tercero, general, adultos;

    Spinner spinner;

    String sexo, regimen, cursoEN, nombre_curso, tipo;

    funcionalidadbd funcionalidadbd = new funcionalidadbd(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_alumno);

        dni = (EditText) findViewById(R.id.etDni);
        nombre = (EditText) findViewById(R.id.etNombre);
        apellidos = (EditText) findViewById(R.id.etApellidos);
        nacionalidad = (EditText) findViewById(R.id.etNacionalidad);
        nacimiento = (EditText) findViewById(R.id.etNacimiento);
        profesion = (EditText) findViewById(R.id.etProfesion);
        domicilio = (EditText) findViewById(R.id.etDomicilio);
        localidad = (EditText) findViewById(R.id.etLocalidad);
        provincia = (EditText) findViewById(R.id.etProvincia);
        pais = (EditText) findViewById(R.id.etPais);
        codigo_postal = (EditText) findViewById(R.id.etCodigoPostal);
        telefono = (EditText) findViewById(R.id.etTelefono);
        correo = (EditText) findViewById(R.id.etCorreo);
        hombre = (RadioButton) findViewById(R.id.rbHombre);
        mujer = (RadioButton) findViewById(R.id.rbMujer);
        nombrePadre = (EditText) findViewById(R.id.etNombrePadre);
        apellidosPadre = (EditText) findViewById(R.id.etApellidosPadre);
        correoPAdre = (EditText) findViewById(R.id.etCorreoPadre);
        dniPadre = (EditText) findViewById(R.id.etDniPadre);
        nombreMadre = (EditText) findViewById(R.id.etNombreMadre);
        apellidosMadre = (EditText) findViewById(R.id.etApellidosMadre);
        correoMadre = (EditText) findViewById(R.id.etCorreoMadre);
        dniMadre = (EditText) findViewById(R.id.etDniMadre);
        ultimos_estudios = (EditText) findViewById(R.id.etEstudiosRealizados);
        cursoea = (EditText) findViewById(R.id.etCursoA);
        centroea = (EditText) findViewById(R.id.etCentroA);
        localidadea = (EditText) findViewById(R.id.etLocalidadEA);
        centroEN = (EditText) findViewById(R.id.etCentroEN);
        localidadEN = (EditText) findViewById(R.id.etLocalidadEN);
        spinner = (Spinner)findViewById(R.id.spNombreCurso);
        medio = (RadioButton)findViewById(R.id.rbMedio);
        superior = (RadioButton)findViewById(R.id.rbSuperior);
        primero = (RadioButton)findViewById(R.id.rb1);
        segundo = (RadioButton)findViewById(R.id.rb2);
        tercero = (RadioButton)findViewById(R.id.rb3);
        general = (RadioButton)findViewById(R.id.rbGeneral);
        adultos = (RadioButton)findViewById(R.id.rbGestAdmin);




        ArrayList<String> cursos = new ArrayList<>();

        cursos.add("Seleccione un curso");
        cursos.add("Bachillerato de Ciencias de la Salud");
        cursos.add("Bachillerato de Humanidades");
        cursos.add("Bachillerato de Ciencias Sociales");
        cursos.add("Bachillerato Tecnológico");
        cursos.add("Grado Medio Sistemas Microinformáticos y Redes");
        cursos.add("Grado Medio Actividades Comerciales");
        cursos.add("Grado Medio Gestión Administrativa");
        cursos.add("Grado Superior Marketing y Publicidad");
        cursos.add("Grado Superior Desarrollo de Aplicaiones Multiplataforma");
        cursos.add("Grado Superior Administración de Sistemas Informáticos en Red a Distancia");

        ArrayAdapter adapter = new ArrayAdapter(Datos_alumno.this, android.R.layout.simple_spinner_dropdown_item, cursos);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String nombre = (String) spinner.getAdapter().getItem(i);

                nombre_curso = nombre;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void funcionInicio(View view) {

        Intent intent = new Intent(Datos_alumno.this, Inicio.class);
        startActivity(intent);
    }

    public void funcionInsertar(View view) {


        if (hombre.isChecked()){
            sexo = "Hombre";
        }else{
            if (mujer.isChecked()){
                sexo = "Mujer";
            }
        }

        if (medio.isChecked()) {
            tipo = "Grado Medio";
        }else{
            tipo = "Grado Superior";
        }

        if (primero.isChecked()){
            cursoEN = "1º";
        }if (segundo.isChecked()){
            cursoEN = "2º";
        }else{
            cursoEN = "3º";
        }

        if (general.isChecked()) {
            regimen = "Régimen General";
        }else{
            regimen = "Régimen de Personas Adultas";
        }

        SQLiteDatabase db = funcionalidadbd.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DbInfo.CAMPO_DNI, dni.getText().toString());
        values.put(DbInfo.CAMPO_NOMBRE, nombre.getText().toString());
        values.put(DbInfo.CAMPO_APELLIDOS, apellidos.getText().toString());
        values.put(DbInfo.CAMPO_SEXO, sexo);
        values.put(DbInfo.CAMPO_NACIONALIDAD, nacionalidad.getText().toString());
        values.put(DbInfo.CAMPO_NACIMIENTO, nacimiento.getText().toString());
        values.put(DbInfo.CAMPO_PROFESION, profesion.getText().toString());
        values.put(DbInfo.CAMPO_DOMICILIO, domicilio.getText().toString());
        values.put(DbInfo.CAMPO_LOCALIDAD, localidad.getText().toString());
        values.put(DbInfo.CAMPO_PROVINCIA, provincia.getText().toString());
        values.put(DbInfo.CAMPO_PAIS, pais.getText().toString());
        values.put(DbInfo.CAMPO_CODIGO_POSTAL, codigo_postal.getText().toString());
        values.put(DbInfo.CAMPO_TELEFONO, telefono.getText().toString());
        values.put(DbInfo.CAMPO_CORREO, correo.getText().toString());
        values.put(DbInfo.CAMPO_NOMBRE_PADRE, nombrePadre.getText().toString());
        values.put(DbInfo.CAMPO_APELLIDOS_PADRE, apellidosPadre.getText().toString());
        values.put(DbInfo.CAMPO_CORREO_PADRE, correoPAdre.getText().toString());
        values.put(DbInfo.CAMPO_DNI_PADRE, dniPadre.getText().toString());
        values.put(DbInfo.CAMPO_NOMBRE_MADRE, nombreMadre.getText().toString());
        values.put(DbInfo.CAMPO_APELLIDOS_MADRE, apellidosMadre.getText().toString());
        values.put(DbInfo.CAMPO_CORREO_MADRE, correoMadre.getText().toString());
        values.put(DbInfo.CAMPO_DNI_MADRE, dniMadre.getText().toString());
        values.put(DbInfo.CAMPO_ULTIMOS_ESTUDIOS, ultimos_estudios.getText().toString());
        values.put(DbInfo.CAMPO_CURSOA, cursoea.getText().toString());
        values.put(DbInfo.CAMPO_CURSOA, centroea.getText().toString());
        values.put(DbInfo.CAMPO_LOCALIDADEA, localidadea.getText().toString());
        values.put(DbInfo.CAMPO_CENTROEN, centroEN.getText().toString());
        values.put(DbInfo.CAMPO_LOCALIDADEN, localidadEN.getText().toString());
        values.put(DbInfo.CAMPO_NOMBREEN, nombre_curso);
        values.put(DbInfo.CAMPO_TIPOEN, tipo);
        values.put(DbInfo.CAMPO_REGIMENEN, regimen);
        values.put(DbInfo.CAMPO_CURSOEN, cursoEN);


        long newRowId = db.insert(DbInfo.NOMBRE_TABLA, null, values);
        Toast.makeText(this, "Insertando:"+newRowId, Toast.LENGTH_SHORT).show();

        db.close();

        dni.setText("");
        nombre.setText("");
        apellidos.setText("");
        nacionalidad.setText("");
        nacimiento.setText("");
        profesion.setText("");
        domicilio.setText("");
        localidad.setText("");
        provincia.setText("");
        pais.setText("");
        codigo_postal.setText("");
        telefono.setText("");
        correo.setText("");
        hombre.setChecked(false);
        mujer.setChecked(false);
        nombrePadre.setText("");
        apellidosPadre.setText("");
        correoPAdre.setText("");
        dniPadre.setText("");
        nombreMadre.setText("");
        apellidosMadre.setText("");
        correoMadre.setText("");
        dniMadre.setText("");
        ultimos_estudios.setText("");
        cursoea.setText("");
        centroea.setText("");
        localidadea.setText("");
        centroEN.setText("");
        localidadEN.setText("");
        medio.setChecked(false);
        superior.setChecked(false);
        primero.setChecked(false);
        segundo.setChecked(false);
        tercero.setChecked(false);
        general.setChecked(false);
        adultos.setChecked(false);





    }


}