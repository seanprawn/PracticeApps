package com.example.navigationdrawertoast.ui.tools;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the Tools Fragment bitch!");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
