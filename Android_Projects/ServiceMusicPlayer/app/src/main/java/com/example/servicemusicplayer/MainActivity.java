package com.example.servicemusicplayer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button playBtn, pauseBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        playBtn = findViewById(R.id.playBtn);
        pauseBtn = findViewById(R.id.pauseBtn);


        playBtn.setOnClickListener( view -> {

            Intent serviceInent = new Intent(getApplicationContext(), MycustomeServiceClass.class);
            startService(serviceInent);
        });

        pauseBtn.setOnClickListener( view -> {

            Intent serviceInent = new Intent(getApplicationContext(), MycustomeServiceClass.class);
            stopService(serviceInent);
        });

        android.content.IntentFilter intentFilter = new android.content.IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        AirplaneServicesClass airplaneServicesClass = new AirplaneServicesClass();
        registerReceiver( airplaneServicesClass, intentFilter);


    }
}