package com.example.listview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mycustome_adapter extends AppCompatActivity {

    ListView listView;
    AppCompatButton btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mycustome_adapter);


        listView = findViewById(R.id.listview1);
        String[] countries = {"India", "USA", "UK", "Canada", "Germany", "France", "Japan","India", "USA", "UK", "Canada", "Germany", "France", "Japan","India", "USA", "UK", "Canada", "Germany", "France", "Japan"};



        MyAdapter adapter1 = new MyAdapter(this, countries);
        listView.setAdapter(adapter1);


        btn = findViewById(R.id.custombtn);
        btn.setOnClickListener( v -> {
            startActivity(new Intent(mycustome_adapter.this, planet_activity.class));
        });

    }
}