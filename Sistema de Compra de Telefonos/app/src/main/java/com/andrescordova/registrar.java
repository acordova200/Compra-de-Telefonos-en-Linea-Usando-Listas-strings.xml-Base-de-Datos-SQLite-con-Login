package com.andrescordova;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/**
 *
 * @author Andres Cordova <github.com/acordova200>
 */
public class Registrar extends AppCompatActivity {


    EditText edtDui = null;
    EditText edtNombre = null;
    EditText edtDireccion = null;
    EditText edtEdad = null;
    EditText edtUser = null;
    EditText edtPass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtDui = (EditText) findViewById(R.id.edtDui);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        edtEdad = (EditText) findViewById(R.id.edtEdad);
        edtUser = (EditText) findViewById(R.id.edtUserReg);
        edtPass = (EditText) findViewById(R.id.edtPassReg);

    }

    public void RegistrarUser(View v) {
        try {
            if (edtDui.getText().toString() != null && !edtDui.getText().toString().isEmpty()) {
                if (edtUser.getText().toString() != null && !edtUser.getText().toString().isEmpty()) {
                    if (edtPass.getText().toString() != null && !edtPass.getText().toString().isEmpty()) {

                        BD obj = new BD(this, "usuarios", null, 1);

                        SQLiteDatabase baseEstado = obj.getWritableDatabase();

                        String dui = edtDui.getText().toString();
                        String nombre = edtNombre.getText().toString();
                        String direccion = edtDireccion.getText().toString();
                        String edad = edtEdad.getText().toString();
                        String user = edtUser.getText().toString();
                        String pass = edtPass.getText().toString();

                        String sql = "insert into usuarios values ('" + dui+"','" + nombre  + "','" + direccion + "','" + edad
                                + "','" + user + "','" + pass  + "')";

                        baseEstado.execSQL(sql);
                        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();

                        edtDui.setText("");
                        edtNombre.setText("");
                        edtDireccion.setText("");
                        edtEdad.setText("");
                        edtUser.setText("");
                        edtPass.setText("");

                        Intent goMain = new Intent(this, MainActivity.class);
                        startActivityForResult(goMain, 1);

                    } else {
                        Toast.makeText(this, "Porfavor Ingrese Contraseña", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Porfavor Ingresar Usuario", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "Favor Ingresar Numero de Dui", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
