package com.example.batteryindicatorapp;

import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    LevelListDrawable levelList;
    public int batLevel = 0;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.ic_battery_level_list);
        levelList = (LevelListDrawable) imageView.getBackground();
    }

    public void downClick(View view) {
        if (batLevel > 0) {
            batLevel--;
            imageView.setImageLevel(batLevel);
        }

    }

    public void upClick(View view) {
        if (batLevel >= 0 && batLevel <= 9)
        {
            batLevel++;
            if (batLevel ==1) batLevel++;
            imageView.setImageLevel(batLevel);
        }
    }
}