package com.andrescordova;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
/**
 *
 * @author Andres Cordova <github.com/acordova200>
 */
public class BD extends SQLiteOpenHelper {


    public BD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(dui text primary key,nombre text,direccion text, edad integer,usuario text,pass text)");

        db.execSQL("insert into usuarios values ('2312323-2','Andres Cordova' , 'San Salvador','30','abc','abc')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
