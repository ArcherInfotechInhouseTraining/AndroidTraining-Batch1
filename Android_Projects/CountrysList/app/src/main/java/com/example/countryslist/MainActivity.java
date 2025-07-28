package com.example.countryslist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryslist.Adaptor.CountryListAdapter;
import com.example.countryslist.Modal.CountryList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CountryList> countryListList;
    CountryListAdapter countryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        countryListList = new ArrayList<>();

        countryListList.add(new CountryList("India", R.drawable.india));
        countryListList.add(new CountryList("Afganistan", R.drawable.afganistan));
        countryListList.add(new CountryList("India", R.drawable.india));
        countryListList.add(new CountryList("Afganistan", R.drawable.afganistan));
        countryListList.add(new CountryList("India", R.drawable.india));
        countryListList.add(new CountryList("Afganistan", R.drawable.afganistan));


        countryListAdapter = new CountryListAdapter(countryListList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(countryListAdapter);

    }
}