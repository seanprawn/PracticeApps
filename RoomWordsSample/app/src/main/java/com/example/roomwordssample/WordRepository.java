package com.example.roomwordssample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

//    Add a constructor that gets a handle to the database and initializes the member variables.
        WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

/* Add a wrapper method called getAllWords() that returns the cached words as LiveData.
    Room executes all queries on a separate thread. Observed LiveData notifies the observer when the data changes. */
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

/* Add a wrapper for the insert() method.
    Use an AsyncTask to call insert() on a non-UI thread, or your app will crash.
    Room ensures that you don't do any long-running operations on the main thread, which would block the UI. */
    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

//    Create the insertAsyncTask as an inner class.
    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
