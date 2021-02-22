package com.example.simpledatetimecalculator.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimeBetweenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TimeBetweenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the Time between 2 dates fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}