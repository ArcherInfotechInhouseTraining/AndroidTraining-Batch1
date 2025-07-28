package com.example.traveling_recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveling_recyclerview.Adaptor.TravelspotAdapter;
import com.example.traveling_recyclerview.Modal.TravelSpots;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<TravelSpots> spotsList;
    private TravelspotAdapter spotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        spotsList = new ArrayList<>();
        spotsList.add(new TravelSpots("TajMahal","India",R.drawable.tajmahal));
        spotsList.add(new TravelSpots("Machu","Peru",R.drawable.machu_picchu_peru));
        spotsList.add(new TravelSpots("Ladakh","India",R.drawable.ladakh));
        spotsList.add(new TravelSpots("EiffelTower","Paris",R.drawable.eiffeltower));
        spotsList.add(new TravelSpots("Disney","Disney",R.drawable.disney));
        spotsList.add(new TravelSpots("Banff","Canada",R.drawable.canada_banff));
        spotsList.add(new TravelSpots("Balli","Balli",R.drawable.bali));
        spotsList.add(new TravelSpots("Grnad Canyon","America",R.drawable.america_grand_canyon));


        spotAdapter = new TravelspotAdapter(spotsList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(spotAdapter);
    }
}