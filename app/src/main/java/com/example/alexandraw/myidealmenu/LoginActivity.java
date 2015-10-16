package com.example.alexandraw.myidealmenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;//
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;

import java.text.ParseException;


// Se guarda el nombre del usuario y el login

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaracion de las llaves que almacenan la informacion
    //Son importantes porque puedo recuperarlas bajo ese nombre en el MainActivity

    //Para saber si estoy logueado o no que tenga cualquier texto

    public static final String KEY_LOGIN="login";

    //Para saber el nombre de usuario
    public static final String KEY_USER="user";

    //Un nombre para las preferencias
    public static final String PREFERENCE="preference";

    EditText usr, pass;
    String sUsr, sPass;
    Button in;
    TextView link;

    //Objetos para leer y escribir

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Parse.initialize(this, "oWuXpc5ahPda0W9eBntpFNW3Grk3wLwVgSJZzbyQ", "JmCInHZTQuiYtizQTPYVDk6qUZ6VQLq4585RNr6q");
        ParseAnalytics.trackAppOpened(getIntent());


        //Se recuperan los views
        usr = (EditText)findViewById(R.id.usr);
        pass = (EditText)findViewById(R.id.pass);
        in = (Button)findViewById(R.id.btnLog);
        link = (TextView)findViewById(R.id.linkReg);

        //Se implementa alt+enter el que dice make
        in.setOnClickListener(this);
        link.setOnClickListener(this);

        //En el onCreate obtengo los valores (Nombre y tipo)
        preferences = getSharedPreferences(PREFERENCE, MODE_PRIVATE);

        //A traves del preferences obtengo el editor
        editor = preferences.edit();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnLog:
                    //Cuando le de click e iniciar sesion se llena el editor que tiene
                    //un booleano con la llave login =  true
                    //editor.putBoolean(KEY_LOGIN, true);

                    //Se guarda de manera persistente y va a estar hasta que se desinstale  la app
                    //se va a guardar el nombre del usuario
                    //editor.putString(KEY_USER, usr.getText().toString());
                    //editor.commit();

                    //Se hace la navegacion al MainActivity, la navegacion entre
                    //pantallas se hace a traves de intents

                sUsr = usr.getText().toString();
                sPass = pass.getText().toString();

                ParseUser.logInInBackground(sUsr, sPass, new LogInCallback() {

                    @Override
                    public void done(ParseUser user, com.parse.ParseException e) {
                        if (user != null) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            // Hooray! The user is logged in.
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Error al iniciar sesion", Toast.LENGTH_SHORT);
                            toast.show();
                            // Signup failed. Look at the ParseException to see what happened.
                        }
                    }
                });


            break;

            case R.id.linkReg:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
