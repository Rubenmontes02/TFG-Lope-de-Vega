package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class Matricula extends AppCompatActivity {



    RadioButton bachillerato;
    RadioButton medio;
    RadioButton superior;

    RadioButton Bach_Salud;
    RadioButton Bach_Sociales;

    RadioButton GMedio_ASIR;
    RadioButton GMedio_ActComer;
    RadioButton GMedio_GestAdmin;

    RadioButton GSPrivado;
    RadioButton GSPublico;

    RadioButton GSMarketing;
    RadioButton GSASIRD;
    RadioButton GSDAM;
    RadioButton GSAdminFinan;
    RadioButton GSASIR2;

    LinearLayout Layout_Bach;
    LinearLayout Layout_Medio;
    LinearLayout Layout_Superior;
    LinearLayout Layout_SPublico;
    LinearLayout Layout_SPrivado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula);
        bachillerato = (RadioButton) findViewById(R.id.rbBach);
        medio = (RadioButton) findViewById(R.id.rbMedio);
        superior = (RadioButton) findViewById(R.id.rbSuperior);

        Bach_Salud = (RadioButton) findViewById(R.id.rbSalud);
        Bach_Sociales = (RadioButton) findViewById(R.id.rbSociales);

        GMedio_ASIR = (RadioButton) findViewById(R.id.rbASIR);
        GMedio_ActComer= (RadioButton) findViewById(R.id.rbActComerciales);
        GMedio_GestAdmin = (RadioButton) findViewById(R.id.rbGestAdmin);

        GSASIRD = (RadioButton) findViewById(R.id.rbASIRD);
        GSMarketing = (RadioButton) findViewById(R.id.rbMarkPubli);
        GSDAM = (RadioButton) findViewById(R.id.rbDAM);
        GSAdminFinan = (RadioButton) findViewById(R.id.rbAdminFinan);
        GSASIR2 = (RadioButton) findViewById(R.id.rbASIR2);

        GSPrivado = (RadioButton) findViewById(R.id.rbPrivado);
        GSPublico = (RadioButton) findViewById(R.id.rbPublico);





        Layout_Bach = (LinearLayout) findViewById(R.id.LBach);
        Layout_Medio = (LinearLayout) findViewById(R.id.LMedio);
        Layout_Superior = (LinearLayout) findViewById(R.id.LSuperior);
        Layout_SPrivado = (LinearLayout) findViewById(R.id.LPrivado);
        Layout_SPublico = (LinearLayout) findViewById(R.id.LPublico);


    }

    public void inicio(View view) {
        finish();
    }


    public void funcionbach(View view) {
        if (bachillerato.isChecked()) {
            medio.setChecked(false);
            superior.setChecked(false);
            Layout_Bach.setVisibility(View.VISIBLE);
            Layout_Medio.setVisibility(View.GONE);
            Layout_Superior.setVisibility(View.GONE);
        } else {
            Layout_Bach.setVisibility(View.GONE);
        }

    }

    public void seleccionmedio(View view) {
        if (medio.isChecked()) {
            bachillerato.setChecked(false);
            superior.setChecked(false);
            Layout_Medio.setVisibility(View.VISIBLE);
            Layout_Bach.setVisibility(View.GONE);
            Layout_Superior.setVisibility(View.GONE);
        } else {
            Layout_Medio.setVisibility(View.GONE);
        }
    }

    public void seleccionsuperior(View view) {
        if (superior.isChecked()) {
            bachillerato.setChecked(false);
            medio.setChecked(false);
            Layout_Superior.setVisibility(View.VISIBLE);
            Layout_Bach.setVisibility(View.GONE);
            Layout_Medio.setVisibility(View.GONE);
        } else {
            Layout_Superior.setVisibility(View.GONE);
        }
    }

    public void funcionpublico(View view) {

        if (GSPublico.isChecked()) {
            GSPrivado.setChecked(false);
            Layout_SPublico.setVisibility(View.VISIBLE);
            Layout_SPrivado.setVisibility(View.GONE);
        }else{
            Layout_SPublico.setVisibility(View.GONE);

        }

    }

    public void funcionprivado(View view) {

        if (GSPrivado.isChecked()) {
            GSPublico.setChecked(false);
            Layout_SPrivado.setVisibility(View.VISIBLE);
            Layout_SPublico.setVisibility(View.GONE);
        }else{
            Layout_SPrivado.setVisibility(View.GONE);

        }

    }


    public void funcionBachSalud(View view) {

        if (Bach_Salud.isChecked()) {
            Bach_Sociales.setChecked(false);
        }

    }

    public void funcionBachSociales(View view) {

        if (Bach_Sociales.isChecked()) {
            Bach_Salud.setChecked(false);
        }

    }

    public void funciongestadmini(View view) {

        if (GMedio_GestAdmin.isChecked()) {
            GMedio_ASIR.setChecked(false);
            GMedio_ActComer.setChecked(false);
        }

    }

    public void funcionactComer(View view) {


        if (GMedio_ActComer.isChecked()) {
            GMedio_ASIR.setChecked(false);
            GMedio_GestAdmin.setChecked(false);
        }

    }

    public void funcionASIR1(View view) {

        if (GMedio_ASIR.isChecked()) {
            GMedio_GestAdmin.setChecked(false);
            GMedio_ActComer.setChecked(false);
        }

    }

    public void seleccionasirdistancia(View view) {

        if(GSASIRD.isChecked()){
            GSDAM.setChecked(false);
            GSMarketing.setChecked(false);

        }

    }

    public void selecciondam(View view) {

        if(GSDAM.isChecked()){
            GSMarketing.setChecked(false);
            GSASIRD.setChecked(false);

        }
    }

    public void seleccionmarketing(View view) {

        if(GSMarketing.isChecked()){
            GSDAM.setChecked(false);
            GSASIRD.setChecked(false);

        }
    }

    public void seleccionfinanzas(View view) {

        if(GSAdminFinan.isChecked()){
            GSASIR2.setChecked(false);

        }

    }

    public void seleccionasir2(View view) {

        if(GSASIR2.isChecked()){
            GSAdminFinan.setChecked(false);

        }
    }
}