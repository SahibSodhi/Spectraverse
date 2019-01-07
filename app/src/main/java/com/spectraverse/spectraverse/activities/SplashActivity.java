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
import android.widget.TextView;

import com.spectraverse.spectraverse.R;

public class SplashActivity extends Activity {

    private ImageView iv;
    private ImageView partner;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

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
        partner =findViewById(R.id.partner);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        /*iv.startAnimation(anim);*/

        sequential = AnimationUtils.loadAnimation(this, R.anim.sequential);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
            }
        }, 3000);


    }

    private void startNextActivity() {
            textView1.startAnimation(anim);
            textView2.startAnimation(anim);
            textView3.startAnimation(sequential);
            partner.startAnimation(sequential);
            Intent intent=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
    }

}
