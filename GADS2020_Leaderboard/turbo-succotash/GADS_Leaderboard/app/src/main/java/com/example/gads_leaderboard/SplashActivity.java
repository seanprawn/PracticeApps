package com.example.gads_leaderboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int SPLASH_DISPLAY_LENGTH = 3000;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Main-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
//        startActivity(new Intent(SplashActivity.this, MainActivity.class));
//        finish();
    }


