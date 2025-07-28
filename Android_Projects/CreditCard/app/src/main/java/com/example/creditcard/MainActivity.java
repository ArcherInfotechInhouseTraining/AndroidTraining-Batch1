package com.example.creditcard;


import static com.example.creditcard.R.id.enddate;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView t1, t2, t3, t4, t5, t6, t7,t8;
    EditText e1, e2, e3, e4, e5, e6, e7, e8;
    Button proceed;
    MediaPlayer mediaPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.textaccno1);
        t2 = findViewById(R.id.textaccno2);
        t3 = findViewById(R.id.textaccno3);
        t4 = findViewById(R.id.textaccno4);
        t5 = findViewById(R.id.cvvtext);
        t6 = findViewById(R.id.startdate);
        t7 = findViewById(R.id.enddate);
        t8 = findViewById(R.id.holdername);

        e1 = findViewById(R.id.name);
        e2 = findViewById(R.id.accno1);
        e3 = findViewById(R.id.accno2);
        e4 = findViewById(R.id.accno3);
        e5 = findViewById(R.id.accno4);
        e6 = findViewById(R.id.cvv);
        e7 = findViewById(R.id.validfrom);
        e8 = findViewById(R.id.expiry);

        proceed = findViewById(R.id.btn);
        mediaPlayer = MediaPlayer.create(this,R.raw.success);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anime);
                RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.card_container);
                relativeLayout.startAnimation(animation);
                String card1, card2,card3, card4;

                card1 = e2.getText().toString();
                t1.setText(card1);

                card2 = e3.getText().toString();
                t2.setText(card2);

                card3 = e4.getText().toString();
                t3.setText(card3);

                card4 = e5.getText().toString();
                t4.setText(card4);

                String username, cvv, startdate, expirydate;

                username = e1.getText().toString();
                t8.setText(username);

                cvv = e6.getText().toString();
                t5.setText(cvv);

                startdate = e7.getText().toString();
                t6.setText(startdate);

                expirydate = e8.getText().toString();
                t7.setText(expirydate);

                toggleAudio();


            }
        });
    }

    private  void toggleAudio(){
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            else{
                mediaPlayer.start();
            }
        }
    }
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}