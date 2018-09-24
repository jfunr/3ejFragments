package com.jrubenfun.a3ejfragments.data;

import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract;

import com.jrubenfun.a3ejfragments.R;
import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public class Constructordata {
    private static final int likes=1;

    public ArrayList<Mascota> mascotas;

    public Context context;
    public Constructordata(Context context){
        this.context=context;

    }

    //*******************************************

    //method to get data from array

    public ArrayList<Mascota> getArray(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro1,"john","31"));
        mascotas.add(new Mascota(R.drawable.perro2,"happy","23"));
        mascotas.add(new Mascota(R.drawable.perro3,"ears","20"));
        mascotas.add(new Mascota(R.drawable.perro4,"furry","18"));
        mascotas.add(new Mascota(R.drawable.perro5,"black","15"));
        mascotas.add(new Mascota(R.drawable.perro6,"run","10"));

        return mascotas;
    }

    //*******************************************

    //method to use the database

    public ArrayList<Mascota> getData(){
        data sqLiteDatabase=new data(context);

        insertardosMascotas(sqLiteDatabase);

        return sqLiteDatabase.obtenerMascotas();
    }

    //**********************************************

    //method to fill the data with a couple of contacts

    private void insertardosMascotas(data sqLiteDatabase){

        ContentValues contentValues=new ContentValues();

        //1

        contentValues.put(constantes.tablaMacotaNombre,"john");
        contentValues.put(constantes.tablaMascotaFoto, R.drawable.perro1);

        sqLiteDatabase.insertarMascota(contentValues);

        //2

        contentValues=new ContentValues();

        contentValues.put(constantes.tablaMacotaNombre,"happy");
        contentValues.put(constantes.tablaMascotaFoto,R.drawable.perro2);

        sqLiteDatabase.insertarMascota(contentValues);

        //3

        contentValues=new ContentValues();

        contentValues.put(constantes.tablaMacotaNombre,"ears");
        contentValues.put(constantes.tablaMascotaFoto, R.drawable.perro3);

        sqLiteDatabase.insertarMascota(contentValues);

        //4

        contentValues=new ContentValues();

        contentValues.put(constantes.tablaMacotaNombre,"furry");
        contentValues.put(constantes.tablaMascotaFoto, R.drawable.perro4);

        sqLiteDatabase.insertarMascota(contentValues);

        //5

        contentValues=new ContentValues();

        contentValues.put(constantes.tablaMacotaNombre,"black");
        contentValues.put(constantes.tablaMascotaFoto, R.drawable.perro5);

        sqLiteDatabase.insertarMascota(contentValues);

        //6

        contentValues=new ContentValues();

        contentValues.put(constantes.tablaMacotaNombre,"run");
        contentValues.put(constantes.tablaMascotaFoto, R.drawable.perro6);

        sqLiteDatabase.insertarMascota(contentValues);

    }

    public void darlike(Mascota mascota){
        data db=new data(context);
        ContentValues contentValues=new ContentValues();
     //   ContentValues.put(constantes.tablalikeid_mascota,mascota.getId());
     //   ContentValues.put(constantes.tablalikeNumero,likes);
        db.insertarLike(contentValues);
    }

}







