package com.example.alexandraw.myidealmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alexandraw.myidealmenu.R;

public class DrinksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list3;
    TextView drink;
    String data[];

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        list3 = (ListView) findViewById(R.id.list3);
        drink = (TextView) findViewById(R.id.drink);

        data = getResources().getStringArray(R.array.drinks);

        list3.setOnItemClickListener(this);

        adapter = new ArrayAdapter<String>(this, R.layout.template_item, R.id.categoriaName, data);

        list3.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        drink.setText(data[position]);
    }


}
