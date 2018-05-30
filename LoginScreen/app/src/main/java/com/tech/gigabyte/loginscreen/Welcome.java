package com.tech.gigabyte.loginscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by GIGABYTE on 5/3/2017.
 */

public class Welcome extends AppCompatActivity {
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Method for an Activity OnCreate *default
        super.onCreate(savedInstanceState);
        setTitle(R.string.Welcome_Page);
        setContentView(R.layout.activity_welcome);         // Passing Layout
        tvName = (TextView) findViewById(R.id.tvNameResult);

        Intent getIntentObj = getIntent();
        String Res = "Welcome " + getIntentObj.getExtras().getString("BundleName"); //Retrieving Input - Email

        tvName.setText(Res);

    }

}
