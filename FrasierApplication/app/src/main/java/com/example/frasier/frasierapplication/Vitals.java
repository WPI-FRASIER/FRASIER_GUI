package com.example.frasier.frasierapplication;

/**
 * Created by frasier on 3/4/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Vitals extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals);
        setupEmergencybutton();

        //taken from: http://stackoverflow.com/questions/4644666/how-to-make-a-button-open-another-app-with-java-android
         Button heart = (Button) findViewById(R.id.heartrate);
            heart.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_MAIN);
                    PackageManager managerclock = getPackageManager();
                    i = managerclock.getLaunchIntentForPackage("si.modula.android.instantheartrate"); //
                    i.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(i);
                }
            });
        Button myheart = (Button) findViewById(R.id.myheart);
        myheart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getPackageManager();
                i = managerclock.getLaunchIntentForPackage("com.szyk.myheart"); //
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
            }
        });

        }
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vitals, menu);
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
    private void setupEmergencybutton() {
        ImageButton emergencyButton= (ImageButton) findViewById(R.id.emergency_vitals);
        emergencyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
// Log.i("Openarm", "The arm is activated");
                Toast.makeText(Vitals.this, "Emergency!", Toast.LENGTH_LONG)
                        .show();
                ImageButton emergency = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), Emergency.class));
            }
        });
    }

}