package com.idnp.lab06_idnp_sp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Context context;
    EditText edit_name,edit_correo,edit_dni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_name = (EditText)findViewById(R.id.nombre);
        edit_correo = (EditText)findViewById(R.id.correo);
        edit_dni = (EditText)findViewById(R.id.dni);
        SharedPreferences s1 = getSharedPreferences("datos",Context.MODE_PRIVATE);
        edit_name.setText(s1.getString("name",""));
        edit_correo.setText(s1.getString("email",""));
        edit_dni.setText(s1.getString("dni",""));
    }

    public void Continuar(View view){

        Intent i = new Intent(this, MenuActivity.class);
        guardarSP();
        startActivity(i);
    }

    public void guardarSP(){
        SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString("name",edit_name.getText().toString());
        obj_editor.putString("email",edit_correo.getText().toString());
        obj_editor.putString("dni",edit_dni.getText().toString());

        obj_editor.commit();
        finish();
    }

}