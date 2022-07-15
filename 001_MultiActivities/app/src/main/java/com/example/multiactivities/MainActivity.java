package com.example.multiactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    //TAG
    public static String TAG = "FirstApp";
    public static String strLog = "";
    //message
    public static String messageText = "this is message sent from here.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMyJob(View view) {
        System.out.print("this is doMyJob function.");
        strLog = String.format("this is my LOG in doMyJob.");
        Log.d(TAG,strLog);

        //Intent intent = new Intent(this,ReceiveMessageActivity.class);
        //intent.putExtra("message", "this is what is sent from MainActivity to second activity.");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }

}