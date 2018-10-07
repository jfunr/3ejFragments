package com.jrubenfun.a3ejfragments;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jrubenfun.a3ejfragments.data.Constructordata;
import com.jrubenfun.a3ejfragments.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    public ArrayList<Mascota> mascotas;
    Activity activity;
    private static final int likes = 1;


    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_detalle,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRate.setText(mascota.getRate());

        mascotaViewHolder.imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TextView tvRate = mascotaViewHolder.tvRate;

                int rateInt = Integer.parseInt(tvRate.getText().toString());

                rateInt++;


                tvRate.setText(Integer.toString(rateInt));
                mascota.setRate(Integer.toString(rateInt));



                /*
                Constructordata constructordata=new Constructordata(activity);
                constructordata.darLike(mascota);

                mascotaViewHolder.tvRate.setText(constructordata.obtenerLikes(mascota));
                */


            }
        });




    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
        private TextView tvNombre;
        private TextView tvRate;
        private ImageButton imgButton;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgMascota = itemView.findViewById(R.id.imgMascota);
            tvNombre   = itemView.findViewById(R.id.tvNombre);
            tvRate     = itemView.findViewById(R.id.tvRate);
            imgButton  = itemView.findViewById(R.id.imgButton);
        }
    }
}