package com.example.hppc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hppc.model.Plat;
import com.example.hppc.resto.R;

/**
 * Created by hppc on 25/06/2017.
 */

public class PlatAdapter extends BaseAdapter {
    Context _context;
    LayoutInflater _layout;
    Plat[] _plats;

    public PlatAdapter(Context c, Plat[] p){
        _context=c;
        _plats=p;
    }

    @Override
    public int getCount() {
        return _plats.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = _layout.inflate(R.layout.plat_layout,null);
        TextView genre = (TextView) view.findViewById(R.id.textView3);
        TextView des = (TextView) view.findViewById(R.id.textView2);
        TextView prix = (TextView) view.findViewById(R.id.textView);
        genre.setText(_plats[i].getGenre());
        des.setText(_plats[i].getDesignation());
        prix.setText(String.valueOf( _plats[i].getPrix()));

        return view;
    }
}
