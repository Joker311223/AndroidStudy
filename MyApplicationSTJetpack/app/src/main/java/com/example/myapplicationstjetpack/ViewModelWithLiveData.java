package com.example.myapplicationstjetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {

    private MutableLiveData<Integer> age ;

    public MutableLiveData<Integer> getAge() {
        if (age == null) {
            age = new MutableLiveData<>();
            age.setValue(0);
        }
        return age;
    }


    public void addAge(int age) {
        this.age.setValue(this.age.getValue() + age);
    }

    // Rest of the ViewModel...
}