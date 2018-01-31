package com.abisayuti.learnintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnImpli,btnExpli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExpli = (Button)findViewById(R.id.btnExplicit);
        btnImpli = (Button)findViewById(R.id.btnExplicit);


        btnImpli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnEX = new Intent(getApplicationContext(), ActivityExplicitIntent.class);
                startActivity(btnEX);
            }
        });

        btnExpli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnIMP = new Intent(getApplicationContext(), ActivityPutExtra.class);
                startActivity(btnIMP);
            }
        });
    }
}
