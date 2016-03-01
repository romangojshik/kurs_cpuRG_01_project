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

import ru.startandroid.kurs_cpurg_01.ProcCpuInfo.ProcCpuInfoParser;
import ru.startandroid.kurs_cpurg_01.ProcCpuInfo.ProcCpuinfoProperty;

public class CPU extends AppCompatActivity {

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpu);

        TextView textView = (TextView)findViewById(R.id.textViewCpu);

        HashMap<String, ProcCpuinfoProperty> meminfoProperties = ProcCpuInfoParser.parseProcCpuinfo();

        textView.setText("Processor: " + meminfoProperties.get(ProcCpuinfoProperty.PROCESSOR).getValue() + "\n"
                + "Features: " + meminfoProperties.get(ProcCpuinfoProperty.FEATURES).getValue() + "\n"
                + "BogoMIPS: " + meminfoProperties.get(ProcCpuinfoProperty.BOGO_MIPS).getValue() + "\n"
                + "CPU implementer: " + meminfoProperties.get(ProcCpuinfoProperty.CPU_IMPLEMENTER).getValue() + "\n"
                + "CPU architecture: " + meminfoProperties.get(ProcCpuinfoProperty.CPU_ARCHITECTURE).getValue() + "\n"
                + "CPU variant: " + meminfoProperties.get(ProcCpuinfoProperty.CPU_VARIANT).getValue() + "\n"
                + "CPU part: " + meminfoProperties.get(ProcCpuinfoProperty.CPU_PART).getValue() + "\n"
                + "CPU revision: " + meminfoProperties.get(ProcCpuinfoProperty.CPU_REVISION).getValue() + "\n"
                + "Hardware: " + meminfoProperties.get(ProcCpuinfoProperty.HARDWARE).getValue() + "\n"
                + "Sereal: " + meminfoProperties.get(ProcCpuinfoProperty.SERIAL).getValue() + "\n"
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
