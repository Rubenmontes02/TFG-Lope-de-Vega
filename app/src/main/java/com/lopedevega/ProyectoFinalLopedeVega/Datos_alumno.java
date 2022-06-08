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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Datos_alumno extends AppCompatActivity {

    EditText numero, dni, nombre, apellidos, nacionalidad, nacimiento, profesion,
            domicilio, localidad, provincia, pais, codigo_postal, telefono, correo,
            nombrePadre, apellidosPadre, correoPAdre, nombreMadre, apellidosMadre,
            correoMadre, ultimos_estudios, cursoea, centroea, localidadea;
    RadioButton hombre, mujer;

    String sexo;

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
        nombreMadre = (EditText) findViewById(R.id.etNombreMadre);
        apellidosMadre = (EditText) findViewById(R.id.etApellidosMadre);
        correoMadre = (EditText) findViewById(R.id.etCorreoMadre);

        ultimos_estudios = (EditText) findViewById(R.id.etEstudiosRealizados);
        cursoea = (EditText) findViewById(R.id.etCursoA);
        centroea = (EditText) findViewById(R.id.etCentroA);
        localidadea = (EditText) findViewById(R.id.etLocalidadEA);





    }


    public void funcionInsertar(View view) {


        if (hombre.isChecked()){
            sexo = "Hombre";
        }else{
            if (mujer.isChecked()){
                sexo = "Mujer";
            }
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
        values.put(DbInfo.CAMPO_NOMBRE_MADRE, nombreMadre.getText().toString());
        values.put(DbInfo.CAMPO_APELLIDOS_MADRE, apellidosMadre.getText().toString());
        values.put(DbInfo.CAMPO_CORREO_MADRE, correoMadre.getText().toString());

        values.put(DbInfo.CAMPO_ULTIMOS_ESTUDIOS, ultimos_estudios.getText().toString());
        values.put(DbInfo.CAMPO_CURSOA, cursoea.getText().toString());
        values.put(DbInfo.CAMPO_CURSOA, centroea.getText().toString());
        values.put(DbInfo.CAMPO_LOCALIDADEA, localidadea.getText().toString());





        db.insert(DbInfo.NOMBRE_TABLA, null, values);
        Toast.makeText(this, "Alumno registrado", Toast.LENGTH_SHORT).show();

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
        nombreMadre.setText("");
        apellidosMadre.setText("");
        correoMadre.setText("");

        ultimos_estudios.setText("");
        cursoea.setText("");
        centroea.setText("");
        localidadea.setText("");



    }


}