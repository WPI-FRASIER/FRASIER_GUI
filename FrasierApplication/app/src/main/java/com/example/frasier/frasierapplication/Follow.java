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


public class Follow extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        //setupEmergencybutton();

//        Button armControl = (Button) findViewById(R.id.arm_controls);
//        armControl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Follow.this, "you clicked arm control", Toast.LENGTH_LONG)
//                        .show();
//                Button armControl = (Button) v;
//                startActivity(new Intent(getApplicationContext(), ArmControl.class));
//
//            }
//        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_follow, menu);
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

//    private void setupEmergencybutton() {
//        ImageButton emergencyButton= (ImageButton) findViewById(R.id.follow_emergency);
//        emergencyButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//// Log.i("Openarm", "The arm is activated");
//                Toast.makeText(Follow.this, "Emergency!", Toast.LENGTH_LONG)
//                        .show();
//                ImageButton emergency = (ImageButton) v;
//                startActivity(new Intent(getApplicationContext(), Emergency.class));
//            }
//        });
//    }
}
