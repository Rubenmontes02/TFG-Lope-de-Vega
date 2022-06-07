package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Modo_profesor extends AppCompatActivity {

    EditText usuario;
    EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_profesor);

        usuario = (EditText) findViewById(R.id.username);
        contraseña = (EditText) findViewById(R.id.password);



    }

    public void funcion_login(View view) {

        String user;
        user = usuario.getText().toString();
        String password;
        password = contraseña.getText().toString();

        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();

        if(user != "user"){
            Toast.makeText(this, "Entrando...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Modo_profesor.this, Alumnos_registrados.class);
                startActivity(intent);

        }else{
            Toast.makeText(this, "El usuario no coincide", Toast.LENGTH_SHORT).show();
        }


    }
}