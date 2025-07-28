package com.example.registerandloginsqlite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.registerandloginsqlite.SQLiteDB.DBHelper;

public class MainActivity extends AppCompatActivity {

    TextView registerTextView;
    EditText editUserName, editUserPassword;
    Button loginBtn, cancelBtn;
    DBHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editUserName = findViewById(R.id.login_userName);
        editUserPassword = findViewById(R.id.login_password);

        loginBtn = findViewById(R.id.login_btn);
        cancelBtn = findViewById(R.id.cancel_btn);

        registerTextView = findViewById(R.id.registerText);

        String text = "If not registered then Register Here";
        SpannableStringBuilder spannableString = new SpannableStringBuilder(text);

        // Find the start and end indices of "Register Here"
        int start = text.indexOf("Register Here");
        int end = start + "Register Here".length();

        // Apply bold style using StyleSpan
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, end, 0);
        // Change the text color to red (or any color you prefer)
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), start, end, 0);

        // Set the styled text to the TextView
        registerTextView.setText(spannableString);

        registerTextView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);

        });

        dbHelper = new DBHelper(this);
        loginBtn.setOnClickListener(v -> {
            String user = editUserName.getText().toString();
            String pass = editUserPassword.getText().toString();
            if (user.equals("") || pass.equals("")) {
                editUserName.setError("Please enter all the fields");
            }else{
                Boolean checkuserpass = dbHelper.checkUserPassword(user, pass);
                if (checkuserpass == true){
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                }else {
                    editUserName.setError("Invalid Credentials");
                    editUserPassword.setError("Invalid Credentials");
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}