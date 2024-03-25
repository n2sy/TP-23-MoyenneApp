package com.tp2.moyenneapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText val1;
    private EditText val2;
    private EditText val3;
    private TextView coeff1;
    private TextView coeff2;
    private TextView coeff3;
    //private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.note1);
        val2 = (EditText) findViewById(R.id.note2);
        val3 = (EditText) this.findViewById(R.id.note3);
        coeff1 = (TextView) this.findViewById(R.id.textView);
        coeff2 = (TextView) this.findViewById(R.id.textView2);
        coeff3 = (TextView) this.findViewById(R.id.textView3);
        //btn = (Button) findViewById(R.id.bcalcul);


    }


    public void calculerMoyenne(View v) {

        String ch1 = val1.getText().toString();
        String ch2 = val2.getText().toString();
        String ch3 = val3.getText().toString();

        if (ch1 == "" || ch2.equals("") || ch3.isEmpty()) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Attention! ");
            alertDialog.setMessage("Veuillez saisir les 3 notes pour calculer la moyenne!");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();
                }
            });
            alertDialog.show();

        } else {

            float num1 = Float.parseFloat(ch1);
            float num2 = Float.valueOf(ch2);
            float num3 = Float.valueOf(ch3);

            if (num1 < 0 || num1 > 20)
                val1.setError("Compris entre 0 et 20");
            else if (num2 < 0 || num2 > 20)
                val2.setError("Compris entre 0 et 20");
            else if (num3 < 0 || num3 > 20)
                val3.setError("Compris entre 0 et 20");
            else {
                int sommeCoeffs = Integer.parseInt(this.coeff1.getText().toString()) +
                        Integer.parseInt(this.coeff2.getText().toString()) + Integer.parseInt(this.coeff3.getText().toString());
                float moy = (num1 * Integer.parseInt(this.coeff1.getText().toString()) +
                        num2 * Integer.parseInt(this.coeff2.getText().toString()) +
                        num3 * Integer.parseInt(this.coeff3.getText().toString())) / sommeCoeffs;
                //String s = String.valueOf(moy);

                if (moy >= 10) {
                    Intent i = new Intent(MainActivity.this, SuccessActivity.class);
                    //String s = String.format("%.2f", moy);
                    i.putExtra("moyenne", moy);
                    startActivity(i);
                } else {
                    Intent i = new Intent(this, FailActivity.class);
                    i.putExtra("moyenne", moy);
                    startActivity(i);
                }

            }
        }


    }

}
