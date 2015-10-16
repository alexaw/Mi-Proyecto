package com.example.alexandraw.myidealmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Secundario extends AppCompatActivity {

    TextView lblmensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);
        lblmensaje = (TextView) findViewById(R.id.lblmensaje);
        Bundle parametros = getIntent().getExtras();
        if (parametros != null)
        {
            lblmensaje.setText(parametros.getString("Mes"));
        }

    }


}
