//package com.example.frasier.frasierapplication;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.os.Message;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.Toast;
//
//import java.util.logging.Handler;
//
///**
// * Created by tr on 4/21/15.
// */
//public class ArmControl extends Activity{
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_armcontrol);
//        setupEmergencybutton();
//        armPose1();
//        armPose2();
//        armPose3();
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//    /*
//        * This function publishes a string over bluetooth when button pose 1 is pressed
//        */
//    private void armPose1() {
//
//        Button pose_one =(Button)findViewById(R.id.pose1);
//        pose_one.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ArmControl.this, "you clicked Pose1", Toast.LENGTH_LONG)
//                        .show();
////                Handler connectedHandler = mConnectedThread.getHandler();
////                Message msg = connectedHandler.obtainMessage(ConnectedThread.WRITE_MESSAGE, "You pushed Pose1");
////                connectedHandler.sendMessage(msg);
//            }
//        });
//    }
//
//
//    /*
//        * This function publishes a string over bluetooth when button pose 2 is pressed
//        */
//    private void armPose2() {
//
//        Button pose_two =(Button)findViewById(R.id.pose2);
//        pose_two.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ArmControl.this, "you clicked Pose2", Toast.LENGTH_LONG)
//                        .show();
////                Handler connectedHandler = mConnectedThread.getHandler();
////                Message msg = connectedHandler.obtainMessage(ConnectedThread.WRITE_MESSAGE, "You pushed Pose2");
////                connectedHandler.sendMessage(msg);
//            }
//        });
//    }
//
//
//    /*
//          * This function publishes a string over bluetooth when button pose 3 is pressed
//          */
//    private void armPose3() {
//
//        Button pose_three =(Button)findViewById(R.id.pose3);
//        pose_three.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ArmControl.this, "you clicked Pose3", Toast.LENGTH_LONG)
//                        .show();
////                Handler connectedHandler = mConnectedThread.getHandler();
////                Message msg = connectedHandler.obtainMessage(ConnectedThread.WRITE_MESSAGE, "You pushed Pose3");
////                connectedHandler.sendMessage(msg);
//            }
//        });
//    }
//
//
//    private void setupEmergencybutton() {
//        ImageButton emergencyButton= (ImageButton) findViewById(R.id.armcontrol_emergency);
//        emergencyButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                Toast.makeText(ArmControl.this, "Emergency!", Toast.LENGTH_LONG)
//                        .show();
//                ImageButton emergency = (ImageButton) v;
//                startActivity(new Intent(getApplicationContext(), Emergency.class));
//            }
//        });
//    }
//}
//
