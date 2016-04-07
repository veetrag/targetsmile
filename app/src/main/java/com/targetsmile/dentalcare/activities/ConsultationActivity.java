package com.targetsmile.dentalcare.activities;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apptentive.android.sdk.Apptentive;
import com.apptentive.android.sdk.ApptentiveActivity;
import com.targetsmile.dentalcare.R;

public class ConsultationActivity extends ApptentiveActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);

                    Apptentive.showMessageCenter(ConsultationActivity.this);


    }
}
