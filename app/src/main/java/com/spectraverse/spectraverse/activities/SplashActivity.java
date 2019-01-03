package com.spectraverse.spectraverse.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        final Intent intent = new Intent(SplashActivity.this, MainActivity.class);

        splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(500);
                    textView1.startAnimation(anim);
                    textView2.startAnimation(anim);
                    sleep(1000);
                    textView3.startAnimation(sequential);
                    partner.startAnimation(sequential);
                    sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    SplashActivity.this.finish();
                }

            }
        };
        splashThread.start();

    }

}