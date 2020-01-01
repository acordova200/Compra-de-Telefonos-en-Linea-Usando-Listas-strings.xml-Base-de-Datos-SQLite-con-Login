package com.andrescordova;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
/**
 *
 * @author Andres Cordova <github.com/acordova200>
 */
public class CompraRealizada extends AppCompatActivity {

    String telefono;
    String gama;
    TextView txtTel,txtGama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_realizada);

        txtTel = (TextView)findViewById(R.id.txtTelefono);
        txtGama = (TextView)findViewById(R.id.txtGama);


        Bundle datos = getIntent().getExtras();
        telefono = datos.getString("tel");
        gama = datos.getString("gama");


        txtTel.setText("Telefono: "+ telefono);
        txtGama.setText("Gama: "+ gama);
    }
}
