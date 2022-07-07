package com.example.myapplicationstsaveddata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;

    public LiveData<Integer> getNumber() {
        if(number == null){
            number = new MutableLiveData<>();
        }
        return number;
    }

    public void add() {
        number.setValue(number.getValue() + 1);
    }
}
