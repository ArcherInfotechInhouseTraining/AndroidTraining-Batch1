package com.example.registerform;

import static com.example.registerform.R.id.buttongreen;
import static com.example.registerform.R.id.buttonred;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class Fragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment);
        //get a FragmentManager
        FragmentManager fragmentManager=getSupportFragmentManager();

        //Load the First Fragment by default
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentcontainer,new fragmentone())
                .commit();

        //Button For Fragment One
        Button btnFragmentOne = findViewById(buttonred);
        btnFragmentOne.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new fragmentone())
                    .commit();
        });


        //Button For Fragment two
        Button btnFragmentTwo = findViewById(buttongreen);
        btnFragmentTwo.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentTwo())
                    .commit();
        });

        //Button For Fragment three
        Button btnFragmentThree = findViewById(R.id.buttonblue);
        btnFragmentThree.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new fragmentThree())
                    .commit();
        });

        //Button For Fragment four
        Button btnFragmentfour = findViewById(R.id.buttonwhite);
        btnFragmentfour.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentFour())
                    .commit();
        });


        //Button For Fragment five
        Button btnFragmentfive = findViewById(R.id.buttonpink);
        btnFragmentfive.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentFive())
                    .commit();
        });

        //Button For Fragment six
        Button btnFragmentsix = findViewById(R.id.buttonpurple);
        btnFragmentsix.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentSix())
                    .commit();
        });

        //Button For Fragment seven
        Button btnFragmentseven = findViewById(R.id.buttonorange);
        btnFragmentseven.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentSeven())
                    .commit();
        });

        //Button For Fragment eight
        Button btnFragmenteight = findViewById(R.id.buttonyello);
        btnFragmenteight.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentEight())
                    .commit();
        });

        //Button For Fragment nine
        Button btnFragmentnine = findViewById(R.id.buttonblack );
        btnFragmentnine.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentNine())
                    .commit();
        });


        //Button For Fragment ten
        Button btnFragmentten = findViewById(R.id.buttonskyblue);
        btnFragmentten.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentTen())
                    .commit();
        });

        //Button For Fragment eleven
        Button btnFragmenteleven = findViewById(R.id.buttoncyan);
        btnFragmenteleven.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentEleven())
                    .commit();
        });

        //Button For Fragment twelve
        Button btnFragmenttwelve = findViewById(R.id.buttonChartreuse);
        btnFragmenttwelve.setOnClickListener(V ->{
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentcontainer,new FragmentTwelve())
                    .commit();
        });

        //for button calculator

    }
}