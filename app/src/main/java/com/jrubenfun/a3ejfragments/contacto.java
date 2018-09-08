package com.jrubenfun.a3ejfragments;

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
                    Gmail sender=new Gmail("jfuntre@gmail.com","qastep19");
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

}

