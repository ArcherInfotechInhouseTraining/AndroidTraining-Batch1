package com.example.instrumentalmusic;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer, mediaPlayer1, mediaPlayer2;
    ImageView imageView1, imageView2, imageView3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.tabla);
        mediaPlayer = MediaPlayer.create(this, R.raw.tabla1);

        imageView2 = findViewById(R.id.veena);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.veena_recording);

        imageView3 = findViewById(R.id.flute);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.flute_audio);



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(mediaPlayer);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(mediaPlayer1);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(mediaPlayer2);
            }
        });
    }

    private  void  toggleAudio(MediaPlayer mediaPlayer){
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            else {
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