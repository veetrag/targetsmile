package com.targetsmile.dentalcare.activities;



import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.Typeface;

import android.widget.Toast;
import android.net.Uri;
import android.content.ActivityNotFoundException;

import com.apptentive.android.sdk.Apptentive;

import com.apptentive.android.sdk.module.messagecenter.UnreadMessagesListener;

import com.flurry.android.FlurryAgent;
import com.targetsmile.dentalcare.DownloadFactsLinkService;
import com.targetsmile.dentalcare.R;

import java.util.ArrayList;


public class StartActivity extends AppCompatActivity {

    ListView startListView;

    public void launchMarket(View view) {

        // Log.d("Trying to go to PlayStore", "...");

        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);



        try {
            startActivity(myAppLinkToMarket);

        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
        }
        FlurryAgent.logEvent("Start Activity - Rate Us");
    }


    public void startBrushingActivity()
    {
        FlurryAgent.logEvent("Start Activity - Start Brushing");
        Intent myIntent = new Intent(StartActivity.this, BrushingTechniqueActivity.class);
        StartActivity.this.startActivity(myIntent);

    }


    public void startNightBrushingReminderActivity()
    {
        FlurryAgent.logEvent("Start Activity - Night Reminder");
        Intent myIntent = new Intent(StartActivity.this, NightBrushingActivity.class);

        StartActivity.this.startActivity(myIntent);


    }

    public void startConsultationActivity()
    {
        Apptentive.showMessageCenter(StartActivity.this);

    }

    public void startDentalFact()
    {
        FlurryAgent.logEvent("Start Activity - Dental Facts");
        Intent myIntent = new Intent(StartActivity.this, FactsGrid.class);
        StartActivity.this.startActivity(myIntent);
//        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

    }

    public void startHomeRemedies()
    {
        FlurryAgent.logEvent("Start Activity - Home Remedies");
        Intent myIntent = new Intent(StartActivity.this, HomeRemediesActivity.class);
        StartActivity.this.startActivity(myIntent);
//        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        TextView mainLogoText=(TextView)findViewById(R.id.mainLogoText);
        TextView secondaryLogoText=(TextView)findViewById(R.id.secondaryLogoText);

        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/jennasue.ttf");
        mainLogoText.setTypeface(typeFace);
        secondaryLogoText.setTypeface(typeFace);

        startListView = (ListView) findViewById(R.id.startListView);

        ArrayList<String> itemsToClickToStart = new ArrayList<String>();
        itemsToClickToStart.add("Home Remedies");
        itemsToClickToStart.add("Brushing Guide");
        itemsToClickToStart.add("Dental Health Facts");
        itemsToClickToStart.add("Brushing Reminder");
        itemsToClickToStart.add("Dental Queries");


        ArrayList<String> itemDescriptionToClick = new ArrayList<String>();
        itemDescriptionToClick.add("Home remedies for common dental issues");
        itemDescriptionToClick.add("Proper brushing technique for max benefits");
        itemDescriptionToClick.add("Sharable dental tips");
        itemDescriptionToClick.add("Night time brushing reminder");
        itemDescriptionToClick.add("Ask questions to our expert panel");

        ArrayList<Integer> thumbnails = new ArrayList<Integer>();
        thumbnails.add(R.drawable.icon_homeremedy);
        thumbnails.add(R.drawable.icon_brushing);
        thumbnails.add(R.drawable.icon_facts);
        thumbnails.add(R.drawable.icon_healthyteeth);
        thumbnails.add(R.drawable.icon_advice);


        startListView.setAdapter(new ListViewAdapterWithImage(this, itemsToClickToStart, itemDescriptionToClick, thumbnails));

        startListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                                 @Override
                                                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                     switch (position) {
                                                         case 0:
                                                             startHomeRemedies();
                                                             break;
                                                         case 1:
                                                             startBrushingActivity();
                                                             break;
                                                         case 2:
                                                             startDentalFact();
                                                             break;
                                                         case 3:
                                                             startNightBrushingReminderActivity();
                                                             break;
                                                         case 4:
                                                             startConsultationActivity();
                                                             break;

                                                     }

                                                 }
                                             }


        );


        startService(new Intent(StartActivity.this, DownloadFactsLinkService.class));


        UnreadMessagesListener mListener = new UnreadMessagesListener() {
            @Override
            public void onUnreadMessageCountChanged(int unreadMessages) {

                Snackbar snackbar = Snackbar
                        .make(findViewById(android.R.id.content), "You have got a message!", Snackbar.LENGTH_LONG).setAction("View", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.d("New message", "Showing snackbar");
                                startConsultationActivity();
                            }
                        });
                snackbar.show();

            }
        };
        Apptentive.addUnreadMessagesListener(mListener);


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


