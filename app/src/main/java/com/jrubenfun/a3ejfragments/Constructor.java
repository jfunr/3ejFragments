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

    public ArrayList<Mascota> getData(){
        data sqLiteDatabase=new data(context);

        insertarContactos(sqLiteDatabase);

        return sqLiteDatabase.obtenerContactos();
    }

    public void insertarContactos(data sqLiteDatabase){

        ContentValues contentValues=new ContentValues();
        contentValues.put(constantes.tablaMacotaNombre,"perro1");
        contentValues.put(constantes.tablaMascotaid,"1");

        sqLiteDatabase.insertarContacto(contentValues);

    }

}
