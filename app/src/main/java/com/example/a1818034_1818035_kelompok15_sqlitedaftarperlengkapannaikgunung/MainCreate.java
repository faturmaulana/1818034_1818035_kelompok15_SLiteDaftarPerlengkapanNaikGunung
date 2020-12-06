package com.example.a1818034_1818035_kelompok15_sqlitedaftarperlengkapannaikgunung;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ejumlah, Eharga;
    private String Snama, Sjumlah, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ejumlah = (EditText) findViewById(R.id.create_jumlah);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjumlah = String.valueOf(Ejumlah.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "nama barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjumlah.equals("")){
                    Ejumlah.requestFocus();
                    Toast.makeText(MainCreate.this, "jumlah",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "harga",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ejumlah.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePerlengkapan(new Perlengkapan(null, Snama, Sjumlah, Sharga));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
