package com.targetsmile.dentalcare.activities;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;

import android.view.View;
import android.content.Intent;
import android.os.Environment;
import android.net.Uri;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import java.io.File;
import java.io.FileOutputStream;

import com.squareup.picasso.Picasso;
import com.flurry.android.FlurryAgent;
import com.targetsmile.dentalcare.R;


public class DentalFact extends AppCompatActivity {

    ImageView factImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dental_fact);

        factImageView = (ImageView) findViewById(R.id.factImageView);

        Log.d("Dental Fact: ", "Starting download...");

        Intent i = getIntent();

        String url = i.getExtras().getString("url");


        Picasso.with(this) //
                .load(url) //
                .placeholder(R.drawable.placeholder) //
                .fit().centerInside()
                .into(factImageView);


        AdView adView = (AdView) findViewById(R.id.adUnitDentalFact);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);




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


    public void onShareItem(View v) {

        FlurryAgent.logEvent("Dental Fact Activity - Fact Sharing");

        // Get access to bitmap image from view
        ImageView ivImage = (ImageView) findViewById(R.id.factImageView);
        // Get access to the URI for the bitmap
        Uri bmpUri = getLocalBitmapUri(ivImage);
        if (bmpUri != null) {
            // Construct a ShareIntent with link to image
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Shared using Target Smile - http://j.mp/targetsmile");
            shareIntent.setType("image/*");
            // Launch sharing dialog for image
            startActivity(Intent.createChooser(shareIntent, "Share Image"));
        } else {
            // ...sharing failed, handle error
        }
    }

    // Returns the URI path to the Bitmap displayed in specified ImageView
    public Uri getLocalBitmapUri(ImageView imageView) {
        // Extract Bitmap from ImageView drawable
        Drawable drawable = imageView.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable){
            bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        } else {
            return null;
        }
        // Store image to default external storage directory
        Uri bmpUri = null;
        try {
            // Use methods on Context to access package-specific directories on external storage.
            // This way, you don't need to request external read/write permission.
            // See https://youtu.be/5xVh-7ywKpE?t=25m25s
            File file =  new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }



}
