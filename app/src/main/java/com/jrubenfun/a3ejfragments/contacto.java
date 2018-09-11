package com.jrubenfun.a3ejfragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInstaller;
import android.net.MailTo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.security.Security;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class contacto extends AppCompatActivity {


    private EditText nombre;
    private EditText correo;
    private EditText mensaje;

    private String mensaje1;
    private String mailPet;
    private String passPet;

    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Button enviar=this.findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    Gmail sender=new Gmail("jfuntre@gmail.com","nan");
                    sender.sendMail("Ne","nan","jfuntre@gmail.com","dariifly@ymail.com");
                    Toast.makeText(contacto.this, "El mensaje se ha enviado...", Toast.LENGTH_LONG).show();

                }
                catch (Exception e)
                {

                    Log.e("SendMail",e.getMessage(),e);
                    //Toast.makeText(contacto.this, "Algo salio mal", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


    //****************************************************************

    //este metodo genera el archivo


    public void generarArchivo(View view)
    {
        try
        {
            EditText nombre=(EditText) findViewById(R.id.maname);
            String nombre1=nombre.getText().toString();

            EditText email=(EditText) findViewById(R.id.maemail);
            String email1=email.getText().toString();

            EditText descripcion=(EditText) findViewById(R.id.madescripcion);
            String descripcion1=descripcion.getText().toString();

            String comma=",";

            FileOutputStream outputStream=null;

            outputStream=openFileOutput("data.txt", Context.MODE_APPEND);
            outputStream.write(nombre1.getBytes());

            outputStream.write(comma.getBytes());

            outputStream.write(email1.getBytes());

            outputStream.write(comma.getBytes());

            outputStream.write(descripcion1.getBytes());

            outputStream.write(comma.getBytes());

            Toast.makeText(contacto.this, "El archivo se ha creado", Toast.LENGTH_LONG).show();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(contacto.this, "Algo fallo", Toast.LENGTH_LONG).show();

        }

    }



}

