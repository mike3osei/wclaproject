package com.example.wclaproject.ui.standings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StandingsViewModel extends ViewModel  {

    private final MutableLiveData<String> mText;

    public StandingsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is standings fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
