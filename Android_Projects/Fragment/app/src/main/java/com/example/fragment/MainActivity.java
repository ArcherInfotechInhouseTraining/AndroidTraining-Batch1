package com.example.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        get a fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();

//        load the first fragment by default
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container,new redFragment())
                .commit();

        //button for fragment one
        Button btnFragmentOne = findViewById(R.id.redbutton);
        btnFragmentOne.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new redFragment())
                    .commit();
        });

        //button for fragment two
        Button btnFragmentTwo = findViewById(R.id.bluebutton);
        btnFragmentTwo.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new blueFragment())
                    .commit();
        });

        //button for fragment three
        Button btnFragmentThree = findViewById(R.id.greenbutton);
        btnFragmentThree.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new greenFragment())
                    .commit();
        });

        //button for fragment four
        Button btnFragmentFour = findViewById(R.id.yellowbutton);
        btnFragmentFour.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new yellowFragment())
                    .commit();
        });

        //button for fragment five
        Button btnFragmentFive = findViewById(R.id.purplebutton);
        btnFragmentFive.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new blueFragment())
                    .commit();
        });

        //button for fragment six
        Button btnFragmentSix = findViewById(R.id.orangebutton);
        btnFragmentSix.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new orangeFragment())
                    .commit();
        });

        //button for fragment seven
        Button btnFragmentSeven = findViewById(R.id.tealbutton);
        btnFragmentSeven.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new tealFragment())
                    .commit();
        });

        //button for fragment eight
        Button btnFragmentEight = findViewById(R.id.pinkbutton);
        btnFragmentEight.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new pinkFragment())
                    .commit();
        });

        //button for fragment nine
        Button btnFragmentNine = findViewById(R.id.cyanbutton);
        btnFragmentNine.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new cyanFragment())
                    .commit();
        });

        //button for fragment ten
        Button btnFragmentTen = findViewById(R.id.skybluebutton);
        btnFragmentTen.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new skyblueFragment())
                    .commit();
        });

        //button for fragment eleven
        Button btnFragmentEleven = findViewById(R.id.graybutton);
        btnFragmentEleven.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new grayFragment())
                    .commit();
        });

        //button for fragment twelve
        Button btnFragmentTwelve = findViewById(R.id.olivebutton);
        btnFragmentTwelve.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,new oliveFragment())
                    .commit();
        });

//        button for fragment calculator
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnFragmentCalculator = findViewById(R.id.calculator);
        btnFragmentCalculator.setOnClickListener(v ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, new calculator())
                    .commit();
        });
    }
}