package com.jrubenfun.a3ejfragments;

import android.content.ContentValues;
import android.content.Context;

import com.jrubenfun.a3ejfragments.data.constantes;
import com.jrubenfun.a3ejfragments.data.data;
import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public class Constructor {

    private Context context;
    public Constructor(Context context){
        this.context=context;

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

    public void insertardosMascotas(data sqLiteDatabase){

        ContentValues contentValues=new ContentValues();


        contentValues.put(constantes.tablaMacotaNombre,"john");
        contentValues.put(constantes.tablaMascotaFoto,R.drawable.perro1);

        sqLiteDatabase.insertarMascota(contentValues);

        contentValues.put(constantes.tablaMacotaNombre,"happy");
        contentValues.put(constantes.tablaMascotaFoto,R.drawable.perro2);

        sqLiteDatabase.insertarMascota(contentValues);

    }

}
