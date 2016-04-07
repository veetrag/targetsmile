package com.targetsmile.dentalcare.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.text.Html;

import com.flurry.android.FlurryAgent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.targetsmile.dentalcare.R;

public class HomeRemedyDetails extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_remedy_details);

        Intent startingIntent = getIntent();
        String whatYouSent = startingIntent.getStringExtra("remedyid");
        TextView remedyDetails = (TextView) findViewById(R.id.remedyDetailsTextView);

        int resourceid = getResourceId(whatYouSent, "string", "com.targetsmile.dentalcare");
        String contentToShow = getString(resourceid);
        remedyDetails.setText(Html.fromHtml(contentToShow));

        AdView adView = (AdView) findViewById(R.id.adUnitHomeRemedies);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }


    public int getResourceId(String pVariableName, String pResourcename, String pPackageName) {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


    public void onCloseButtonPressed(View view) {
        this.finish();
    }


    public void onStop() {
        super.onStop();

        FlurryAgent.onEndSession(this);
        // this.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }


    @Override
    public void onStart() {
        super.onStart();
        FlurryAgent.onStartSession(this);

     }
}
