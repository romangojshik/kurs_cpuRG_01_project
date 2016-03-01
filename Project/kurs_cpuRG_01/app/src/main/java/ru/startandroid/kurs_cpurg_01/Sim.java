package ru.startandroid.kurs_cpurg_01;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

public class Sim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);

        TextView textView = (TextView)findViewById(R.id.textViewSim);
        String operatorName = telephonyManager.getNetworkOperatorName();
        String Contry = telephonyManager.getNetworkCountryIso();
        String operatorCode = telephonyManager.getSimOperator();
        String codeCotry = telephonyManager.getSimCountryIso();

        textView.setText(//"Phone type: " + phoneType + "\n"
                //"Connection type: " + connectionType + "\n"
                //"Device IMEI: " + deviceIMEI + "\n"
                "Operator's name: " + operatorName + "\n"
                + "Contry: " + Contry + "\n"
                + "Operator code(ISO): " + operatorCode + "\n"
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
