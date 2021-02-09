package com.example.whowroteitloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initialize the variables to views
        mBookInput = (EditText)findViewById(R.id.bookInput);
        mTitleText = (TextView)findViewById(R.id.titleText);
        mAuthorText = (TextView)findViewById(R.id.authorText);

    }

    public void searchBooks(View view) {
//        get the text from the EditText view. Convert the text to a String, and assign it to a variable
        String queryString = mBookInput.getText().toString();

//        hides the keyboard when the user taps the button
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null ) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

//        check the network connection
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

/*
        test the call to the FetchBook task and TextView updates
        to ensure that the network connection exists, that the network is connected, and that a
        query string is available
*/
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            new FetchBook(mTitleText, mAuthorText).execute(queryString);
            //        a loading message and clear the author TextView
            mAuthorText.setText("");
            mTitleText.setText(R.string.loading);
        }else {
            if (queryString.length() == 0) {
                mAuthorText.setText("");
                mTitleText.setText(R.string.no_search_term);
            } else {
                mAuthorText.setText("");
                mTitleText.setText(R.string.no_network);
            }
        }

        new FetchBook(mTitleText, mAuthorText).execute(queryString);


//        mAuthorText.setText("");
//        mTitleText.setText(R.string.loading);
    }
}

/* TODO
* Android fundamentals 07.2: AsyncTask and AsyncTaskLoader
* 6. Task 4. Migrate to AsyncTaskLoader
* https://developer.android.com/codelabs/android-training-asynctask-asynctaskloader?index=..%2F..%2Fandroid-training#5
* 
* */