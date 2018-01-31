package com.abisayuti.learnintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityGetExtra extends AppCompatActivity {

    TextView txtNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_extra);

        txtNama = (TextView) findViewById(R.id.txtbyAbi);

        Intent a1 = getIntent();
        //mengambil data yang sudh di deklarasi ke dalam variable nama
        String ambilnama = a1.getStringExtra("nama");

        //menampilkan nilai ke text view
        txtNama.setText("Hy, kamu pasti " + ambilnama + ". salam kenal ya :-)");
    }
}
