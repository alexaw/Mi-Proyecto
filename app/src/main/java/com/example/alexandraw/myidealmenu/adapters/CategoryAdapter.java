package com.example.alexandraw.myidealmenu.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexandraw.myidealmenu.R;
import com.example.alexandraw.myidealmenu.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by RENATO on 12/10/2015.
 */
public class CategoryAdapter extends BaseAdapter {

    Context context;
    List<Category> data;

    public CategoryAdapter(Context context, List<Category> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    //retorna el numero de elementos
    public int getCount() {
        return data.size();
    }

    @Override
    //retorna el objeto de acuerdo a la posicion
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    //recuperamos de la base de datos
    public long getItemId(int position) {
        return position;
    }

    @Override
    //de acuerdo a una posicion le aplica el template y lo retorna
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;

        //garantizando que el inflate solo se haga una vez
        if(convertView == null){
            v = View.inflate(context, R.layout.template_category,null);
        }else {
            v = convertView;
        }

        //tengo el objeto en la posicion determinada
        //si ya tengo el objeto tengo acceso a los atributos
        //si tengo los atributos los coloco en el template
        Category c = (Category) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.tittleCate);
        txt.setText(c.getCategory());

        txt = (TextView) v.findViewById(R.id.txt_genere);
        txt.setText(c.getGenere());

        txt = (TextView) v.findViewById(R.id.txt_score);
        txt.setText(c.getScore()+"");

        ImageView imgcate = (ImageView) v.findViewById(R.id.imgcate);

        Picasso.with(context)
                .load(Uri.parse(c.getImgUrl()))
                .into(imgcate);


        return v;
    }
}
