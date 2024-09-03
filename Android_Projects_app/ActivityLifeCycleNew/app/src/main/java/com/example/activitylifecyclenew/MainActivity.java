package com.example.activitylifecyclenew;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","oncreateCall");
        displayMessage("OnCreate");

        Button btnshowtext = findViewById(R.id.button);
        btnshowtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Show Text Button Clicked",Toast.LENGTH_LONG).show();
            }
        });

        Button btnshowsnackbar=findViewById(R.id.showsnackbar);
        btnshowsnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show snackbar when button is clicked
                Snackbar.make(findViewById(android.R.id.content),"SnackBar Message",Snackbar.LENGTH_LONG)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar.make(findViewById(android.R.id.content),"undo Clicked",Snackbar.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayMessage("OnStart");
        Log.d("MainActivity","OnStartCall");
    }

    @Override
    protected void onResume() {
        super.onResume();
        displayMessage("onResume");
        Log.d("MainActivity","OnResumeCall");
    }

    @Override
    protected void onPause() {
        super.onPause();
        displayMessage("onPause");
        Log.d("MainActivity","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        displayMessage("OnStop");
        Log.d("MainActivity","OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        displayMessage("OnDestroy");
        Log.d("MainActivity","OnDestroyCall");
    }

    private void displayMessage(String Message){
        TextView textView=findViewById(R.id.lifecycle);
        textView.setText(Message);
        textView.setTextSize(24f);
    }
}