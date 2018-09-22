package com.jrubenfun.a3ejfragments.mvp;

import android.content.Context;

import com.jrubenfun.a3ejfragments.MascotaAdaptador;
import com.jrubenfun.a3ejfragments.data.Constructordata;
import com.jrubenfun.a3ejfragments.iview;
import com.jrubenfun.a3ejfragments.pojo.Mascota;


import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class rvFragmentPresenter implements ipresenter {

    //ipresenter
    public iview iview;
    public Context context;
    public Constructordata constructordata;
    private ArrayList<Mascota> mascotas;

    public rvFragmentPresenter(iview iview, Context context){
        this.iview=iview;
        this.context=context;

        //getData();
        obetenerMascotasBaseDatos();
    }


    @Override
    public void obetenerMascotasBaseDatos() {
        constructordata=new Constructordata(context);
        mascotas =constructordata.getArray();
        //constructordata.getData();

        mostrarMascotaRV();

    }

    @Override
    public void mostrarMascotaRV() {
        iview.iniciarAdaptadorRV(iview.crearAdaptador(mascotas));

        iview.generarLinearLayout();

    }
}
