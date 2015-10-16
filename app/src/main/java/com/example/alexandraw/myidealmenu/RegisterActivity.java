package com.example.alexandraw.myidealmenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name, lastname, numId, usr, pass;
    String sName, sLastname, sNumId, sUsr,sPass;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Parse.initialize(this, "oWuXpc5ahPda0W9eBntpFNW3Grk3wLwVgSJZzbyQ", "JmCInHZTQuiYtizQTPYVDk6qUZ6VQLq4585RNr6q");
        ParseAnalytics.trackAppOpened(getIntent());

        name = (EditText)findViewById(R.id.name);
        lastname = (EditText)findViewById(R.id.lastname);
        numId = (EditText)findViewById(R.id.numId);
        usr = (EditText)findViewById(R.id.usr);
        pass = (EditText)findViewById(R.id.pass);

        reg = (Button)findViewById(R.id.btnReg);

        reg.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnReg:

                //editor.putBoolean(KEY_REG, true);
                sName=name.getText().toString();
                sLastname=lastname.getText().toString();
                sNumId=numId.getText().toString();
                sUsr=usr.getText().toString();
                sPass=pass.getText().toString();

                //editor.commit();

                ParseUser user = new ParseUser();
                //put para guardarlo en un nuevo objeto
                user.put("Name", sName);
                user.put("Lastname", sLastname);
                user.put("Ident", sNumId);
                user.setUsername(sUsr);
                user.setPassword(sPass);
                //Guarda los datos permanentemente
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(),"Registro fallido", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                });



        }
    }
}
