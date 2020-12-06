package com.example.a1818034_1818035_kelompok15_sqlitedaftarperlengkapannaikgunung;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sjumlah, Sharga;
    private EditText Enama, Ejumlah, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sjumlah = i.getStringExtra("Ijumlah");
        Sharga = i.getStringExtra("Iharga");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ejumlah = (EditText) findViewById(R.id.updel_jumlah);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enama.setText(Snama);
        Ejumlah.setText(Sjumlah);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjumlah = String.valueOf(Ejumlah.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "nama barang ",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjumlah.equals("")){
                    Ejumlah.requestFocus();
                    Toast.makeText(MainUpdel.this, "jumlah",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "jumlah",
                            Toast.LENGTH_SHORT).show();
                }else {
                    db.UpdatePerlengkapan(new Perlengkapan(Sid, Snama, Sjumlah, Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePerlengkapan(new Perlengkapan(Sid, Snama, Sjumlah, Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
