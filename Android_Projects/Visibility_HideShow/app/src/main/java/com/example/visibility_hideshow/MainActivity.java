package com.example.visibility_hideshow;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textView, text1, text2, text3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);


        textView.setOnClickListener( view -> {
            setVisibilityToggle(text1);
            setVisibilityToggle(text2);
            setVisibilityToggle(text3);

        });

    }

    public void setVisibilityToggle(TextView text){

        if(text.getVisibility() == View.GONE){
            text.setVisibility(View.VISIBLE);
        }
        else{
            text.setVisibility(View.GONE);
        }
    }
}