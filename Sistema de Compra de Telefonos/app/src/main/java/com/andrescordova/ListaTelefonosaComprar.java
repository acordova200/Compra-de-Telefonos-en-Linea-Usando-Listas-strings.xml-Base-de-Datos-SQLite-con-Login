package com.andrescordova;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
/**
 *
 * @author Andres Cordova <github.com/acordova200>
 */
public class ListaTelefonosaComprar extends ListActivity {

    String [] listaTelefonos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listaTelefonos = getResources().getStringArray(R.array.telefonos);

        ArrayAdapter<String> lista;
        lista = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,listaTelefonos);
        setListAdapter(lista);
    }
    @Override
    public void onListItemClick(ListView lista, View vista, int posicion, long id){

        String telSelected = listaTelefonos[posicion].toString();

        Toast.makeText(this, "Telefono Seleccionado= " +telSelected, Toast.LENGTH_SHORT).show();


        Intent Activity2 = new Intent(this,GamadeTelefonos.class);

        Activity2.putExtra("telefono",telSelected);
        Activity2.putExtra("posicion",posicion);

        startActivityForResult(Activity2,1);

        setResult(RESULT_OK,Activity2);


    }
}
