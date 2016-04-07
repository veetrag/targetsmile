package com.targetsmile.dentalcare.activities;

import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;



import android.os.Build;

import com.flurry.android.FlurryAgent;
import com.targetsmile.dentalcare.reminderservice.BrushingReminderAlarmReceiver;
import com.targetsmile.dentalcare.R;

public class NightBrushingActivity extends AppCompatActivity {


    BrushingReminderAlarmReceiver alarm;
    SharedPreferences prefs;
    TextView alarmStatusTextView;


    public void cancelAlarm(View view) {

        FlurryAgent.logEvent("Night Brushing Activity - Cancel Alarm");
        alarm.cancelAlarm(this);
        alarmStatusTextView.setText("No reminder!");
        Toast.makeText(this, "Reminder Cancelled!", Toast.LENGTH_SHORT).show();

    }


    public void setAlarm(View view) {

        FlurryAgent.logEvent("Night Brushing Activity - Set Alarm");

        TimePicker timePicker = (TimePicker) findViewById(R.id.timePickerForReminder);

        int reminderHour;
        int reminderMinute;

        String reminderHourString;
        String reminderMinuteString;

        if (Build.VERSION.SDK_INT >= 23 ) {
            reminderHour = timePicker.getHour();
            reminderMinute = timePicker.getMinute();
        }
        else {
            reminderHour = timePicker.getCurrentHour();
            reminderMinute = timePicker.getCurrentMinute();
        }



        reminderHourString = ""+ reminderHour;
        reminderMinuteString = "" + reminderMinute;
        // Log.d("time picked", "");

        if(reminderMinute < 10)
        {
            reminderMinuteString = "0" + reminderMinuteString;
        }

        if(reminderHour < 10)
        {
            reminderHourString = "0" + reminderHourString;
        }

        alarmStatusTextView.setText("Current Reminder - " + reminderHourString + " : " + reminderMinuteString);

        Toast.makeText(this, "Reminder set for " + reminderHourString + " : " + reminderMinuteString, Toast.LENGTH_LONG).show();



        prefs.edit().putInt("minute",reminderMinute).apply();
        prefs.edit().putInt("hour",reminderHour).apply();


        alarm.cancelAlarm(this);
        alarm.setAlarm(this, reminderHour, reminderMinute);

      //  Log.d("Trying out alarm time ", alarm.getResultData());


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_brushing);



        alarmStatusTextView = (TextView) findViewById(R.id.alaramStatusTextView);

        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/jennasue.ttf");
        alarmStatusTextView.setTypeface(typeFace);


        alarm = new BrushingReminderAlarmReceiver();

        prefs = this.getSharedPreferences("com.targetsmile.dentalcare", Context.MODE_PRIVATE);

        alarmStatusTextView.setText("Current Reminder - " + prefs.getInt("hour", 0) + " : " + prefs.getInt("minute", 0));




//        Toast.makeText(this, "Reminder was set for " + prefs.getInt("hour", 0) + " : " + prefs.getInt("minute", 0), Toast.LENGTH_LONG).show();
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
