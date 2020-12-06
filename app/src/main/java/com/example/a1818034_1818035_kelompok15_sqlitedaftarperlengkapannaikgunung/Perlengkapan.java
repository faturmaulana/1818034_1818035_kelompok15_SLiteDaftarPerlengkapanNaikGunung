package com.example.a1818034_1818035_kelompok15_sqlitedaftarperlengkapannaikgunung;

public class Perlengkapan {
    private String _id, _nama, _jumlah, _harga;
    public Perlengkapan (String id, String nama, String jumlah, String harga) {
        this._id = id;
        this._nama = nama;
        this._jumlah = jumlah;
        this._harga = harga;
    }
    public Perlengkapan() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_jumlah() {
        return _jumlah;
    }
    public void set_jumlah(String _jumlah) {
        this._jumlah = _jumlah;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }

}
