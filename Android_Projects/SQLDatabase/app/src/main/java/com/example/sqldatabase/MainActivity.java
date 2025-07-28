package com.example.sqldatabase;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name,date,phone,address;
    Button insert, update, delete, read;

    DB_helper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameedit);
        date = findViewById(R.id.dobedit);
        phone = findViewById(R.id.phoneedit);
        address = findViewById(R.id.addressedit);

        insert = findViewById(R.id.insertbtn);
        update = findViewById(R.id.updatebtn);
        delete = findViewById(R.id.deletebtn);
        read = findViewById(R.id.readbtn);

        db = new DB_helper(this);

        date.setOnClickListener( view -> showCalender());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametext = name.getText().toString();
                String contacttext = phone.getText().toString();
                String dob = date.getText().toString();
                String addresstext = address.getText().toString();

                Boolean checkInsertData = db.insertUserDate(nametext, contacttext, dob, addresstext);

                if (checkInsertData){
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametext = name.getText().toString();
                String contacttext = phone.getText().toString();
                String dob = date.getText().toString();
                String addresstext = address.getText().toString();

                Boolean checkUpdateData = db.updateUserDate(nametext, contacttext, dob, addresstext);

                if (checkUpdateData){
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametext = name.getText().toString();

                Boolean checkUpdateData = db.deleteUserDate(nametext);

                if (checkUpdateData){
                    Toast.makeText(MainActivity.this, "Entery Deleted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Entery Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = db.readUserDate();

                if (res.getCount()==0){

                    Toast.makeText(MainActivity.this, "No Entry Existes", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (res.moveToNext()){
                    buffer.append("name: "+res.getString(0)+"\n");
                    buffer.append("Contact: "+res.getString(1)+"\n");
                    buffer.append("Date Of Birth: "+res.getString(2)+"\n");
                    buffer.append("Address: "+res.getString(3)+"\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }

    private void showCalender(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectYear, selectMonth, selectedDay)->{
                    String selectedDate = selectedDay+ " / "+(selectMonth+1)+selectYear;

                    date.setText(selectedDate);
                },
                year,month,day
        );

        datePickerDialog.show();
    }
}