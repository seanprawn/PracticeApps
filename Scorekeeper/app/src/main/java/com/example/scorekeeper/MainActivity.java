package com.example.scorekeeper;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;
    private TextView mScoreText1;
    private TextView mScoreText2;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.scorekeeper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = (TextView)findViewById(R.id.score_1);
        mScoreText2 = (TextView)findViewById(R.id.score_2);

//        if (savedInstanceState != null)
//        {
//            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
//            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);
//
//            //Set the score text views
//            mScoreText1.setText(String.valueOf(mScore1));
//            mScoreText2.setText(String.valueOf(mScore2));
//
//        }
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE); //init shared prefs
        //Restore preferences
        mScore1 = mPreferences.getInt(STATE_SCORE_1,0);
        mScore2 = mPreferences.getInt(STATE_SCORE_2,0);

//        Set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
    }

    public void decreaseScore(View view) {
        int viewId = view.getId();
        switch (viewId)
        {
            case R.id.decreaseTeam1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID){
            //If it was on Team 1
            case R.id.increaseTeam1:
                //Increment the score and update the TextView
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            //If it was Team 2
            case R.id.increaseTeam2:
                //Increment the score and update the TextView
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }
    /* TODO
    *   Android fundamentals 05.1: Drawables, styles, and themes
     * 
     * **************************************************************
     * Challenge 1 - StateList Drawable buttons! ---- Still to do Sean!
     * ***************************************************************
     * */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode)
        {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES)
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect.
            recreate();
        }
            return true;
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        // Save the scores.
//        outState.putInt(STATE_SCORE_1, mScore1);
//        outState.putInt(STATE_SCORE_2, mScore2);
//        super.onSaveInstanceState(outState);
//    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor prefsEditor = mPreferences.edit();
        prefsEditor.putInt(STATE_SCORE_1, mScore1);
        prefsEditor.putInt(STATE_SCORE_2, mScore2);
        prefsEditor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;    }

    public void clearScores(View view) {
        int clearedScore = 0;
        mScore1 = clearedScore;
        mScore2 = clearedScore;
        mScoreText1.setText(String.valueOf(clearedScore));
        mScoreText2.setText(String.valueOf(clearedScore));

        SharedPreferences.Editor prefs = mPreferences.edit();
        prefs.clear();
        prefs.apply();
    }
}