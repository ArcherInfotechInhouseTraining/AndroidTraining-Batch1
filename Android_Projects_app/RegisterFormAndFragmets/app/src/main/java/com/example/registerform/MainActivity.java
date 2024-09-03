package com.example.registerform;

import static com.example.registerform.R.id.buttonred;

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
    }
}