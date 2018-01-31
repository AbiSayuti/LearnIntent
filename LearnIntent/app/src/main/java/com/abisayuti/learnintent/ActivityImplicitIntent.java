package com.abisayuti.learnintent;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityImplicitIntent extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;

    String noTelp = "08238349182";

    //permission untuk sms
    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        btn1 = (Button)findViewById(R.id.btnCall);
        btn2 = (Button)findViewById(R.id.btnSMS);
        btn3 = (Button)findViewById(R.id.btnEmail);
        btn4 = (Button)findViewById(R.id.btnlink);


        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + noTelp));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dataIsiSMS = "Hallo , Ini adalah SMS";

                //android permission 6.0
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.SEND_SMS)
                            == PackageManager.PERMISSION_DENIED) {
                        Log.d("permission", "permission denied to SEND_SMS - requesting it");
                        String[] permissions = {Manifest.permission.SEND_SMS};

                        requestPermissions(permissions, PERMISSION_REQUEST_CODE);
                    }
                }

                Intent intent =  new Intent (getApplicationContext(), ActivityImplicitIntent.class);
                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),0, intent, 0);

                //memanggil library SMSManager dan memanggil string dataSMS
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(noTelp,null, dataIsiSMS, pi, null);

                Toast.makeText(getApplicationContext(), "SMS Berhasil dikirim", Toast.LENGTH_LONG).show();
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailTujuan = "abisa3002@gmail.com";
                String subjectTujuan = "Tet bro !";
                String isi = "isi nya apaan ya ?";

                //intent email
                Intent nEmail = new Intent(Intent.ACTION_SEND);
                nEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTujuan});
                nEmail.putExtra(Intent.EXTRA_SUBJECT,  subjectTujuan);
                nEmail.putExtra(Intent.EXTRA_TEMPLATE, isi);

                //format kode untuk pengiriman email
                nEmail.setType("message/rfc822");
                startActivity(Intent.createChooser(nEmail,"Pilih Email cliend"));

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memanggil url
                String urlWeb = "http://www.youtube.com";
                //memanggil urlWeb ketika di Intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                startActivity(intent);
            }
        });

    }
}
