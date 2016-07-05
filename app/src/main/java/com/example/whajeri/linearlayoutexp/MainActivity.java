package com.example.whajeri.linearlayoutexp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*

        Tests & Showcase of different stuff :
        - Standard Toast
        - Logging
        - lifecycle of an app
            on Create -> on Start -> onResume
            onPause -> onStop -> onDestroy
        - simple UI interaction with onClickListener


        Credits :
            freely adapted from
                - Android Programming for Beginners - John Horton
                - Android Development for Beginners - Udacity

      */


    /**
     * Activities lifecycle :
     * <p/>
     * An activity is a single, focused thing that the user can do. Almost all activities interact with the user, so
     * the Activity class takes care of creating a window for you in which you can place your UI with setContentView
     * (View). While activities are often presented to the user as full-screen windows, they can also be used in
     * other ways: as floating windows (via a theme with windowIsFloating set) or embedded inside of another activity
     * (using ActivityGroup). There are two methods almost all subclasses of Activity will implement:
     * onCreate(Bundle) is where you initialize your activity. Most importantly, here you will usually call
     * setContentView(int) with a layout resource defining your UI, and using findViewById(int) to retrieve the
     * widgets in that UI that you need to interact with programmatically.
     * onPause() is where you deal with the user leaving your activity. Most importantly, any changes made by the
     * user should at this point be committed (usually to the ContentProvider holding the data).
     * <p/>
     * more info : https://developer.android.com/reference/android/app/Activity.html
     */


    private Button btnplus;
    private Button btnminus;
    private TextView text_result;
    private int somme = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "In onCreate", Toast.LENGTH_SHORT).show();
        Log.i("info", "In onCreate 6");


        btnplus = (Button) findViewById(R.id.button_plus);
        btnminus = (Button) findViewById(R.id.button_minus);
        text_result = (TextView) findViewById(R.id.text_myResult);

        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        text_result.setOnClickListener(this);

    }


    /**
     * We can use this method to save user data
     */
    @Override
    public void onPause() {
        // First call the "official" version of this method
        super.onPause();

        Toast.makeText(this, "In onPause", Toast.LENGTH_SHORT).show();
        Log.i("info", "In onPause");
    }

    @Override
    public void onStop() {
        // First call the "official" version of this method
        super.onStop();

        Toast.makeText(this, "In onStop", Toast.LENGTH_SHORT).show();
        Log.i("info", "In onStop");
    }

    @Override
    public void onDestroy() {
        // First call the "official" version of this method
        super.onDestroy();

        Toast.makeText(this, "In onDestroy", Toast.LENGTH_SHORT).show();
        Log.i("info", "In onDestroy");
    }


    /**
     * We can use this method to load user data
     */
    @Override
    public void onResume() {

        // First call the "official" version of this method
        super.onResume();

        Toast.makeText(this, "In onResume", Toast.LENGTH_SHORT).show();
        Log.i("info", "In onResume");
    }


    /**
     * Sample way to interact
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button_plus:
                somme ++;
                text_result.setText(""+ somme);

                break;

            case R.id.button_minus:
                somme--;
                text_result.setText(""+ somme);
                break;
        }
    }


    /**
     *
    Example : how to add a new button to a layout
     // Create a new LinearLayout
     LinearLayout linearLayout = new LinearLayout();

     // Create a new Button
     Button myButton = new Button();

     // Add myButton to the LinearLayout
     linearLayout.addView(myButton);

     // Make the LinearLayout the main view
     setContentView(linearLayout);

     *
     */



}
