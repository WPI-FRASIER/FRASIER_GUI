package com.example.frasier.frasierapplication;

/**
 * Created by frasier on 3/4/15.
 */
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Calendar extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        openCalendarButton();
        setupNewCalendarEventButton();
        setupEmergencybutton();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
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

    private void setupNewCalendarEventButton() {
//        ImageButton calendarButton = (ImageButton) findViewById(R.id.calendar);
//        calendarButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//// Log.i("OpenCal", "Here is your calendar");
//                Toast.makeText(Calendar.this, "you clicked calendar", Toast.LENGTH_LONG)
//                        .show();
                //ImageButton calendar = (ImageButton) v;
                Button newcalevent =(Button)findViewById(R.id.newcalevent);
                newcalevent.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //startActivity(new Intent(getApplicationContext(), Calendar.class));
                        //taken from: http://stackoverflow.com/questions/3721963/how-to-add-calendar-events-in-android
                        java.util.Calendar cal = java.util.Calendar.getInstance();
                        Intent intent = new Intent(Intent.ACTION_EDIT);
                        intent.setType("vnd.android.cursor.item/event");
                        intent.putExtra("beginTime", cal.getTimeInMillis());
                        intent.putExtra("allDay", true);
                        intent.putExtra("rrule", "FREQ=YEARLY");
                        intent.putExtra("endTime", cal.getTimeInMillis() + 60 * 60 * 1000);
                        intent.putExtra("title", "New Event");
                        startActivity(intent);
                    }
            });
    }


    private void openCalendarButton() {
        Button opencal = (Button) findViewById(R.id.opencal);
        opencal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button opencal = (Button) findViewById(R.id.opencal);
                opencal.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_MAIN);
                        PackageManager managerclock = getPackageManager();
                        i = managerclock.getLaunchIntentForPackage("com.google.android.calendar"); //
                        i.addCategory(Intent.CATEGORY_LAUNCHER);
                        startActivity(i);
                    }
                });
            }
        });
    }
    private void setupEmergencybutton() {
        ImageButton emergencyButton= (ImageButton) findViewById(R.id.calendar_emergency);
        emergencyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
// Log.i("Openarm", "The arm is activated");
                Toast.makeText(Calendar.this, "Emergency!", Toast.LENGTH_LONG)
                        .show();
                ImageButton emergency = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), Emergency.class));
            }
        });
    }
}