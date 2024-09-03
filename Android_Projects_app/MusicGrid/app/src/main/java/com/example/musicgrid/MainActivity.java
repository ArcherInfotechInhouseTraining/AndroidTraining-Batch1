package com.example.musicgrid;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer guiterPlayer,tablaPlayer,flutePlayer,pianoPlayer,trumpetPlayer,drumPlayer,rainPlayer,
            dholPlayer,veenaPlayer;

    GifImageView guiter,flutevar,drumvar,pianovar,trumpetvar,rainvar;
    ImageView  tablavar ,dholvar,veenavar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        guiter=findViewById(R.id.guiter);
        guiterPlayer = MediaPlayer.create(this,R.raw.guitermusic);

        tablavar=findViewById(R.id.tabla);
        tablaPlayer = MediaPlayer.create(this,R.raw.tablamusic);

        flutevar=findViewById(R.id.flute);
        flutePlayer = MediaPlayer.create(this,R.raw.flutemusic);

        pianovar=findViewById(R.id.piano);
        pianoPlayer = MediaPlayer.create(this,R.raw.pianomusic);

        trumpetvar=findViewById(R.id.trumpet);
        trumpetPlayer = MediaPlayer.create(this,R.raw.trumpetmusic);

        drumvar=findViewById(R.id.drum);
        drumPlayer = MediaPlayer.create(this,R.raw.drumsmusic);

        rainvar=findViewById(R.id.rain);
        rainPlayer = MediaPlayer.create(this,R.raw.rainmusic);

        dholvar=findViewById(R.id.dhol);
        dholPlayer = MediaPlayer.create(this,R.raw.dholmusic);

        veenavar=findViewById(R.id.veena);
        veenaPlayer = MediaPlayer.create(this,R.raw.veenamusic);


        // Click Listeners of Variables
        //guiter
        guiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(guiterPlayer);
            }
        });

        //tabla
        tablavar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(tablaPlayer);
            }
        });

        //flute
        flutevar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(flutePlayer);
            }
        });

        //piano
        pianovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(pianoPlayer);
            }
        });

        //trumpet
        trumpetvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(trumpetPlayer);
            }
        });

        //drums
        drumvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(drumPlayer);
            }
        });

        //rain
        rainvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(rainPlayer);
            }
        });

        //dhole
        dholvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(dholPlayer);
            }
        });

        //veena
        veenavar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleAudio(veenaPlayer);
            }
        });
    }


    //Createing Methods To Play And Pause The Audio

    private void toggleAudio(MediaPlayer mediaPlayer)
    {
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
    protected void onDestroy(MediaPlayer mediaPlayer){
        super.onDestroy();
        //Release media player resources when the activity is destroy
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}