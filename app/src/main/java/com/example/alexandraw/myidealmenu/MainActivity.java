package com.example.alexandraw.myidealmenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt;
    Button out;

    //Objetos para leer y escribir
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se inicializa parse
        //Parse.initialize(this, "oWuXpc5ahPda0W9eBntpFNW3Grk3wLwVgSJZzbyQ", "JmCInHZTQuiYtizQTPYVDk6qUZ6VQLq4585RNr6q");
       // ParseAnalytics.trackAppOpened(getIntent());


        //Se recuperan los views
        txt = (TextView)findViewById(R.id.txt);
        out = (Button)findViewById(R.id.btn_logout);

        //Se implementa alt+enter el que dice make
        out.setOnClickListener(this);

        //Se definio el nombre en Login Activity
        // uso la constante a traves de su clase
       // preferences = getSharedPreferences(LoginActivity.PREFERENCE, MODE_PRIVATE);
        //editor = preferences.edit();

        //Cada que se tiene un valor se tiene dos argumentos
        //la llave y un valor por defecto en caso de que no exista
        //txt.setText(preferences.getString(LoginActivity.KEY_USER, ""));
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        //switch(v.getId()){

          //  case R.id.btn_logout:
        //Cuando presione el boton de cerrrar sesion se coloca el booleano de la
        //llave login= false
        //editor.putBoolean(LoginActivity.KEY_LOGIN, false);
       // editor.commit();

               // ParseUser.logOut();
               // takemeToSingup();

            //break;


        //}
       // ParseUser cuser = ParseUser.getCurrentUser();

        //if(cuser==null){
           // takemeToSingup();
       // }
    }



    //Hasta el momento funciona bien pero cada vez que se ejecuta
    //la app se abrira el registro, por eso creamos Root para que nos mande
    //para validar si entra al Main o al Login, el RootActivity puede cargar
    //distintas actividades es un Activity que no tiene Layout es solo la clase
}
