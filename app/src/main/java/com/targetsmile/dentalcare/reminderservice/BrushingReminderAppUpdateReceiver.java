package com.targetsmile.dentalcare.reminderservice;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.flurry.android.FlurryAgent;

/**
 * Created by veetrag on 28/01/16.
 */
public class BrushingReminderAppUpdateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

            FlurryAgent.logEvent("App Update Service - Set Alarm");

            BrushingReminderAlarmReceiver alarm = new BrushingReminderAlarmReceiver();
            SharedPreferences prefs = context.getSharedPreferences("com.targetsmile.dentalcare", Context.MODE_PRIVATE);

            int reminderHour = prefs.getInt("minute", 22);
            int reminderMinute = prefs.getInt("hour", 0);

            // Log.d("time picked", "");

            alarm.cancelAlarm(context);
            alarm.setAlarm(context, reminderHour, reminderMinute);

        }
    }
}