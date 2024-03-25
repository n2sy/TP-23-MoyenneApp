package com.tp2.moyenneapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SuccessActivity extends AppCompatActivity {
    private TextView tv;
    private String msg;
    private EditText numTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);


        numTel = (EditText) findViewById(R.id.numtel);
        tv = (TextView) findViewById(R.id.resultatReuMoy);
        Intent j = getIntent();

        float m = j.getFloatExtra("moyenne", 0);
        msg = getString(R.string.success, m);
        tv.setText(msg);



    }

    public void RetournerHome(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

 

    public void SendSMS(View v) {
        Intent i1 = new Intent();
        i1.setAction(Intent.ACTION_DIAL);
        i1.setData(Uri.parse("tel://12312312"));
        startActivity(i1);

        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);

        String numeroTelephone = this.numTel.getText().toString();
        Uri uri = Uri.parse("smsto:"+numeroTelephone);
        i.setData(uri);

        i.putExtra("sms_body", msg);
        startActivity(i);
    }
}