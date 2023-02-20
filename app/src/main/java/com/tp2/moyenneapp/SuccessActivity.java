package com.tp2.moyenneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SuccessActivity extends AppCompatActivity {
    private TextView tv;
    //private Button btn_back;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        //btn_back = (Button) findViewById(R.id.Back);

        tv = (TextView) findViewById(R.id.resultatReuMoy);
        Intent j = getIntent();

        float m = j.getFloatExtra("moyenne", 0);

      //  String msg = "Félicitations, vous avez réussi avec une moyenne de " + m;
         msg = getString(R.string.success, m);
        //Toast.makeText(getApplicationContext(), "moyenne " + m, Toast.LENGTH_SHORT).show();

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


        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        Uri uri = Uri.parse("smsto:98123456");
        i.setData(uri);

        i.putExtra("sms_body", msg);
        startActivity(i);
    }
}