package com.andrescordova;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
/**
 *
 * @author Andres Cordova <github.com/acordova200>
 */
public class GamadeTelefonos extends ListActivity {

    String[] nombreGama;

    String tel;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle datos = getIntent().getExtras();
        tel = datos.getString("telefono");
        pos = datos.getInt("posicion");


        nombreGama = getResources().getStringArray(R.array.gama);

        ArrayAdapter<String> lista;
        lista = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, nombreGama);
        setListAdapter(lista);

    }

    @Override
    public void onListItemClick(ListView lista, View vista, int posicion, long id) {

        String gamaSelected = nombreGama[posicion].toString();

        Toast.makeText(this, "Gama Seleccionada = " + gamaSelected, Toast.LENGTH_SHORT).show();

        Intent Activity3 = new Intent(this, CompraRealizada.class);

        Activity3.putExtra("gama", gamaSelected);
        Activity3.putExtra("tel", tel);


        startActivityForResult(Activity3, 1);

        setResult(RESULT_OK, Activity3);


    }
}
