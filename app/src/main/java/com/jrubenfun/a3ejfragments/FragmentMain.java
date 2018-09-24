package com.jrubenfun.a3ejfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jrubenfun.a3ejfragments.mvp.ipresenter;
import com.jrubenfun.a3ejfragments.mvp.rvFragmentPresenter;
import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public class FragmentMain extends Fragment implements iview {
//implements ipresenter
    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    ArrayList<Mascota> topFiveMascotas;

    private rvFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v=inflater.inflate(R.layout.fragment_main,container,false);

        listaMascotas =  v.findViewById(R.id.rvListaMascotas);

        presenter = new rvFragmentPresenter(this,getContext());

        /*
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        */

        //to delete

       // inicializarMascotas();
       // inicializarAdaptador();


        return v;

    }

    //
    public void inicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro1,"john","31"));
        mascotas.add(new Mascota(R.drawable.perro2,"happy","23"));
        mascotas.add(new Mascota(R.drawable.perro3,"ears","20"));
        mascotas.add(new Mascota(R.drawable.perro4,"furry","18"));
        mascotas.add(new Mascota(R.drawable.perro5,"black","15"));
        mascotas.add(new Mascota(R.drawable.perro6,"run","10"));
    }

    //************************************************

    //adaptador to generate the data-borrar mvp

    public void inicializarAdaptador(){
        //
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    //*************************************************

    //

    @Override
    public void generarLinearLayout() {
        //
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        //
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        //
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
        //return null;
    }

    @Override
    public void iniciarAdaptadorRV(MascotaAdaptador adaptador) {
        //
        listaMascotas.setAdapter(adaptador);
    }


}
