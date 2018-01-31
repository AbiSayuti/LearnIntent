package com.abisayuti.learnintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityPutExtra extends AppCompatActivity {

    EditText etnama;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_extra);

        btnSubmit = (Button)findViewById(R.id.btnSubmitNama);
        etnama = (EditText) findViewById(R.id.etIniputNama);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //string untuk mengambil nilai
                String nama = etnama.getText().toString();

                //intent ke kelas getExtra
                Intent nP = new Intent(getApplicationContext(), ActivityGetExtra.class);
                nP.putExtra("nama",nama);
                startActivity(nP);
            }
        });


    }
}
