package com.andrescordova;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
/**
 *
 * @author Andres Cordova <github.com/acordova200>
 */
public class MainActivity extends AppCompatActivity {

    EditText edtMiUsuario, edtMiClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMiUsuario = (EditText) findViewById(R.id.edtUserLog);
        edtMiClave = (EditText) findViewById(R.id.edtPassLog);


    }

    public void Entrar(View v) {

        try {
            BD obj = new BD(this, "usuarios", null, 1);

            SQLiteDatabase baseEstado = obj.getWritableDatabase();

            String usuarioDigitado = edtMiUsuario.getText().toString();
            String claveDigitada = edtMiClave.getText().toString();

            if (TextUtils.isEmpty(usuarioDigitado)) {

                Toast.makeText(this, getResources().getString(R.string.usuariovacio), Toast.LENGTH_SHORT).show();

                edtMiUsuario.setError(getResources().getString(R.string.usuariovacio));
                edtMiUsuario.requestFocus();

            } else if (TextUtils.isEmpty(claveDigitada)) {

                Toast.makeText(this, getResources().getString(R.string.clavevacia), Toast.LENGTH_SHORT).show();
                edtMiClave.setError(getResources().getString(R.string.clavevacia));
                edtMiClave.requestFocus();

            } else {
                boolean userBool = false;

                String sqlLog = "select * from usuarios where usuario = '" + usuarioDigitado + "' AND  pass = '" + claveDigitada + "'";

                Cursor datos = baseEstado.rawQuery(sqlLog, null);

                if(datos.moveToFirst()){
                    userBool = true;
                }

                if (userBool) {
                    Intent ScreenLogged = new Intent(this, ListaTelefonosaComprar.class);

                    Toast.makeText(this, getResources().getString(R.string.bienvenida), Toast.LENGTH_SHORT).show();

                    startActivityForResult(ScreenLogged, 1);

                } else {

                    Toast.makeText(this, getResources().getString(R.string.errorlogin), Toast.LENGTH_SHORT).show();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void Registrar(View v) {
        try {
            Intent goRegistrar = new Intent(this, Registrar.class);
            startActivityForResult(goRegistrar, 1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
