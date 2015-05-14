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

public class Arm extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm);
        setupEmergencybutton();

        Button pt = (Button) findViewById(R.id.pt);
        pt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getPackageManager();
                i = managerclock.getLaunchIntentForPackage("com.physio.pocket"); //
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_arm, menu);
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
        ImageButton emergencyButton= (ImageButton) findViewById(R.id.emergency_arm);
        emergencyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
// Log.i("Openarm", "The arm is activated");
                Toast.makeText(Arm.this, "Emergency!", Toast.LENGTH_LONG)
                        .show();
                ImageButton emergency = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), Emergency.class));
            }
        });
    }
}