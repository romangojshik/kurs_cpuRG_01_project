package ru.startandroid.kurs_cpurg_01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import ru.startandroid.kurs_cpurg_01.ProcMeminfo.ProcMeminfoParser;
import ru.startandroid.kurs_cpurg_01.ProcMeminfo.ProcMeminfoProperty;

public class RAM extends AppCompatActivity {
    private static final String TAG = "myLogs2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram);

        TextView textView = (TextView)findViewById(R.id.textViewRam);

        HashMap<String, ProcMeminfoProperty> meminfoProperties = ProcMeminfoParser.parseProcMeminfo();

        //double totalMemory =   (meminfoProperties.get(ProcMeminfoProperty.MEM_TOTAL).getAmountCount())/(1024);
        //double freeMemory =   (meminfoProperties.get(ProcMeminfoProperty.MEM_FREE).getAmountCount())/(1024);

        textView.setText("Total memory: " + meminfoProperties.get(ProcMeminfoProperty.MEM_TOTAL).getAmountCount() + "kB" + "\n"
                        + "Free memory: " + meminfoProperties.get(ProcMeminfoProperty.MEM_FREE).getAmountCount() + "kB" + "\n"
                        + "Cached: " + meminfoProperties.get(ProcMeminfoProperty.CACHED).getAmountCount() + "kB" + "\n"
                        + "Active: " + meminfoProperties.get(ProcMeminfoProperty.ACTIVE).getAmountCount() + "kB" + "\n"
                        + "Active(anon): " + meminfoProperties.get(ProcMeminfoProperty.ACTIVE_ANON).getAmountCount() + "kB" + "\n"
                        + "SwapTotal : " + meminfoProperties.get(ProcMeminfoProperty.SWAP_TOTAL).getAmountCount() + "kB" + "\n"
                        + "SwapFree : " + meminfoProperties.get(ProcMeminfoProperty.SWAP_FREE).getAmountCount() + "kB" + "\n"
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

    public void getTotalMemory() {
        String procMemInfo = "/proc/meminfo";
        String temp;
        int readBlockSize = 8192;
        try {
            FileReader fileReader = new FileReader(procMemInfo);
            BufferedReader bufferedReader = new BufferedReader(fileReader, readBlockSize);
            while ((temp = bufferedReader.readLine()) != null) {
                Log.i(TAG, temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
