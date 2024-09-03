package com.example.navigationbar;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class homefragmentDemo extends Fragment {

    EditText e1;
    TextView t1;
    AppCompatButton proceed;

    public homefragmentDemo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homedemo, container, false);

        e1=view.findViewById(R.id.entername);
        t1=view.findViewById(R.id.blanktext);
        proceed=view.findViewById(R.id.proceed);


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name;
                name=e1.getText().toString();
                t1.setText(name);
            }
        });

        return view;
//        return inflater.inflate(R.layout.fragment_homedemo, container, false);
    }
}