package com.example.a1818034_1818035_kelompok15_sqlitedaftarperlengkapannaikgunung;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Perlengkapan> ListPerlengkapan = new ArrayList<Perlengkapan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPerlengkapan );
        mListView = (ListView) findViewById(R.id.list_perlengkapan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPerlengkapan.clear();
        List<Perlengkapan> contacts = db.ReadPerlengkapan();
        for (Perlengkapan cn : contacts) {
            Perlengkapan judulModel = new Perlengkapan();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_jumlah(cn.get_jumlah());
            judulModel.set_harga(cn.get_harga());
            ListPerlengkapan.add(judulModel);
            if ((ListPerlengkapan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Perlengkapan obj_itemDetails = (Perlengkapan) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String S_jumlah = obj_itemDetails.get_jumlah();
        String S_harga = obj_itemDetails.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ijumlah", S_jumlah);
        goUpdel.putExtra("Iharga", S_harga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPerlengkapan.clear();
        mListView.setAdapter(adapter_off);
        List<Perlengkapan> contacts = db.ReadPerlengkapan();
        for (Perlengkapan cn : contacts) {
            Perlengkapan judulModel = new Perlengkapan();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_jumlah(cn.get_jumlah());
            judulModel.set_harga(cn.get_harga());
            ListPerlengkapan.add(judulModel);
            if ((ListPerlengkapan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
