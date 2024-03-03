package com.tp2.moyenneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FailActivity extends AppCompatActivity {
    private TextView tv;
    //private Button btn_back;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        //btn_back = (Button) findViewById(R.id.Back);


        tv = (TextView) findViewById(R.id.resultatReuMoy);
        Intent j = getIntent();

        float m = j.getFloatExtra("moyenne", 0);
        msg = getString(R.string.fail, m);
        tv.setText(msg);


    }


    public void SendSMS(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        Uri uri = Uri.parse("smsto:98123456");
        i.setData(uri);
        i.putExtra("sms_body", msg);
        startActivity(i);
    }
}