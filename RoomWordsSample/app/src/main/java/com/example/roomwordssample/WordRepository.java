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

    public void update(Word word)  {
        new updateWordAsyncTask(mWordDao).execute(word);
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

    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private WordDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    public void deleteAll()  {
        new deleteAllWordsAsyncTask(mWordDao).execute();
    }

    private static class deleteWordAsyncTask extends AsyncTask<Word, Void, Void>
    {
        private WordDao mAsyncTaskDao;

        deleteWordAsyncTask(WordDao dao)
        {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.deleteWord(params[0]);
            return null;
        }
    }

    public void deleteWord(Word word)
    {
        new deleteWordAsyncTask(mWordDao).execute(word);
    }

    /**
     *  Updates a word in the database.
     */
    private static class updateWordAsyncTask extends AsyncTask<Word, Void, Void> {
        private WordDao mAsyncTaskDao;

        updateWordAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}
