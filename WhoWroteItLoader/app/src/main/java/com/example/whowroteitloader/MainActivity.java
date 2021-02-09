package com.example.whowroteitloader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

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

//        reconnect to the loader, if the loader already exists
        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }
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

//        new FetchBook(mTitleText, mAuthorText).execute(queryString);
        Bundle queryBundle = new Bundle();
        queryBundle.putString("queryString", queryString);
        getSupportLoaderManager().restartLoader(0, queryBundle, this);

//        mAuthorText.setText("");
//        mTitleText.setText(R.string.loading);
    }

/* called when you instantiate your loader. */
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {

        String queryString = "";

        if (args != null) {
            queryString = args.getString("queryString");
        }

        return new BookLoader(this, queryString);
    }

/*
    called when the loader's task finishes.
    This is where to add the code to update UI with the results
*/
@Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
    try {
        JSONObject jsonObject = new JSONObject(data);
        JSONArray itemsArray = jsonObject.getJSONArray("items");

        int i = 0;
        String title = null;
        String authors = null;

        while (i < itemsArray.length() &&
                (authors == null && title == null)) {
            // Get the current item information.
            JSONObject book = itemsArray.getJSONObject(i);
            JSONObject volumeInfo = book.getJSONObject("volumeInfo");

            // Try to get the author and title from the current item,
            // catch if either field is empty and move on.
            try {
                title = volumeInfo.getString("title");
                authors = volumeInfo.getString("authors");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Move to the next item.
            i++;
        }

//            Because the references to the TextView objects are WeakReference objects, you have to dereference them
//        if (title != null && authors != null) {
//            mTitleText.get().setText(title);
//            mAuthorText.get().setText(authors);
//        } else {
//            mTitleText.get().setText(R.string.no_results);
//            mAuthorText.get().setText("");
//        }

    }catch (JSONException e)
    {
        // If onPostExecute does not receive a proper JSON string,
        // update the UI to show failed results.
//        mTitleText.get().setText(R.string.no_results);
//        mAuthorText.get().setText("");
//        e.printStackTrace();
        e.printStackTrace();
    }
}
//    }

/* cleans up any remaining resources */
    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}

/* TODO
* Android fundamentals 07.2: AsyncTask and AsyncTaskLoader
* 11. Homework
* Create an app that retrieves and displays the contents of a web page that's located at a URL.
* https://developer.android.com/codelabs/android-training-asynctask-asynctaskloader?index=..%2F..%2Fandroid-training#10
*
* */