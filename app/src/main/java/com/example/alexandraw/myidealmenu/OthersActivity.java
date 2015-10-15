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

public class OthersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list5;
    TextView otro;
    String data[];

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        list5 = (ListView) findViewById(R.id.list5);
        otro = (TextView) findViewById(R.id.otro);

        data = getResources().getStringArray(R.array.otros);

        list5.setOnItemClickListener(this);

        adapter = new ArrayAdapter<String>(this, R.layout.template_item, R.id.categoriaName, data);

        list5.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        otro.setText(data[position]);
    }
}
