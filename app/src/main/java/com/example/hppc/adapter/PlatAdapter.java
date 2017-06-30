package com.example.hppc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hppc.model.Plat;
import com.example.hppc.resto.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hppc on 25/06/2017.
 */

public class PlatAdapter extends BaseAdapter {
    Context _context;
    LayoutInflater _layout;
    List<Plat> _plats;
    protected LayoutInflater mInflater;

    public PlatAdapter(Context c, List<Plat> p){
        _context=c;
        _plats=p;
        mInflater = LayoutInflater.from(c);
    }

    static class ViewHolder {

        public ViewHolder(View v) {
            genre = (TextView) v.findViewById(R.id.genre);
            designation = (TextView) v.findViewById(R.id.designation);
            prix = (TextView) v.findViewById(R.id.prix);
            image = (ImageView) v.findViewById(R.id.plat_picture);
        }

        protected  TextView genre, designation,prix;
        protected ImageView image;
    }


    @Override
    public int getCount() {
        return _plats.size();
    }

    @Override
    public Plat getItem(int position) {
        return _plats.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.plat_layout, viewGroup, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.genre.setText("genre : "+getItem(position).getGenre());
        viewHolder.designation.setText("designation : "+getItem(position).getDesignation());
        viewHolder.prix.setText("prix : "+String.valueOf(getItem(position).getPrix())+" DH");
        Picasso.with(_context).load("https://d3cbihxaqsuq0s.cloudfront.net/images/19599487_xl.jpg").fit().centerCrop().into(viewHolder.image);


        return convertView;
    }
}
