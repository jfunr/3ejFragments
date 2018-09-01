package com.jrubenfun.a3ejfragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class contacto extends AppCompatActivity {

    String correo;

    EditText mensaje;

    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        mensaje=(EditText) findViewById(R.id.mAcerca);
        enviar=(Button) findViewById(R.id.bt_launch_activity);

        correo="";

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

}
