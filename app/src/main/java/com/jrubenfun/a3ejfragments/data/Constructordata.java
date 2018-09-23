package com.jrubenfun.a3ejfragments.data;

import android.content.ContentValues;
import android.content.Context;

import com.jrubenfun.a3ejfragments.R;
import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public class Constructordata {

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

        contentValues.put(constantes.tablaMacotaNombre,"john");
        contentValues.put(constantes.tablaMascotaFoto, R.drawable.perro1);

        sqLiteDatabase.insertarMascota(contentValues);

        contentValues.put(constantes.tablaMacotaNombre,"happy");
        contentValues.put(constantes.tablaMascotaFoto,R.drawable.perro2);

        sqLiteDatabase.insertarMascota(contentValues);

    }

}
