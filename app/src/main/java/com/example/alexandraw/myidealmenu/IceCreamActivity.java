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

public class IceCreamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list4;
    TextView cream;
    String data[];

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_cream);

        list4 = (ListView) findViewById(R.id.list4);
        cream = (TextView) findViewById(R.id.cream);

        data = getResources().getStringArray(R.array.icecream);

        list4.setOnItemClickListener(this);

        adapter = new ArrayAdapter<String>(this, R.layout.template_item, R.id.categoriaName, data);

        list4.setAdapter(adapter);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cream.setText(data[position]);
    }
}
