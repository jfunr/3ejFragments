package com.jrubenfun.a3ejfragments.data;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

import static com.jrubenfun.a3ejfragments.data.constantes.tablaMascota;

public class data extends SQLiteOpenHelper {
    private Context context;
    private ArrayList<Mascota> mascotas;

    //*********************************

    //constructor method that create the db

    public data(Context context) {
        super(context, constantes.dataName, null, constantes.dataVersion);
        this.context = context;
    }

    //*************************************

    //method to create the query

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //query
        String queryTablaMascota="CREATE TABLE "+ tablaMascota+
                "("+
                constantes.tablaMascotaid      +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                constantes.tablaMascotaNombre    +" TEXT, "+

                constantes.tablaMascotaFoto    +" TEXT "+

                ")";


        sqLiteDatabase.execSQL(queryTablaMascota);

        String queryTablaLikes="CREATE TABLE "+constantes.tablalike+
                "("+
                constantes.tablalikeid         +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                constantes.tablalikeid_mascota +" INTEGER, "+
                constantes.tablalikeNumero     +" INTEGER, "+

                "FOREIGN KEY (" + constantes.tablalikeid_mascota  + ") " +

                "REFERENCES " + tablaMascota  + "(" + constantes.tablaMascotaid  + ")" +


                ")";



        sqLiteDatabase.execSQL(queryTablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + tablaMascota+"'");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '"+constantes.tablalike+"'");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerMascotas() {
       // mascotas = new ArrayList<>();
        ArrayList<Mascota> mascotas=new ArrayList<>();

        String query="SELECT * FROM "+ tablaMascota;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        //try (SQLiteDatabase sqLiteDatabase = this.getWritableDatabase()) {
        Cursor registro = sqLiteDatabase.rawQuery(query, null);


        while (registro.moveToNext()) {
                Mascota mascotaActual = new Mascota();

                //mascotaActual.setFoto();
                mascotaActual.setId(registro.getInt(0));

                mascotaActual.setFoto(registro.getInt(1));
                mascotaActual.setNombre(registro.getString(2));

                String queryLikes="SELECT COUNT("+constantes.tablalikeNumero+") as likes"+
                        " FROM " +constantes.tablalike+
                        " WHERE " + constantes.tablalikeid_mascota+"="+mascotaActual.getId();

                Cursor registrosLikes=sqLiteDatabase.rawQuery(queryLikes,null);
                if(registrosLikes.moveToNext()){
//rev
                    mascotaActual.setRate(registrosLikes.getString(0));

                }
                else{
                    mascotaActual.setRate("0");
                }

                mascotas.add(mascotaActual);


            }

        sqLiteDatabase.close();
        //}


        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.insert(constantes.tablaMascota,null,contentValues);
        sqLiteDatabase.close();
    }


    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.insert(constantes.tablalike,null,contentValues);
        sqLiteDatabase.close();
     }

    public int obtenerLikes(Mascota mascota){
        int likes=0;

        String query="SELECT COUNT("+constantes.tablalikeNumero+")"+
                " FROM "+constantes.tablalike+
                " WHERE "+constantes.tablalikeid_mascota+"="+ mascota.getId();

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        Cursor registros=sqLiteDatabase.rawQuery(query,null);

        if (registros.moveToNext()){

            likes=registros.getInt(0);
        }

        sqLiteDatabase.close();

        return likes;
    }

}













