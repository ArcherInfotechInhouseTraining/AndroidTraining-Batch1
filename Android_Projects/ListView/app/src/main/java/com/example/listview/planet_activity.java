package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class planet_activity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_planet);

        listView = findViewById(R.id.planetlist);

        planetArrayList = new ArrayList<>();

        planetArrayList.add(new Planet("Earth", "1 Moons", R.drawable.earth));
        planetArrayList.add(new Planet("Jupiter", "4 Moons", R.drawable.jupiter));
        planetArrayList.add(new Planet("Pluto", "1 Moons", R.drawable.pluto));
        planetArrayList.add(new Planet("Venus", "2 Moons", R.drawable.venus));
        planetArrayList.add(new Planet("Mercury", "3 Moons", R.drawable.mercury));
        planetArrayList.add(new Planet("Mars", "1 Moons", R.drawable.mars));

        PlanetAdapter adapter = new PlanetAdapter(planetArrayList, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(planet_activity.this,"Planet Name: "+planetArrayList.get(position).getPlanetName(), Toast.LENGTH_SHORT);

            }
        });
    }
}