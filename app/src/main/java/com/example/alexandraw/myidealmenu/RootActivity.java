package com.example.alexandraw.myidealmenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RootActivity extends AppCompatActivity {
    // Este Activity no tiene layout, es un activity temporario que lanza
    //activities se gun las variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //A traves del preferences sabemos si ya esta logeado o no, ya que la informacion
        //esta almacenada en la LLave
        SharedPreferences preferences = getSharedPreferences(LoginActivity.PREFERENCE, MODE_PRIVATE);
        //Se muestra el valor por defecto
        boolean login = preferences.getBoolean(LoginActivity.KEY_LOGIN, false);
        Intent intent = null;

        if(login)
            // si esta logueado va directamente al MainActivity
            intent = new Intent(this, MainActivity.class);
        else
            intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
    }


}
