package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Alumnos_registrados extends AppCompatActivity{

    TextView numero, dni, nombre, apellidos, nacionalidad, nacimiento, profesion,
            domicilio, localidad, provincia, pais, codigo_postal, telefono, correo,
            sexo, nombrePadre, apellidosPadre, correoPAdre, nombreMadre, apellidosMadre,
            correoMadre, ultimos_estudios, cursoea, centroea, localidadea;
    EditText etCodigo;
    funcionalidadbd funcionalidadbd = new funcionalidadbd(this);
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos_registrados);
        scrollView = (ScrollView) findViewById(R.id.datos);
        etCodigo = (EditText) findViewById(R.id.etCodigo);
        numero = (TextView) findViewById(R.id.tvNum);
        dni = (TextView) findViewById(R.id.tvDni);
        nombre = (TextView) findViewById(R.id.tvNombre);
        apellidos = (TextView) findViewById(R.id.tvApellidos);
        sexo = (TextView) findViewById(R.id.tvSexo);
        nacionalidad = (TextView) findViewById(R.id.tvNacionalidad);
        nacimiento = (TextView) findViewById(R.id.tvNacimiento);
        profesion = (TextView) findViewById(R.id.tvProfesion);
        domicilio = (TextView) findViewById(R.id.tvDomicilio);
        localidad = (TextView) findViewById(R.id.tvLocalidad);
        provincia = (TextView) findViewById(R.id.tvProvincia);
        pais = (TextView) findViewById(R.id.tvPais);
        codigo_postal = (TextView) findViewById(R.id.tvCodigo_postal);
        telefono = (TextView) findViewById(R.id.tvTelefono);
        correo = (TextView) findViewById(R.id.tvCorreo);
        nombrePadre = (TextView) findViewById(R.id.tvNombrePadre);
        apellidosPadre = (TextView) findViewById(R.id.tvApellidosPadre);
        correoPAdre = (TextView) findViewById(R.id.tvCorreoPadre);
        nombreMadre = (TextView) findViewById(R.id.tvNombreMadre);
        apellidosMadre = (TextView) findViewById(R.id.tvApellidoMadre);
        correoMadre = (TextView) findViewById(R.id.tvCorreoMadre);
        ultimos_estudios = (TextView) findViewById(R.id.tvUltimosEstudios);
        cursoea = (TextView) findViewById(R.id.tvCursoAE);
        centroea = (TextView) findViewById(R.id.tvCentroAE);
        localidadea = (TextView) findViewById(R.id.tvLocalodadEA);


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
                "select dni, nombre, apellidos, sexo, nacionalidad, nacimiento, profesion, domicilio, localidad, provincia, pais, codigo_postal," +
                        " telefono, correo, nombrePadre, apellidosPadre, correoPadre, nombreMadre, apellidosMadre," +
                        " correoMadre, ultimos_estudios, cursoea, centroea, localidadea from alumnos where dni="+codigo, null);


        if(numerofila.moveToFirst()){
            scrollView.setVisibility(View.VISIBLE);

            dni.setText(numerofila.getString(0));
            nombre.setText(numerofila.getString(1));
            apellidos.setText(numerofila.getString(2));
            sexo.setText(numerofila.getString(3));
            nacionalidad.setText(numerofila.getString(4));
            nacimiento.setText(numerofila.getString(5));
            profesion.setText(numerofila.getString(6));
            domicilio.setText(numerofila.getString(7));
            localidad.setText(numerofila.getString(8));
            provincia.setText(numerofila.getString(9));
            pais.setText(numerofila.getString(10));
            codigo_postal.setText(numerofila.getString(11));
            telefono.setText(numerofila.getString(12));
            correo.setText(numerofila.getString(13));
            nombrePadre.setText(numerofila.getString(14));
            apellidosPadre.setText(numerofila.getString(15));
            correoPAdre.setText(numerofila.getString(16));
            nombreMadre.setText(numerofila.getString(17));
            apellidosMadre.setText(numerofila.getString(18));
            correoMadre.setText(numerofila.getString(19));
            ultimos_estudios.setText(numerofila.getString(20));
            cursoea.setText(numerofila.getString(21));
            centroea.setText(numerofila.getString(22));
            localidadea.setText(numerofila.getString(23));




        }else{
            Toast.makeText(this, "Alumno no encontrado", Toast.LENGTH_SHORT).show();
            etCodigo.setText("");
            scrollView.setVisibility(View.GONE);

        }
        db.close();

    }


    public void funcionEliminar(View view) {

        scrollView.setVisibility(View.GONE);

        SQLiteDatabase db = funcionalidadbd.getWritableDatabase();
        
        String codigo;
        codigo = etCodigo.getText().toString();
        
        int elementosEliminados = 0;
        
        elementosEliminados = db.delete("alumnos", "dni="+codigo, null);
        
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