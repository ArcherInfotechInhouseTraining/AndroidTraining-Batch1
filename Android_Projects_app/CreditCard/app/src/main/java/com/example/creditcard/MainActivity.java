package com.example.creditcard;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9;
    AppCompatButton proceed;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //For EditText MEntion Their IDs
        e1 = findViewById(R.id.enterbankname);
        e2=findViewById(R.id.entername);
        e3=findViewById(R.id.entertype);
        e4=findViewById(R.id.entercarnumber);
        e5=findViewById(R.id.securitycode);
        e6=findViewById(R.id.enterstart);
        e7=findViewById(R.id.enterexipirydate);

        //For Textview Mention Their ID
        t1=findViewById(R.id.bankname);
        t2=findViewById(R.id.card);
        t3=findViewById(R.id.cardnumber);
        t4=findViewById(R.id.num);
        t5=findViewById(R.id.monthyear);
        t6=findViewById(R.id.expire);
        t7=findViewById(R.id.startdate);
        t8=findViewById(R.id.enddate);
        t9=findViewById(R.id.username);


        proceed=findViewById(R.id.proceed);

        mediaPlayer = MediaPlayer.create(this,R.raw.audio);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anime);
                RelativeLayout relativeLayout =(RelativeLayout)findViewById(R.id.cardRelative);
                relativeLayout.startAnimation(animation);

                //For CardNumber
                String card;
                card=e4.getText().toString();
                t3.setText(card);

                String username,startdate,enddate,bankname,securitycode,type;

                bankname=e1.getText().toString();
                t1.setText(bankname);

                username=e2.getText().toString();
                t9.setText(username);

                type=e3.getText().toString();
                t2.setText(type);

                securitycode=e5.getText().toString();
                t4.setText(securitycode);

                startdate=e6.getText().toString();
                t7.setText(startdate);

                enddate=e7.getText().toString();
                t8.setText(enddate);

                toggleAudio();
            }
        });
    }

    private void toggleAudio(){
        if(mediaPlayer != null)
        {
            if(mediaPlayer.isPlaying())
            {
                mediaPlayer.pause();
            }
            else
            {
                mediaPlayer.start();
            }
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        //Release media player resources when the activity is destroy
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}