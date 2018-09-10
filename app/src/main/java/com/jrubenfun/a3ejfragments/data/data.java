package com.jrubenfun.a3ejfragments.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class data extends SQLiteOpenHelper {
    private Context context;

    //*********************************

    //constructor

    public data(Context context) {
        super(context, constantes.dataName, null, constantes.dataVersion);
        this.context = context;
    }

    //*************************************

    //create structure for the data

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String tablaMascota="CREATE TABLE "+constantes.tablaMascota+
                "("+
                constantes.tablaMascotaid       +" PRIMARY KEY AUTOINCREMENT, "+
                constantes.tablaMacotaNombre    +" TEXT "+


                ")";


        sqLiteDatabase.execSQL(tablaMascota);

        String tablaLikes="CREATE TABLE "+constantes.tablalike+
                "("+
                constantes.tablalikeid       +" PRIMARY KEY AUTOINCREMENT, "+
                constantes.tablalikeNombre    +" TEXT, "+
                constantes.tablalikeNumero    +" NUMBER "+


                ")";



        sqLiteDatabase.execSQL(tablaLikes);

    }
}
