package com.jrubenfun.a3ejfragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TableLayout;

import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    ImageButton starButton;
    int indices[] = new int[5];
    ArrayList<Mascota> topFiveMascotas;
    String[] topNombres = new String[5];
    String[] topRates = new String[5];
    int topFoto[] = new int[5];

    public Toolbar toolbar;
    public TableLayout tableLayout;
    public ViewPager viewPager;

    RecyclerView listaTopFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        listaTopFive =  findViewById(R.id.rvTopFive);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaTopFive.setLayoutManager(llm);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            topNombres = parametros.getStringArray("TopNombres");
            topRates = parametros.getStringArray("TopRates");
            topFoto = parametros.getIntArray("TopFoto");
        }




        crearTopFive();

        inicializarMascotas();
        inicializarAdaptador();


    }


    public void crearTopFive(){

        topFiveMascotas = new ArrayList<>();

        for (int i=0;i<5;i++){
            //Log.v("Caso",topNombres[i]+" "+topRates[i]);

            topFiveMascotas.add(new Mascota(
                    topFoto[i],
                    topNombres[i],
                    topRates[i]));

        }
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


    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(topFiveMascotas,this);
        listaTopFive.setAdapter(adaptador);
    }

}
