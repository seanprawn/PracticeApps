package com.example.powerreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private CustomReceiver mReceiver = new CustomReceiver();
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    protected void onDestroy() {
        //Unregister the receiver
        this.unregisterReceiver(mReceiver);

        //Unregister the local receiver
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Intent filters specify the types of intents a component can receive.
        They are used in filtering out the intents based on Intent values like action and category. */
        IntentFilter filter = new IntentFilter();

        /* When the system receives an Intent as a broadcast,
        it searches the broadcast receivers based on the action value specified in the IntentFilter object. */
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);

        /* register the receiver using the MainActivity context.
        This receiver is active and able to receive broadcasts as long as the MainActivity is running. */
        this.registerReceiver(mReceiver, filter);


        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReceiver,
                        new IntentFilter(ACTION_CUSTOM_BROADCAST));

    }

    public void sendCustomBroadcast(View view) {
        /* By keeping broadcasts local, you ensure that your app data isn't shared with other Android apps */
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        int num = new Random().nextInt(10);
        Log.d(LOG_TAG, "sendCustomBroadcast: NUMBER"+num);
        customBroadcastIntent.putExtra("randomInt", num);

        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}