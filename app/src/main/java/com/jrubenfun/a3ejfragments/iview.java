package com.jrubenfun.a3ejfragments;

import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public interface iview {
    public void generarLinearLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void iniciarAdaptadorRV(MascotaAdaptador adaptador);
}
