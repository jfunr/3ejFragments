package com.jrubenfun.a3ejfragments.data;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public class data extends SQLiteOpenHelper {
    private Context context;
    ArrayList<Mascota> mascotas;

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
                constantes.tablalikeNumero    +" INTEGER, "+
                "FOREIGN KEY (" + constantes.tablalikeid  + ") " +
                "REFERENCES " + constantes.tablaMascota  + "(" + constantes.tablaMascotaid  + ")" +


                ")";



        sqLiteDatabase.execSQL(tablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS'"+constantes.tablaMascota+"'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS'"+constantes.tablaMascota+"'");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerContactos() {
        mascotas = new ArrayList<>();

        String query="SELECT * FROM'"+constantes.tablaMascota+"'";
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor registro= sqLiteDatabase.rawQuery(query,null);

        while (registro.moveToNext()){
            Mascota mascotaActual=new Mascota();

            mascotaActual.setNombre(registro.getString(0));
            mascotaActual.setRate(registro.getString(1));

            mascotas.add(mascotaActual);


        }

        sqLiteDatabase.close();

        return mascotas;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.insert(constantes.dataName,null,contentValues);
        sqLiteDatabase.close();
    }

}













