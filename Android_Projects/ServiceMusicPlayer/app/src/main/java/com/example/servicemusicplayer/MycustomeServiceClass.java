package com.example.servicemusicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

import java.security.Provider;

public class MycustomeServiceClass extends Service {

    @Nullable
    MediaPlayer player;

    public int onStartCommand(Intent intent, int flags, int startId){

//        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player = MediaPlayer.create(this,R.raw.ring);

        player.setLooping(true);
        player.start();

        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }

    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }
}
