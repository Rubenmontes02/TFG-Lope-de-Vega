package com.lopedevega.ProyectoFinalLopedeVega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Modo_profesor extends AppCompatActivity {

    
    EditText user, password;
    
    String usuario, contraseña, Vusuario, Vcontraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_profesor);
        
        user = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        
    }


    public void entrar(View view) {
        usuario = user.getText().toString();
        contraseña = password.getText().toString();



        if(usuario.equals("user")){
            if (contraseña.equals("user")){
                Toast.makeText(this, "Accediendo...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Modo_profesor.this, Alumnos_registrados.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "El usuario es incorrecto", Toast.LENGTH_SHORT).show();
        }

    }
}