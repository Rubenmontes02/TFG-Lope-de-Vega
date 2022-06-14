package com.lopedevega.ProyectoFinalLopedeVega;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;


public class Alumnos_registrados extends AppCompatActivity {

    TextView numero, dni, nombre, apellidos, nacionalidad, nacimiento, profesion,
            domicilio, localidad, provincia, pais, codigo_postal, telefono, correo,
            sexo, nombrePadre, apellidosPadre, correoPAdre,dniPadre, nombreMadre, apellidosMadre,
            correoMadre, dniMadre, ultimos_estudios, cursoea, centroea, localidadea, centroEN, localidadEN, nombreEN, tipoEN, regimenEN, cursoEN;

    EditText etCodigo;
    funcionalidadbd funcionalidadbd = new funcionalidadbd(this);
    ScrollView scrollView;


    Button btGenerarPdf;
    String alumnoText = "El alumno no se ha encontrado";
    String alumnoText2 = "El alumno no se ha encontrado";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos_registrados);



        btGenerarPdf = (Button)findViewById(R.id.pdf);
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
        dniPadre = (TextView) findViewById(R.id.tvDniPadre);
        nombreMadre = (TextView) findViewById(R.id.tvNombreMadre);
        apellidosMadre = (TextView) findViewById(R.id.tvApellidoMadre);
        correoMadre = (TextView) findViewById(R.id.tvCorreoMadre);
        dniMadre = (TextView) findViewById(R.id.tvDniMadre);
        ultimos_estudios = (TextView) findViewById(R.id.tvUltimosEstudios);
        cursoea = (TextView) findViewById(R.id.tvCursoEA);
        centroea = (TextView) findViewById(R.id.tvCentroEA);
        localidadea = (TextView) findViewById(R.id.tvLocalodadEA);
        centroEN = (TextView) findViewById(R.id.tvCentroEN);
        localidadEN = (TextView) findViewById(R.id.tvLocalidadEN);
        nombreEN = (TextView) findViewById(R.id.tvNombreEN);
        tipoEN = (TextView) findViewById(R.id.tvTipoEN);
        regimenEN = (TextView) findViewById(R.id.tvRegimen);
        cursoEN = (TextView) findViewById(R.id.tvCursoEN);

        if(checkPermission()) {
            Toast.makeText(this, "Permiso Aceptado", Toast.LENGTH_LONG).show();
        } else {
            requestPermissions();
        }

        btGenerarPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generarPdf();
            }
        });

        funcionContar();
    }

    public void generarPdf(){

        completarDatos();

        PdfDocument pdfDocument = new PdfDocument();
        Paint paint = new Paint();
        TextPaint descripcion = new TextPaint();

        Bitmap bitmap, bitmapEscala;

        PdfDocument.PageInfo paginaInfo = new PdfDocument.PageInfo.Builder(595, 842, 1).create();
        PdfDocument.Page pagina1 = pdfDocument.startPage(paginaInfo);


        Canvas canvas = pagina1.getCanvas();

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.matricula_imagen);
        bitmapEscala = Bitmap.createScaledBitmap(bitmap, 180, 100, false);
        canvas.drawBitmap(bitmapEscala, 220, 10, paint);


        descripcion.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        descripcion.setTextSize(9);

        String[] arrDescripcion = alumnoText.split("\n");
        int y = 115;
        for(int i = 0 ; i < arrDescripcion.length ; i++) {
            canvas.drawText(arrDescripcion[i], 20, y, descripcion);
            y += 15;
        }

        pdfDocument.finishPage(pagina1);


        File file = new File(Environment.getExternalStorageDirectory(), "Matricula.pdf");
        try {
            pdfDocument.writeTo(new FileOutputStream(file));
            Toast.makeText(this, "Se creo el PDF correctamente", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        pdfDocument.close();
    }

    private void completarDatos() {
        SQLiteDatabase db = funcionalidadbd.getWritableDatabase();

        String codigo;
        codigo = etCodigo.getText().toString();

        Cursor numerofila = db.rawQuery(
                "select dni, nombre, apellidos, sexo, nacionalidad, nacimiento, profesion, domicilio, localidad, provincia, pais, codigo_postal," +
                        " telefono, correo, nombre_padre, apellidos_padre, correo_padre, dni_padre, nombre_madre, apellidos_madre, correo_madre, dni_madre," +
                        "ultimos_estudios, cursoEA, centroEA, localidadEA, centroEN, localidadEN, nombreEn, tipoEN, regimenEN, cursoEN from alumnos where telefono="+codigo, null);

        if(numerofila.moveToFirst()){

            alumnoText = "Datos de la Persona Solicitante: \n \n" +
                            "Nombre del alumno: " + " " +
                            numerofila.getString(1) + " " + numerofila.getString(2) + "\n" +
                            "DNI del alumno: " + " " +
                            numerofila.getString(0) + "\n" +
                            "Sexo del alumno: " + " " +
                            numerofila.getString(3) + "\n" +
                            "Nacionalidad del alumno: " + " " +
                            numerofila.getString(4) + "\n" +
                            "Nacimiento del alumno: " + " " +
                            numerofila.getString(5) + "\n" +
                            "Profesión del alumno: " + " " +
                            numerofila.getString(6) + "\n" +
                            "Domicilio del alumno: " + " " +
                            numerofila.getString(7) + "\n" +
                            "Localidad del alumno: " + " " +
                            numerofila.getString(8) + "\n" +
                            "Provincia del alumno: " + " " +
                            numerofila.getString(9) + "\n" +
                            "Pais del alumno: " + " " +
                            numerofila.getString(10) + "\n" +
                            "Código Postal del alumno: " + " " +
                            numerofila.getString(11) + "\n" +
                            "Teléfono del alumno: " + " " +
                            numerofila.getString(12) + "\n" +
                            "Correo del alumno: " + " " +
                            numerofila.getString(13) + "\n \n" +
                            "Datos de los Tutores Legales del Alumno: \n \n" +
                            "Tutor legal 1: \n" +
                            "Nombre: " + " " +
                            numerofila.getString(14) + " " + numerofila.getString(15) + "\n" +
                            "DNI: " + " " +
                            numerofila.getString(16) + "\n" +
                            "Correo: " + " " +
                            numerofila.getString(17) + "\n" +
                            "Tutor legal 2: \n" +
                            "Nombre: " + " " +
                            numerofila.getString(18) + " " +numerofila.getString(19) + "\n" +
                            "DNI: " + " " +
                            numerofila.getString(20) + "\n" +
                            "Correo: " + " " +
                            numerofila.getString(21) + "\n \n" +
                            "Datos Académicos: \n \n" +
                            "Últimos estudios realizados: " + " " +
                            numerofila.getString(22) + "\n" +
                            "Curso: " + " " +
                            numerofila.getString(23) + "\n" +
                            "Centro: " + " " +
                            numerofila.getString(24) + "\n" +
                            "Localidad: " + " " +
                            numerofila.getString(25) + "\n \n" +
                            "Datos de la Matricula: \n \n" +

                            "Centro: " + " " +
                            numerofila.getString(26) + "\n" +
                            "Localidad: " + " " +
                            numerofila.getString(27) + "\n" +
                            "Nombre del curso: " + " " +
                            numerofila.getString(28) + "\n" +
                            "Tipo de grado: " + " " +
                            numerofila.getString(29) + "\n" +
                            "Tipo de régimen: " + " " +
                            numerofila.getString(30) + "\n" +
                            "Curso en el que se matricula: " + " " +
                            numerofila.getString(31) + "\n\n\n\n\n\n" +
                            "Firma del director:                                                                                                                             Firma del alumno: ";


        }else{
            Toast.makeText(this, "Alumno no encontrado", Toast.LENGTH_SHORT).show();
            etCodigo.setText("");
            scrollView.setVisibility(View.GONE);

        }
        db.close();

    }

    private boolean checkPermission() {
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, 200);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 200) {
            if(grantResults.length > 0) {
                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if(writeStorage && readStorage) {
                    Toast.makeText(this, "Permiso concedido", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Permiso denegado", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }
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
                " telefono, correo, nombre_padre, apellidos_padre, correo_padre, dni_padre, nombre_madre, apellidos_madre, correo_madre, dni_madre," +
                "ultimos_estudios, cursoEA, centroEA, localidadEA, centroEN, localidadEN, nombreEn, tipoEN, regimenEN, cursoEN from alumnos where telefono="+codigo, null);

        if(numerofila.moveToFirst()){

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
            dniPadre.setText(numerofila.getString(17));
            nombreMadre.setText(numerofila.getString(18));
            apellidosMadre.setText(numerofila.getString(19));
            correoMadre.setText(numerofila.getString(20));
            dniMadre.setText(numerofila.getString(21));
            ultimos_estudios.setText(numerofila.getString(22));
            cursoea.setText(numerofila.getString(23));
            centroea.setText(numerofila.getString(24));
            localidadea.setText(numerofila.getString(25));
            centroEN.setText(numerofila.getString(26));
            localidadEN.setText(numerofila.getString(27));
            nombreEN.setText(numerofila.getString(28));
            tipoEN.setText(numerofila.getString(29));
            regimenEN.setText(numerofila.getString(30));
            cursoEN.setText(numerofila.getString(31));


            scrollView.setVisibility(View.VISIBLE);




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
        
        elementosEliminados = db.delete("alumnos", "telefono="+codigo, null);
        
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

    public void nuevoCodigo(View view) {

        scrollView.setVisibility(View.GONE);
    }

    public void funcionInicio(View view) {

        Intent intent = new Intent(Alumnos_registrados.this, Inicio.class);
        startActivity(intent);
    }


}