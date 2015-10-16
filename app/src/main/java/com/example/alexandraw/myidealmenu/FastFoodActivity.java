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

public class FastFoodActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list2;
    TextView fast;
    String data[];

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_food);

        list2 = (ListView) findViewById(R.id.list2);
        fast = (TextView) findViewById(R.id.fast);

        data = getResources().getStringArray(R.array.fastfood);

        list2.setOnItemClickListener(this);

        //adapter basico
        //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        //adapter con template
        adapter = new ArrayAdapter<String>(this, R.layout.template_item, R.id.categoriaName, data);

        list2.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fast.setText(data[position]);
    }




}
