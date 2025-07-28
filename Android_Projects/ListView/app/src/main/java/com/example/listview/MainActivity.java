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

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AppCompatButton btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        String[] countries = {"India", "USA", "UK", "Canada", "Germany", "France", "Japan","India", "USA", "UK", "Canada", "Germany", "France", "Japan","India", "USA", "UK", "Canada", "Germany", "France", "Japan"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,countries);
        listView.setAdapter(adapter);

        btn = findViewById(R.id.nextbtn);
        btn.setOnClickListener( v -> {
            startActivity(new Intent(MainActivity.this, mycustome_adapter.class));
        });


    }
}