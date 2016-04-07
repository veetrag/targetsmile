package com.targetsmile.dentalcare.reminderservice;


import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.targetsmile.dentalcare.R;
import com.targetsmile.dentalcare.activities.AlarmRinging;
import com.targetsmile.dentalcare.activities.BrushingTechniqueActivity;

import android.support.v4.app.NotificationCompat.Builder;

/**
 * Created by veetrag on 28/01/16.
 */
public class BrushingReminderService extends IntentService {

    public BrushingReminderService() {
        super("BrushingReminderService");
    }

    public static final String TAG = "Scheduling Demo";
    // An ID used to post the notification.
    public static final int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    Builder builder;

    @Override
    protected void onHandleIntent(Intent intent) {


        Log.d("Service started","service has started");

        // BEGIN_INCLUDE(service_onhandle)
        // The URL from which to fetch content.

        // Release the wake lock provided by the BroadcastReceiver.
        BrushingReminderAlarmReceiver.completeWakefulIntent(intent);

        this.sendNotification("Time for brushing");
        // END_INCLUDE(service_onhandle)
    }


    public void sendNotification(String msg)
    {

        Log.d("Notification starting", "trying to start activity....");

        Intent dialogIntent = new Intent(this, AlarmRinging.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1, dialogIntent, 0);




        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Target Smile - Dental Care")
                .setContentText("Time to brush!")
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.btn_star, "Complete", pendingIntent)
                .setSmallIcon(getNotificationIcon())
                .setColor(0x0165B3)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);


//        Intent dialogIntent = new Intent(this, AlarmRinging.class);
        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(dialogIntent);


    }



    // Post a notification indicating whether a doodle was found.
    private void sendNotification_old(String msg) {

        Log.d("Notification starting", "trying it out....");

        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, BrushingTechniqueActivity.class), 0);

        Builder mBuilder = new Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContentTitle(getString(R.string.app_name));
        mBuilder.setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }




    private int getNotificationIcon() {
        boolean useWhiteIcon = (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP);
        return useWhiteIcon ? R.drawable.ts_notification_lollipop : R.mipmap.ic_launcher;
    }

}
