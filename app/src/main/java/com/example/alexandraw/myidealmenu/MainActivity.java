package com.example.alexandraw.myidealmenu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alexandraw.myidealmenu.adapters.CategoryAdapter;
import com.example.alexandraw.myidealmenu.models.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button out;

    ListView list;
    TextView cate;
    //String data[];

    //bordes curveados
    //ArrayAdapter<String> adapter;


    List<Category> data;
    CategoryAdapter adapter;


    //Objetos para leer y escribir
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se recuperan los views
        cate = (TextView)findViewById(R.id.cate);
        out = (Button)findViewById(R.id.btn_logout);

        //Se implementa alt+enter el que dice make
        out.setOnClickListener(this);

        //Se definio el nombre en Login Activity
        // uso la constante a traves de su clase
        preferences = getSharedPreferences(LoginActivity.PREFERENCE, MODE_PRIVATE);
        editor = preferences.edit();

        //Cada que se tiene un valor se tiene dos argumentos
        //la llave y un valor por defecto en caso de que no exista
        //cate.setText(preferences.getString(LoginActivity.KEY_USER, ""));


        list  = (ListView) findViewById(R.id.list);
        cate  = (TextView) findViewById(R.id.cate);
        //data = getResources().getStringArray(R.array.categorias);

        list.setOnItemClickListener(this);
        //Adapter basico
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, data);

        //adapter con Template
        //adapter = new ArrayAdapter<String>(this, R.layout.template_item, R.id.categoriaName, data);

        data = new ArrayList<>();
        adapter = new CategoryAdapter(this,data);

        list.setAdapter(adapter);

        loadData();

    }

    private void loadData() {
        String category[] = getResources().getStringArray(R.array.categorias_completo);
        for(int i=0; i<category.length;i++){
            String categorys[] = category[i].split(",");
            Category c = new Category();
            c.setCategory(categorys[0]);
            c.setGenere(categorys[1]);
            c.setScore(Float.parseFloat(categorys[2]));
            c.setImgUrl(categorys[3]);

            data.add(c);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btn_logout:
        //Cuando presione el boton de cerrrar sesion se coloca el booleano de la
        //llave login= false
        editor.putBoolean(LoginActivity.KEY_LOGIN, false);
        editor.commit();

        //Cuando se cierra la sesion se debe abri la pantalla de registro
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
            break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //cate.setText(data[position]);
        cate.setText(data.get(position).getCategory());
    }

    //Hasta el momento funciona bien pero cada vez que se ejecuta
    //la app se abrira el registro, por eso creamos Root para que nos mande
    //para validar si entra al Main o al Login, el RootActivity puede cargar
    //distintas actividades es un Activity que no tiene Layout es solo la clase
}
