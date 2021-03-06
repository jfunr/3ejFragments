package com.jrubenfun.a3ejfragments.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import com.jrubenfun.a3ejfragments.MascotaAdaptador;
import com.jrubenfun.a3ejfragments.R;
import com.jrubenfun.a3ejfragments.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * to handle interaction events.
 *
 * create an instance of this fragment.
 */
public class FragmentGrid extends Fragment {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v2=inflater.inflate(R.layout.fragment_grid,container,false);

        listaMascotas = v2.findViewById(R.id.rvListaMascotasgrid);

        listaMascotas.setHasFixedSize(true);

        int numberOfColumns = 2;

        GridLayoutManager glm = new GridLayoutManager(getActivity(),numberOfColumns);

        listaMascotas.setLayoutManager(glm);


        inicializarMascotas();
        inicializarAdaptador2();

    return v2;

     }

    public void inicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro1,"john","1"));
        mascotas.add(new Mascota(R.drawable.perro2,"happy","1"));
        mascotas.add(new Mascota(R.drawable.perro3,"ears","1"));
        mascotas.add(new Mascota(R.drawable.perro4,"furry","1"));
        mascotas.add(new Mascota(R.drawable.perro5,"black","1"));
        mascotas.add(new Mascota(R.drawable.perro6,"run","1"));
    }

    public void inicializarAdaptador2(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        //MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, (View.OnClickListener) getActivity());
        listaMascotas.setAdapter(adaptador);
    }
}























