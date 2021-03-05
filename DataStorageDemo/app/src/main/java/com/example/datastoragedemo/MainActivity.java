package com.example.datastoragedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String COUNT_PREF_KEY = "pref_number_var";

    //    Saved State
    public int mNumber = 0;
    TextView mNumberView;
    TextView mTextView;
    TextView mTextViewPref;


    public String SAVE_STATE_VAR_TEXT = "save_state_text_var";
    public String SAVE_STATE_VAR_NUM = "save_state_number_var";

//    Preferences
private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.android.hellosharedprefs";
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview_first);
        mTextViewPref = (TextView) findViewById(R.id.textView_number_pref);
        mNumberView = (TextView) findViewById(R.id.textView_number);
        mNumberView.setText(String.valueOf(0));

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);


        if(savedInstanceState != null)
        {
            Log.d(TAG, "onCreate: RESTORING STATE ");
            int savedNum = savedInstanceState.getInt(SAVE_STATE_VAR_NUM);
            Log.d(TAG, "onCreate: Number to restore "+savedNum);
            int numberInView = Integer.parseInt(mNumberView.getText().toString());
            Log.d(TAG, "onCreate: Number in View "+numberInView);
            if (savedNum != numberInView)
                {
                    Log.d(TAG, "onCreate: The numbers are not the same!!");
                    mNumberView.setText(String.valueOf(savedNum));
                    mNumber = savedNum;
                }else {
            }
            String savedString = savedInstanceState.getString(SAVE_STATE_VAR_TEXT);
            if (savedString != "")
            {
            Log.d(TAG, "onCreate: String restored "+savedString);
                mTextView.setText(savedString);
            }
        }

        mCount = mPreferences.getInt(COUNT_PREF_KEY, 0);
        mTextViewPref.setText(String.format("%s", mCount));

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();

        preferencesEditor.putInt(COUNT_PREF_KEY, mNumber);
        preferencesEditor.apply();
//        preferencesEditor.putInt(COLOR_KEY, mColor);
    }

    public void ChangeNumber(View view) {
        mNumber++;
        mNumberView.setText(String.valueOf(mNumber));
        mCount = mNumber;
        mTextViewPref.setText(String.format("%s", mCount));

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: Saving the State");
        if (mTextView.getText().toString() != "") outState.putString(SAVE_STATE_VAR_TEXT, mTextView.getText().toString());
//       int numberInView = Integer.parseInt(mNumberView.getText().toString());
        int numberInState = outState.getInt(SAVE_STATE_VAR_NUM);
        if(mNumber > numberInState ) {
            Log.d(TAG, "onSaveInstanceState: NumberInState: "+numberInState);
            Log.d(TAG, "onSaveInstanceState: Number: "+mNumber);
            outState.putInt(SAVE_STATE_VAR_NUM, mNumber);
        }
    }
}