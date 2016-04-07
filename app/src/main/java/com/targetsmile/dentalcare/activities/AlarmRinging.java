package com.targetsmile.dentalcare.activities;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flurry.android.FlurryAgent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.targetsmile.dentalcare.R;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.TextView;


public class AlarmRinging extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    public void closeAlarm(View view)
    {

        FlurryAgent.logEvent("Dental Fact Activity - Close Alarm");
        mediaPlayer.stop();

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(1);

        finish();





    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_ringing);

        AdView adView = (AdView) findViewById(R.id.adUnit);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        TextView textViewMessageNightBrushing = (TextView) findViewById(R.id.nightBrushingFactTextView);

        Typeface typeFace=Typeface.createFromAsset(getAssets(), "fonts/jennasue.ttf");
        textViewMessageNightBrushing.setTypeface(typeFace);



        mediaPlayer = MediaPlayer.create(this, R.raw.alertsound);
        mediaPlayer.start();


    }


    public void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this);

        // your code
    }

    public void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
        // your code
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
