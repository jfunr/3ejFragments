package com.jrubenfun.a3ejfragments;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TableLayout;

import com.jrubenfun.a3ejfragments.mvp.FragmentGrid;
import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    ImageButton starButton;
    int indices[] = new int[5];
    ArrayList<Mascota> topFiveMascotas;
    String[] topNombres = new String[5];
    String[] topRates = new String[5];
    int topFoto[] = new int[5];

    public Toolbar toolbar;


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager =  findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        TabLayout tabLayout =  findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /******************************************
         *
         */



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch (id)
        {
            case R.id.mContacto:
                Intent intent=new Intent(this,contacto.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                Intent intent1=new Intent(this,acerca.class);
                startActivity(intent1);

                break;

        }


        return super.onOptionsItemSelected(item);
    }



    /****************************************************************************
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position)
            {
                case 0:


                    FragmentMain tab1=new FragmentMain();
                    return tab1;

                    //PlaceholderFragment
                case 1:


                    FragmentGrid tab2=new FragmentGrid();
                    return tab2;

            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }
    }

    public void crearTopFive(){
        ArrayList<Mascota> topFiveMascotas = new ArrayList<Mascota>();

        for (int i=0;i<indices.length;i++){

            topFoto[i] = mascotas.get(indices[i]).getFoto();
            topNombres[i]= mascotas.get(indices[i]).getNombre();
            topRates[i]= mascotas.get(indices[i]).getRate();

        }
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro1,"john","31"));
        mascotas.add(new Mascota(R.drawable.perro2,"happy","25"));
        mascotas.add(new Mascota(R.drawable.perro3,"ears","19"));
        mascotas.add(new Mascota(R.drawable.perro4,"furry","18"));
        mascotas.add(new Mascota(R.drawable.perro5,"black","15"));
        mascotas.add(new Mascota(R.drawable.perro6,"run","2"));
    }

    public void topCinco(int[] rates){

        int i;
        int max = 0;
        int indiceAux;
        for (int j=0; j<5; j++){
            max = rates[0];
            indiceAux = 0;
            for (i =1; i<rates.length; i++){
                if (max< rates[i]){
                    max=rates[i];
                    indiceAux=i;
                }
            }
            indices[j]=indiceAux;
            rates[indiceAux]=Integer.MIN_VALUE;
        }
    }


    public void starButton(View view) {
        inicializarMascotas();
        starButton =  findViewById(R.id.starButton);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rates[] = new int[mascotas.size()];

                for (int i=0; i<rates.length;i++){
                    rates[i]=Integer.parseInt(mascotas.get(i).getRate());
                }

                topCinco(rates);
                crearTopFive();

                Intent intent = new Intent(MainActivity.this,ListaMascotas.class);
                intent.putExtra("TopNombres",topNombres);
                intent.putExtra("TopRates",  topRates);
                intent.putExtra("TopFoto",   topFoto);
                startActivity(intent);

            }
        });

    }

}