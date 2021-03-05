package com.example.simpledatetimecalculator.ui.twoDates;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TwoDatesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TwoDatesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Two Dates fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}