package com.example.a1818034_1818035_kelompok15_sqlitedaftarperlengkapannaikgunung;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Perlengkapan> movieItems;

    public CustomListAdapter(Activity activity, List<Perlengkapan> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView jumlah = (TextView) convertView.findViewById(R.id.text_jumlah);
        TextView harga = (TextView) convertView.findViewById(R.id.text_harga);
        Perlengkapan m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        jumlah.setText("Jumlah : "+ m.get_jumlah());
        harga.setText("Harga : "+ m.get_harga());
        return convertView;
    }
}
