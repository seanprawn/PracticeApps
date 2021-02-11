package com.example.standup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0; //Needed to display the notification
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel"; //Needed to display the notification
  public AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //        Set up the broadcast pending intent
         Intent notifyIntent = new Intent(this, AlarmReceiver.class);

//        Use this boolean to set the state of the ToggleButton when your app starts
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent,
                PendingIntent.FLAG_NO_CREATE) != null);



        //        Set the repeating alarm

         PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);
        alarmToggle.setChecked(alarmUp);
        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                String toastMessage;
                if (isChecked){
//                    long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;
                    long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;
//                    long repeatInterval = SystemClock.elapsedRealtime();
                    long triggerTime = SystemClock.elapsedRealtime()
                            + repeatInterval;

            //If the Toggle is turned on, set the repeating alarm with a 15 minute interval
                    if (alarmManager != null)
                    {
                        alarmManager.setInexactRepeating
                                (AlarmManager.ELAPSED_REALTIME_WAKEUP,
                                        triggerTime, repeatInterval, notifyPendingIntent);
                    }
//                    deliverNotification(MainActivity.this); // CONTEXT!!!!!!!
                    //Set the toast message for the "on" case.
                    toastMessage = getString(R.string.alarm_on_notify);
                } else {
                    mNotificationManager.cancelAll(); //Removes the notification
                    if (alarmManager != null) {
                        alarmManager.cancel(notifyPendingIntent);
                    }
                    //Set the toast message for the "off" case.
                    toastMessage = getString(R.string.alarm_off_notify);
                }

                //Show a toast to say the alarm is turned on or off.
                Toast.makeText(MainActivity.this, toastMessage,Toast.LENGTH_SHORT)
                        .show();
                }
        });

        mNotificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        createNotificationChannel();







    }

    /**
     * Creates a Notification channel, for OREO and higher.
     */
    public void createNotificationChannel() {

        // Create a notification manager object.
        mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Stand up notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifies every 15 minutes to stand up and walk");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void getAlarmTime(View view)
    {
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        if (alarmManager != null)
        {
//           long nextAlarmClock = alarmManager.getNextAlarmClock().getTriggerTime();
              if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                AlarmManager.AlarmClockInfo nextAlarmClock = alarmManager.getNextAlarmClock();
                Log.d("Mainactivity", "getAlarmTime: "+nextAlarmClock);
                String message = "Next alarm: "+alarmManager.getNextAlarmClock();
                Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT)
                        .show();
                ;
            }
        }

    }


//    private void deliverNotification(Context context) {
//        Intent contentIntent = new Intent(context, MainActivity.class);
//        PendingIntent contentPendingIntent = PendingIntent.getActivity
//                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
////        Add a notification icon and build the notification
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_stand_up)
//                .setContentTitle(getString(R.string.stand_up_alert))
//                .setContentText(getString(R.string.stand_up_content))
//                .setContentIntent(contentPendingIntent)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setAutoCancel(true)
//                .setDefaults(NotificationCompat.DEFAULT_ALL);
//
//        mNotificationManager.notify(NOTIFICATION_ID, builder.build());
//
//    }

}

/* TODO
* Android fundamentals 08.2: The alarm manager
*  homework
* Make an app that delivers a notification when the time is 11:11 AM.
* The screen displays a toggle switch that turns the alarm on and off.
* 
* https://developer.android.com/codelabs/android-training-alarm-manager?index=..%2F..%2Fandroid-training#10
* */