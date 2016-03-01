package ru.startandroid.kurs_cpurg_01;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Phone extends AppCompatActivity {

    DisplayMetrics metrics = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        TextView TextInfo = (TextView)findViewById(R.id.textViewPhone);

        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        TextInfo.setText("Version SDK of your device: " + Build.VERSION.SDK_INT + "\n"
                        + "Name version OS: " + Build.ID + "\n"
                        + "Device: " + Build.DEVICE + "\n"
                        + "Manufacturer: " + Build.MANUFACTURER + "\n"
                        + "Model: " + Build.MODEL + "\n"
                        + "Time: " + Build.TIME + "\n"
                        + "Density display dpi: " + metrics.densityDpi + "\n"
                        + "Display height: " + metrics.heightPixels + "\n"
                        + "Display weight: " + metrics.widthPixels + "\n"
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
