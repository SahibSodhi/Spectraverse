package com.spectraverse.spectraverse.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spectraverse.spectraverse.R;

public class SplashActivity extends Activity {

    private ImageView iv;
    private ImageView partner;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    LinearLayout layout;
    Thread splashThread;
    Animation anim, sequential;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StartAnimations();
    }

    private void StartAnimations() {
        iv = findViewById(R.id.splash);
        partner = findViewById(R.id.partner);
        /*textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);*/
        layout = findViewById(R.id.text_layout);
        textView3 = findViewById(R.id.textView3);

        anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        /*iv.startAnimation(anim);*/

        sequential = AnimationUtils.loadAnimation(this, R.anim.sequential);
        layout.setAnimation(anim);
        textView3.setAnimation(sequential);
        partner.setAnimation(sequential);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
            }
        }, 2000);


    }

    private void startNextActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}