package com.example.saumya.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;


public class myService extends Service{

     MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer=MediaPlayer.create(this,R.raw.airtel);

        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        Toast.makeText(this, "Music ON", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        Toast.makeText(this, "Music OFF", Toast.LENGTH_SHORT).show();
    }
}
