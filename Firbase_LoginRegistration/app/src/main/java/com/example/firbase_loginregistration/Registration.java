package com.example.firbase_loginregistration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    EditText userName;
    EditText userPassword;
    EditText emailInput;
    TextView allreadyRegister;

    Button registrationBtn;

    FirebaseAuth mAuth;

//    ProgressBar progressBar;


    @SuppressLint("MissingInflatedId")
    @Override

    public void onStart(){
        super.onStart();

        if(mAuth == null){
            mAuth = FirebaseAuth.getInstance();
        }

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.registration_userNameText);
        emailInput = findViewById(R.id.registration_emailText);
        userPassword = findViewById(R.id.registration_passwordText);
        registrationBtn = findViewById(R.id.register_btn);
        allreadyRegister = findViewById(R.id.allready_registerText);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ProgressBar progressBar = findViewById(R.id.progressBar);

        registrationBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String usernameStr = String.valueOf(userName.getText());
                String emailStr = String.valueOf(emailInput.getText());
                String passwordStr = String.valueOf(userPassword.getText());


                if(TextUtils.isEmpty(usernameStr) || TextUtils.isEmpty(passwordStr)){
                    Toast.makeText(Registration.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(passwordStr.length() < 6){
                    Toast.makeText(Registration.this, "Password too short, enter minimum 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                    mAuth.createUserWithEmailAndPassword(emailStr, passwordStr)
                            .addOnCompleteListener( Registration.this,new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Registration.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
            }
        });

        allreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}