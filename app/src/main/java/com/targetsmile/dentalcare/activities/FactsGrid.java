package com.targetsmile.dentalcare.activities;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.GridView;

import android.content.Intent;
import android.widget.AdapterView;
import android.view.View;

import android.widget.AdapterView.OnItemClickListener;

import com.flurry.android.FlurryAgent;
import com.targetsmile.dentalcare.GridViewAdapter;
import com.targetsmile.dentalcare.R;
import com.targetsmile.dentalcare.ScrollListener;

public class FactsGrid extends AppCompatActivity {


    GridView dentalFactsGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts_grid);

        final GridViewAdapter adapter = new GridViewAdapter(this);

        dentalFactsGridView = (GridView) findViewById(R.id.dentalFactGridView);
        dentalFactsGridView.setAdapter(adapter);
        dentalFactsGridView.setOnScrollListener(new ScrollListener(this));



        dentalFactsGridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), DentalFact.class);
                // passing array index
                i.putExtra("url", adapter.getItem(position));
                startActivity(i);
            }
        });


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

