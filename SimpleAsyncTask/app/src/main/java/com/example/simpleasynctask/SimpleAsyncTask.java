package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Void, Void, String> {

    private WeakReference<TextView> mTextView;
    public int mProgressTime;

    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);


        mTextView.get().setText("Time so far : "+mProgressTime);
        /* TODO
        * 6. Coding challenge
        * update the UI with the current sleep time.
        * */
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);
        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n* 200;
        publishProgress();
        mProgressTime = s;
        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

    /* TODO
    * Android fundamentals 07.1: AsyncTask
    * Homework
    * Add a ProgressBar that displays the percentage of sleep time completed.
    * The progress bar fills up as the AsyncTask thread sleeps from a value of 0 to 100 (percent).
    * Hint: Break up the sleep time into chunks.
    * For help, see the AsyncTask reference.
    * https://developer.android.com/codelabs/android-training-create-asynctask?index=..%2F..%2Fandroid-training#9
    *
    * */
}
