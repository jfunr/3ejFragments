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
    private ArrayList<Mascota> mascotas;

    //*********************************

    //constructor method that crate the db

    public data(Context context) {
        super(context, constantes.dataName, null, constantes.dataVersion);
        this.context = context;
    }

    //*************************************

    //method to create the query

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //query
        String tablaMascota="CREATE TABLE "+constantes.tablaMascota+
                "("+
                constantes.tablaMascotaid      +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                constantes.tablaMascotaFoto    +" TEXT, "+

                constantes.tablaMacotaNombre    +" TEXT "+

                ")";


        sqLiteDatabase.execSQL(tablaMascota);

        String tablaLikes="CREATE TABLE "+constantes.tablalike+
                "("+
                constantes.tablalikeid         +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                constantes.tablalikeid_mascota +" TEXT, "+
                constantes.tablalikeNumero     +" INTEGER, "+

                "FOREIGN KEY (" + constantes.tablalikeid_mascota  + ") " +
                "REFERENCES " + constantes.tablaMascota  + "(" + constantes.tablaMascotaid  + ")" +


                ")";



        sqLiteDatabase.execSQL(tablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" +constantes.tablaMascota+"'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '"+constantes.tablalike+"'");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerMascotas() {
       // mascotas = new ArrayList<>();
        ArrayList<Mascota> mascotas=new ArrayList<>();



        String query="SELECT * FROM "+constantes.tablaMascota;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        //try (SQLiteDatabase sqLiteDatabase = this.getWritableDatabase()) {
            Cursor registro = sqLiteDatabase.rawQuery(query, null);


            while (registro.moveToNext()) {
                Mascota mascotaActual = new Mascota();

                //mascotaActual.setFoto();
                //mascotaActual.setId(registro.getInt(0));

                mascotaActual.setFoto(registro.getInt(1));
                mascotaActual.setNombre(registro.getString(2));
                mascotaActual.setRate(registro.getString(3));


                mascotas.add(mascotaActual);


            }

            sqLiteDatabase.close();
        //}


        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.insert(constantes.dataName,null,contentValues);
        sqLiteDatabase.close();
    }

    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.insert(constantes.tablalike,null,contentValues);
        sqLiteDatabase.close();


    }

}













