package com.example.frasier.frasierapplication;

/**
 * Bluetooth capabilities adapted from RIVeR-LAB google_glass_driver
 * https://github.com/RIVeR-Lab/google_glass_driver/blob/master/android/RobotManager/src/com/riverlab/robotmanager/MainActivity.java
 */

import android.content.Intent;
import android.os.Handler;

import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import android.os.Looper;

import com.example.frasier.frasierapplication.bluetooth.ConnectedThread;
//import com.example.frasier.frasierapplication.bluetooth.ConnectedThread;

public class MainActivity extends ActionBarActivity {


    //Thread global variables
    private ConnectedThread mConnectedThread;
    //private VoiceRecognititionThread mVoiceThread;

    //Handler constants and definition
    public static final int CONNECTION_MESSAGE = 0;
    private static Looper threadLooper = null;

   // private Handler mHandler = null;

//    Looper.prepare();

    //This Handler handles messages sent from the ConnectedThread for received bluetooth messages

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case CONNECTION_MESSAGE:
                    String text = (String) msg.obj;
                    if (text.equals("connected")) {
                        System.out.println("connected");
                        Log.d("MainActivity", "MA connect");
                    } else if (text.equals("disconnected")) {
                        System.out.println("disconnected");
                    }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupCalendarButton();
        setupVitalsButton();
        setupFollowButton();
        setupArmButton();
        setupEmergencybutton();
        //setupVoice();
        setupGamesButton();
        //setupBluetooth();
/*
	 * This is from glass_google_driver adapted to not include voice activation,
	 * but kept for future reference.
	 */
//        speakButton = (Button) findViewById(R.id.voiceButton);
//        speakButton.setOnClickListener(this);
//        voiceinputbuttons();
//
//        startVoiceRecognitionActivity();

        // Check to see if a recognition activity is present
        // if running on AVD virtual device it will give this message. The mic
        // required only works on an actual android device
//        PackageManager pm = getPackageManager();
//        List activities = pm.queryIntentActivities(new Intent(
//                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
//        if (activities.size() != 0) {
//            speakButton.setOnClickListener(this);
//        } else {
//            speakButton.setEnabled(false);
//            speakButton.setText("Recognizer not present");
//        }

        //mApplication = ((FrasierApplication) this.getApplication());

        //Create and start the primary worker threads
        mConnectedThread = new ConnectedThread(mHandler);
        //mVoiceThread = new VoiceRecognitionThread(mApplication, this);

        mConnectedThread.setHandlers(mHandler);
        mConnectedThread.start();
        //mVoiceThread.start();


        Handler connectedHandler = mConnectedThread.getHandler();
        Message msg = connectedHandler.obtainMessage(ConnectedThread.CONNECT_MESSAGE, "parbot-Core-0"); //bluetooth address for tablet: '08:d4:2b:19:dd:ce'
        Log.d("ConnectTest", "ConnectTest1");
        connectedHandler.sendMessage(msg);


    }

    /*
	 * This function publishes a string over bluetooth when button is pressed
	 */
//    private void setupBluetooth() {
//
//        Button bluetoothButton = (Button) findViewById(R.id.bluetoothButton);
//        bluetoothButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "you clicked bluetooth", Toast.LENGTH_LONG)
//                        .show();
//                Handler connectedHandler = mConnectedThread.getHandler();
//                Message msg = connectedHandler.obtainMessage(ConnectedThread.WRITE_MESSAGE, "You pushed the button");
//                connectedHandler.sendMessage(msg);
//            }
//
//        });
//    }

    @Override
    protected void onResume() {
        super.onResume();
        //do not turn off screen
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        Handler connectedHandler = mConnectedThread.getHandler();

        Message msg = connectedHandler.obtainMessage(ConnectedThread.CONNECT_MESSAGE, "parbot-Core-0"); //bluetooth address for tablet: '08:d4:2b:19:dd:ce'
        Log.d("ConnectTest", "ConnectTest1");
        connectedHandler.sendMessage(msg);

//        msg = connectedHandler.obtainMessage(ConnectedThread.WRITE_MESSAGE, "Test");
//        Log.d("MessageTest", "Message1");
//        connectedHandler.sendMessage(msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
	 * This function starts the Calendar Activity
	 */
    private void setupCalendarButton() {
        ImageButton calendarButton = (ImageButton) findViewById(R.id.calendar);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "you clicked calendar", Toast.LENGTH_LONG)
                        .show();
                ImageButton calendar = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), com.example.frasier.frasierapplication.Calendar.class));

            }
        });
    }

    /*
         * This function shuts down the activity and kills the worker threads
         */
    public void shutdown() {
//Make sure all threads are done before shutting down
        //while (mApplication.getConnectedThreadHandler()); // != null && mApplication.getVoiceThreadHandler() != null);
        mConnectedThread.interrupt();
        //mVoiceThread.interrupt();
        mConnectedThread = null;
        //mVoiceThread = null;
        finish();
    }

    /*
	 * This function starts the Vitals Activity
	 */
    private void setupVitalsButton() {

        ImageButton vitalsButton = (ImageButton) findViewById(R.id.vitals);
        vitalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you clicked vitals", Toast.LENGTH_LONG)
                        .show();
                ImageButton vitals = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), Vitals.class));

            }
        });
    }

    /*
         * This function starts the Follow Activity
         */
    private void setupFollowButton() {
        ImageButton followButton = (ImageButton) findViewById(R.id.walk);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you clicked follow", Toast.LENGTH_LONG)
                        .show();
                ImageButton follow = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), Follow.class));
            }
        });
    }

    /*
         * This function starts the Arm Activity which is currently used for physical therapy
         */
    private void setupArmButton() {
        ImageButton armButton = (ImageButton) findViewById(R.id.excersise);
        armButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "you clicked Physical Activities", Toast.LENGTH_LONG)
                        .show();
                ImageButton arm = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), Arm.class));
            }
        });
    }

    /*
         * This function starts the Emergency Button Activity
         */
    private void setupEmergencybutton() {
        ImageButton emergencyButton = (ImageButton) findViewById(R.id.emergency);
        emergencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Emergency!", Toast.LENGTH_LONG)
                        .show();
                ImageButton emergency = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), Emergency.class));
            }
        });
    }

    /*
         * This function starts the Games Activity
         */
    private void setupGamesButton() {
        ImageButton gameButton = (ImageButton) findViewById(R.id.gamesButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "you clicked games", Toast.LENGTH_LONG)
                        .show();
                ImageButton gameButton = (ImageButton) v;
                startActivity(new Intent(getApplicationContext(), Games.class));

            }
        });

    }
    /*
         * This function starts the Voice Recognition Activity
         */
//    private void setupVoice() {
//        Button voiceButton = (Button) findViewById(R.id.voice);
//        voiceButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(MainActivity.this, "you clicked voice", Toast.LENGTH_LONG)
//                        .show();
//                Button voice = (Button) v;
//                startActivity(new Intent(getApplicationContext(), Voice.class));
//
//            }
//        });
//
//    }
}