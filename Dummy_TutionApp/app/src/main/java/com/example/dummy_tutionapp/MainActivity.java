package com.example.dummy_tutionapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dummy_tutionapp.Adaptor.CourseListAdaptor;
import com.example.dummy_tutionapp.Modal.CourseList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CourseList> courseList;
    CourseListAdaptor courseAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        courseList = new ArrayList<>();

        courseList.add(new CourseList("CPP", "100", R.drawable.cpp));
        courseList.add(new CourseList("Java", "200", R.drawable.java));
        courseList.add(new CourseList("C", "100", R.drawable.c));
        courseList.add(new CourseList("JavaScript", "200", R.drawable.javascript));
        courseList.add(new CourseList("AI", "100", R.drawable.ai));
        courseList.add(new CourseList("Data Science", "200", R.drawable.data_science));
        courseList.add(new CourseList("SQL", "100", R.drawable.sql));
        courseList.add(new CourseList("Mearn", "200", R.drawable.mern));



        courseAdaptor = new CourseListAdaptor(courseList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(courseAdaptor);


    }
}