package com.ood.malissa.mangostudy.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ibm.mobilefirstplatform.clientsdk.android.core.api.BMSClient;
import com.ood.malissa.mangostudy.R;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* try {
            //initialize SDK with IBM Bluemix application ID and route
            BMSClient.getInstance().initialize(this, "http://mango-study.mybluemix.net", "ec6f5695-c9cf-4725-a858-01f49c793dcf");
        }
        catch (MalformedURLException mue) {
            //this.setStatus("Unable to parse Application Route URL\n Please verify you have entered your Application Route and Id correctly and rebuild the app", false);
            //buttonText.setClickable(false);
        }*/
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
