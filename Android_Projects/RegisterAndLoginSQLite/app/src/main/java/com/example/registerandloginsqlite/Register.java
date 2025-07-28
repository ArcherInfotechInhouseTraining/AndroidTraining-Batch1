package com.example.registerandloginsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.registerandloginsqlite.SQLiteDB.DBHelper;

public class Register extends AppCompatActivity {

    EditText editName, editPass, editCpass, editEmail;
    Button registerBtn;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        editName = findViewById(R.id.user_name);
        editEmail = findViewById(R.id.user_email);
        editPass = findViewById(R.id.user_password);
        editCpass = findViewById(R.id.cpass);
        registerBtn = findViewById(R.id.register_btn);

        dbHelper = new DBHelper(this);

        registerBtn.setOnClickListener( view -> {

            String personName = editName.getText().toString();
            String personEmail = editEmail.getText().toString();
            String personPassword = editPass.getText().toString();
            String confirmPassword = editCpass.getText().toString();

            if ( personName.isEmpty() || personEmail.isEmpty() || personPassword.isEmpty() ||confirmPassword.isEmpty() ){
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();

            }else {

                if ( personPassword.equals(confirmPassword)){

                    Boolean checkUser = dbHelper.checkUserPassword(personName, personPassword);

                    if ( checkUser == false){

                        Boolean insert = dbHelper.insertData(personName, personEmail, personPassword);

                        if ( insert == true){

                            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                            editName.setText("");
                            editEmail.setText("");
                            editPass.setText("");
                            editCpass.setText("");

                            Intent intent = new Intent(Register.this, MainActivity.class);
                            startActivity(intent);

                        }else {
                            Toast.makeText(this, "Registered Failed",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(this," User allready exists", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this," Password not matching", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}