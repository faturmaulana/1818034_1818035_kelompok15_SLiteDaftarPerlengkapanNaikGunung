package com.example.a1818034_1818035_kelompok15_sqlitedaftarperlengkapannaikgunung;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_Mendaki";
    private static final String tb_perlengkapan = "tb_perlengkapan";
    private static final String tb_perlengkapan_id = "id";
    private static final String tb_perlengkapan_nama = "nama";
    private static final String tb_perlengkapan_jumlah = "jumlah";
    private static final String tb_perlengkapan_harga = "harga";

    private static final String CREATE_TABLE_PERLENGKAPAN = "CREATE TABLE " +
            tb_perlengkapan + "("
            + tb_perlengkapan_id + " INTEGER PRIMARY KEY ,"
            + tb_perlengkapan_nama + " TEXT,"
            + tb_perlengkapan_jumlah + " TEXT,"
            + tb_perlengkapan_harga + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PERLENGKAPAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreatePerlengkapan (Perlengkapan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_perlengkapan_id, mdNotif.get_id());
        values.put(tb_perlengkapan_nama, mdNotif.get_nama());
        values.put(tb_perlengkapan_jumlah, mdNotif.get_jumlah());
        values.put(tb_perlengkapan_harga, mdNotif.get_harga());
        db.insert(tb_perlengkapan, null, values);
        db.close();
    }

    public List<Perlengkapan> ReadPerlengkapan() {
        List<Perlengkapan> judulModelList = new ArrayList<Perlengkapan>();
        String selectQuery = "SELECT * FROM " + tb_perlengkapan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Perlengkapan mdKontak = new Perlengkapan();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_jumlah(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdatePerlengkapan (Perlengkapan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_perlengkapan_nama, mdNotif.get_nama());
        values.put(tb_perlengkapan_jumlah, mdNotif.get_jumlah());
        values.put(tb_perlengkapan_harga, mdNotif.get_harga());
        return db.update(tb_perlengkapan, values, tb_perlengkapan_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeletePerlengkapan (Perlengkapan mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_perlengkapan, tb_perlengkapan_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
