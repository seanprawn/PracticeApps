package com.example.simpledatetimecalculator.ui.addTime;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddTimeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddTimeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Add a time to a Date fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}