package com.example.servicemusicplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneServicesClass extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){

            boolean isAroplaneModeOn = intent.getBooleanExtra("State", false);
            String msg = isAroplaneModeOn ? "Pooja Airplane Mode On" : " Pooja Airplane Mode Off";
            Toast.makeText(context, msg,Toast.LENGTH_LONG).show();
        }

    }
}
