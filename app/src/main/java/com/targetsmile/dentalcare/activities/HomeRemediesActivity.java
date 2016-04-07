package com.targetsmile.dentalcare.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.flurry.android.FlurryAgent;
import com.targetsmile.dentalcare.R;

public class HomeRemediesActivity extends AppCompatActivity {



    public void startBleedingGumsDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Bleeding Gums");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","bleedinggums");
        this.startActivity(myIntent);
    }

    public void startToothAcheDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Tooth Ache");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","toothache");
        this.startActivity(myIntent);
    }

    public void startOralUlcersDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Oral Ulcers");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","oralulcers");
        this.startActivity(myIntent);
    }

    public void startStainedTeethDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Stained Teeth");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","stainedteeth");
        this.startActivity(myIntent);
    }

    public void startSensitivityDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Sensitivity");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","sensitivity");
        this.startActivity(myIntent);
    }


    public void startBadBreathDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Bad Breath");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","badbreath");
        this.startActivity(myIntent);
    }


    public void startGeneralCareDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - General Care");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","generalcare");
        this.startActivity(myIntent);

    }

    public void startFoodLodgementDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Food Lodgement");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","foodlodgement");
        this.startActivity(myIntent);

    }

    public void startCavityDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Cavity");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","cavity");
        this.startActivity(myIntent);

    }


    public void startRestrictedMouthOpeningDetailsActivity(View view)
    {
        FlurryAgent.logEvent("Home Remedies - Restricted Mouth Opening");
        Intent myIntent = new Intent(HomeRemediesActivity.this, HomeRemedyDetails.class);
        myIntent.putExtra("remedyid","restrictedmouthopening");
        this.startActivity(myIntent);

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_remedies);


        TextView homeRemediesLogo = (TextView) findViewById(R.id.homeRemediesLogo);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/jennasue.ttf");
        homeRemediesLogo.setTypeface(typeFace);


//        Button badBreathButton = (Button) findViewById(R.id.badBreathButton);
//        Button sensitivityButton = (Button) findViewById(R.id.sensitivityButton);
//        Button toothAcheButton = (Button) findViewById(R.id.toothAcheButton);
//        Button oralUlcersButton = (Button) findViewById(R.id.oralUlcersButton);
//        Button teethStainingButton = (Button) findViewById(R.id.stainedTeethButton);
//        Button bleedingGumsButton = (Button) findViewById(R.id.bleedingGumsButton);

//        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
//        anim.reset();
//        ImageView backgroundImage = (ImageView) findViewById(R.id.imageViewBackgroundHomeRemedies);
//        backgroundImage.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
//        anim.reset();
//
//        badBreathButton.clearAnimation();
//        badBreathButton.startAnimation(anim);
//        sensitivityButton.clearAnimation();
//        sensitivityButton.startAnimation(anim);
//        toothAcheButton.clearAnimation();
//        toothAcheButton.startAnimation(anim);
//        oralUlcersButton.clearAnimation();
//        oralUlcersButton.startAnimation(anim);
//        teethStainingButton.clearAnimation();
//        teethStainingButton.startAnimation(anim);
//        bleedingGumsButton.clearAnimation();
//        bleedingGumsButton.startAnimation(anim);
//
//        anim = AnimationUtils.loadAnimation(this,R.anim.translatereverse);
//        homeRemediesLogo.clearAnimation();
//        homeRemediesLogo.startAnimation(anim);


       // Log.d("Starting", "Animation");
//        badBreathButton.animate().translationX(-500).setDuration(0).start();
//        badBreathButton.animate().translationX(+500).setDuration(2000).start();
//
//        sensitivityButton.animate().translationX(-500).setDuration(0).start();
//        sensitivityButton.animate().translationX(+500).setDuration(2000).start();
//
//        toothAcheButton.animate().translationX(-500).setDuration(0).start();
//        toothAcheButton.animate().translationX(+500).setDuration(2000).start();
//
//        oralUlcersButton.animate().translationX(-500).setDuration(0).start();
//        oralUlcersButton.animate().translationX(+500).setDuration(2000).start();
//
//        teethStainingButton.animate().translationX(-500).setDuration(0).start();
//        teethStainingButton.animate().translationX(+500).setDuration(2000).start();
//
//        bleedingGumsButton.animate().translationX(-500).setDuration(0).start();
//        bleedingGumsButton.animate().translationX(+500).setDuration(2000).start();



       // badBreathButton.animate().rotation(360).setDuration(2000).start();

//        RotateAnimation rAnim = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
//        rAnim.setRepeatCount(Animation.START_ON_FIRST_FRAME);
//        rAnim.setInterpolator(new LinearInterpolator());
//        rAnim.setDuration(2000);
///* refreshIcon is object of an imageView */
//        badBreathButton.startAnimation(rAnim);



    }



}
