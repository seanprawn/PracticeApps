package com.example.roomwordssample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    //** Changed to accommodate Livedata***
//    @Query("SELECT * from word_table ORDER BY word ASC")
//    List<Word> getAllWords();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

//    Get 1 word from the db to see if there is any data at the moment
    @Query("SELECT * from word_table LIMIT 1")
    Word[] getAnyWord();

  /** Because this operation deletes a single row,
   * the @Delete annotation is all that is needed to delete the word from the database */
    @Delete
    void deleteWord(Word word);

    @Update
    void update(Word... word);

}
