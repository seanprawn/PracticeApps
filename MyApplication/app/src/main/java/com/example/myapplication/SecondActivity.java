package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
//        intent.getExtras(MainActivity.EXTRA_MESSAGE);
        String stringExtra = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.d(LOG_TAG, "onCreate: INTENT EXTRAS"+stringExtra);

        Toast.makeText(this.getApplicationContext(), stringExtra,
                Toast.LENGTH_SHORT).show();

//        Toast toast = new Toast(getApplicationContext());
//        toast.setText(stringExtra);
//        toast.setDuration(Toast.LENGTH_SHORT);

//                (getApplicationContext(), stringExtra, Toast.LENGTH_SHORT);

    }
}