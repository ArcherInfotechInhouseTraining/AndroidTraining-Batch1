package com.example.androidlifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","OnCreate Call");
        displayMessage("oncreate");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart(){
        super.onStart();
        displayMessage("onStart");
        Log.d("MainActivity","onStart Call");
    }

    @Override
    protected void onResume(){
        super.onResume();
        displayMessage("OnResume");
        Log.d("MainActivity","onResume Call");
    }

    @Override
    protected void onPause(){
        super.onPause();
        displayMessage("onPause");
        Log.d("MainActivity","onPause Call");
    }

    @Override
    protected void onStop(){
        super.onStop();
        displayMessage("onStop");
        Log.d("MainActivity","onStop Call");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        displayMessage("onDestroy");
        Log.d("MainActivity","onDestroy Call");
    }

    private void displayMessage(String Message)
    {
        TextView textView = findViewById(R.id.lifecycle_textview);
        textView.setText(Message);
        textView.setTextSize(24f);
    }
}