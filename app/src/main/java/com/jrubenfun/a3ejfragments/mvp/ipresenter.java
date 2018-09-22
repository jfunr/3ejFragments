package com.jrubenfun.a3ejfragments.mvp;

import com.jrubenfun.a3ejfragments.MascotaAdaptador;
import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public interface ipresenter {
    public void generarLinearLayout();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void iniciarAdaptadorRV(MascotaAdaptador adaptador);
}
