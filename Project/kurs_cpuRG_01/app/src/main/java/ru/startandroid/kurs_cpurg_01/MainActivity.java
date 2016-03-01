package ru.startandroid.kurs_cpurg_01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView phone = (ImageView) findViewById(R.id.imageViewPhone);
        phone.setOnClickListener((View.OnClickListener) this);

        ImageView cpu = (ImageView) findViewById(R.id.imageViewCpu);
        cpu.setOnClickListener((View.OnClickListener) this);

        ImageView ram = (ImageView) findViewById(R.id.imageViewRam);
        ram.setOnClickListener((View.OnClickListener) this);

        ImageView baterry = (ImageView) findViewById(R.id.imageViewBattery);
        baterry.setOnClickListener((View.OnClickListener) this);

        ImageView sim = (ImageView)findViewById(R.id.imageViewSim);
        sim.setOnClickListener((View.OnClickListener)this);

        ImageView android = (ImageView)findViewById(R.id.imageViewAndroid);
        android.setOnClickListener((View.OnClickListener)this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ru.startandroid.kurs_cpurg_01/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://ru.startandroid.kurs_cpurg_01/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageViewPhone:
                Intent intent0 = new Intent(this, Phone.class);
                startActivity(intent0);
                break;
            case R.id.imageViewCpu:
                Intent intent1 = new Intent(this, CPU.class);
                startActivity(intent1);
                break;
            case R.id.imageViewRam:
                Intent intent2 = new Intent(this, RAM.class);
                startActivity(intent2);
                break;
            case R.id.imageViewBattery:
                Intent intent3 = new Intent(this, Battery.class);
                startActivity(intent3);
                break;
            case R.id.imageViewSim:
                Intent intent4 = new Intent(this, Sim.class);
                startActivity(intent4);
                break;
            case R.id.imageViewAndroid:
                Intent intent5 = new Intent(this, Android.class);
                startActivity(intent5);
                break;
            default:
                break;
        }
    }
}
