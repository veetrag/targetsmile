package com.targetsmile.dentalcare.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.view.Window;
import android.util.DisplayMetrics;

import com.flurry.android.FlurryAgent;
import com.targetsmile.dentalcare.R;
import com.targetsmile.dentalcare.activities.StartActivity;


public class BrushingTechniqueActivity extends AppCompatActivity {



    MediaPlayer mediaPlayer;

    TextView timerTextView;
    TextView messageTextView;
    TextView positionTextView;

    CountDownTimer countDownTimer;
    Button startButton;
    ProgressBar progressBar;

    ImageView imageViewStep1;
    ImageView imageViewStep2;
    ImageView imageViewStep3;
    ImageView imageViewStep4;

    TextView finalTextView;
    Button backButton;
    Button restartButton;
    ImageView brushingBackgroundImage;

 //   ImageView imageStartUp;



    public void goBack(View view)
    {
        Intent myIntent = new Intent(this, StartActivity.class);
        this.startActivity(myIntent);

    }

    public void resetTimer() {

        FlurryAgent.logEvent("Brushing Technique Activity - Completed");

        mediaPlayer.stop();

        timerTextView.setText("");
        progressBar.setVisibility(View.INVISIBLE);
        positionTextView.setVisibility(View.INVISIBLE);
        messageTextView.setVisibility(View.INVISIBLE);

        countDownTimer.cancel();
       // startButton.setVisibility(View.VISIBLE);



        imageViewStep1.animate().alpha(0).setDuration(000).start();
        imageViewStep2.animate().alpha(0).setDuration(000).start();
        imageViewStep3.animate().alpha(0).setDuration(000).start();
        imageViewStep4.animate().alpha(0).setDuration(000).start();


        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/jennasue.ttf");
        finalTextView.setTypeface(typeFace);

        finalTextView.setVisibility(View.VISIBLE);


        /* Converting DP into Pixels */
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        float dp = 100f;
        float fpixels = metrics.density * dp;
        int pixels = (int) (fpixels + 0.5f);
        /* Conversion ends */

        backButton.setWidth(pixels);
        backButton.setHeight(pixels);

        backButton.setVisibility(View.VISIBLE);
        backButton.animate().alpha(1).setDuration(1500).start();
        // startButton.setText(R.string.step1_brushing);


    }

    public void updateTimer(int secondsLeft) {

        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String secondString = Integer.toString(seconds);

        if (seconds <= 9) {

            secondString = "0" + secondString;

        }

        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);

    }



    public void brushingStep(int stepNumber)
    {




        switch(stepNumber)
        {

            // Step 1 - Move your brush top to bottom (front teeth) - 20 seconds

            // Step 2 - Move your brush in circular motion (back teeth) - 20 seconds left
            // step 3 - 20 seconds right

            // Step 4 - Move your brush back and forth (chewing surface) - (a) 10 up left,
            // Step 5 10 up right,
            // Step 6 10 down left,
            // Step 7 10 down right
            // Step 8 place your brush at 45degree and move in sweeping motion (inside surface) - 10 seconds up,
            // Step 9 10 seconds down

            case 1:

                imageViewStep1.animate().alpha(1).setDuration(300).start();
                messageTextView.setText(R.string.step1_brushing);
                positionTextView.setText(R.string.location_front_outside_sufrace);
                break;
            case 2:
                imageViewStep1.animate().alpha(0).setDuration(1000).start();
                imageViewStep2.animate().alpha(1).setDuration(1000).start();
                messageTextView.setText(R.string.step2_brushing);
                positionTextView.setText(R.string.location_right);
                break;
            case 3:
                positionTextView.setText(R.string.location_left);
                break;
            case 4:
                imageViewStep2.animate().alpha(0).setDuration(1000).start();
                imageViewStep3.animate().alpha(1).setDuration(1000).start();
                messageTextView.setText(R.string.step3_brushing);
                positionTextView.setText(R.string.location_top_left);
                break;
            case 5:
                positionTextView.setText(R.string.location_bottom_left);
                break;
            case 6:
                positionTextView.setText(R.string.location_bottom_right);
                break;
            case 7:
                positionTextView.setText(R.string.location_top_right);
                break;
            case 8:
                imageViewStep3.animate().alpha(0).setDuration(1000).start();
                imageViewStep4.animate().alpha(1).setDuration(1000).start();
                messageTextView.setText(R.string.step4_brushing);
                positionTextView.setText(R.string.location_front_top);
                break;
            case 9:
                positionTextView.setText(R.string.location_front_bottom);
                break;

        }

    }


    public void restartBrushing(View view)
    {
        FlurryAgent.logEvent("Brushing Technique Activity - Restart");

        mediaPlayer.stop();

        timerTextView.setText("");
        progressBar.setVisibility(View.INVISIBLE);
        positionTextView.setVisibility(View.INVISIBLE);
        messageTextView.setVisibility(View.INVISIBLE);

        countDownTimer.cancel();

        imageViewStep1.animate().alpha(0).setDuration(000).start();
        imageViewStep2.animate().alpha(0).setDuration(000).start();
        imageViewStep3.animate().alpha(0).setDuration(000).start();
        imageViewStep4.animate().alpha(0).setDuration(000).start();


        startButton.setVisibility(View.VISIBLE);
        brushingBackgroundImage.setVisibility(View.VISIBLE);

        restartButton.setVisibility(View.GONE);

        backButton.setVisibility(View.GONE);
        backButton.setWidth(0);
        backButton.setHeight(0);


    }


    public void startBrushing(View view) {


        FlurryAgent.logEvent("Brushing Technique Activity - Start");

        mediaPlayer = MediaPlayer.create(this, R.raw.bubblegum_ballgame_low);
        mediaPlayer.start();



     //   imageStartUp.animate().alpha(0).setDuration(300).start();
     //   imageStartUp.setVisibility(View.INVISIBLE);

        startButton.setVisibility(View.INVISIBLE);
        brushingBackgroundImage.setVisibility(View.INVISIBLE);

        progressBar.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        restartButton.setVisibility(View.VISIBLE);


        positionTextView.setBackgroundColor(12);
        messageTextView.setText(R.string.step1_brushing);
        positionTextView.setText(R.string.location_bottom_left);

        countDownTimer = new CountDownTimer(120000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished / 1000);

                progressBar.setProgress(120 - (int) (millisUntilFinished / 1000));

             //   Log.d("Status: ", "" + millisUntilFinished + " " + step1 + " " + step2 + " " + step3 + " " + step4);


                if (millisUntilFinished >= 119000 && millisUntilFinished <= 120000)
                {
                    brushingStep(1);
                }

                if (millisUntilFinished >= 99000 && millisUntilFinished <= 100000)
                {
                    brushingStep(2);
                }

                if (millisUntilFinished >= 79000 && millisUntilFinished <= 80000)
                {
                    brushingStep(3);
                }

                if (millisUntilFinished >= 59000 && millisUntilFinished <= 60000)
                {
                    brushingStep(4);
                }

                if (millisUntilFinished >= 49000 && millisUntilFinished <= 50000)
                {
                    brushingStep(5);
                }

                if (millisUntilFinished >= 39000 && millisUntilFinished <= 40000)
                {
                    brushingStep(6);
                }

                if (millisUntilFinished >= 29000 && millisUntilFinished <= 30000)
                {
                    brushingStep(7);
                }

                if (millisUntilFinished >= 19000 && millisUntilFinished <= 20000)
                {
                    brushingStep(8);
                }

                if (millisUntilFinished >= 9000 && millisUntilFinished <= 10000)
                {
                    brushingStep(9);
                }



            }

            @Override
            public void onFinish() {
                resetTimer();
            }

        }.start();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_brushing_technique);


        timerTextView = (TextView) findViewById(R.id.timerTextView);
        messageTextView = (TextView) findViewById(R.id.messageTextView);
        positionTextView = (TextView) findViewById(R.id.positionTextView);

        startButton = (Button) findViewById(R.id.startButton);
        backButton = (Button) findViewById(R.id.backButton);
        restartButton = (Button) findViewById(R.id.restartButton);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        imageViewStep1 = (ImageView) findViewById(R.id.imageViewStep1);
        imageViewStep2 = (ImageView) findViewById(R.id.imageViewStep2);
        imageViewStep3 = (ImageView) findViewById(R.id.imageViewStep3);
        imageViewStep4 = (ImageView) findViewById(R.id.imageViewStep4);

        brushingBackgroundImage = (ImageView) findViewById(R.id.brushingBackgroundImage);

        finalTextView = (TextView) findViewById(R.id.finalTextView);


        backButton.setVisibility(View.GONE);
        backButton.setWidth(0);
        backButton.setHeight(0);

        restartButton.setVisibility(View.GONE);

       // restartButton.setWidth(0);
       // restartButton.setWidth(0);


        timerTextView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);






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

        if(mediaPlayer!=null)
            mediaPlayer.stop();

        this.finish();
    }


}
