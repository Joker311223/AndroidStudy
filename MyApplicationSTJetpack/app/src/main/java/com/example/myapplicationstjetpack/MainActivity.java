package com.example.myapplicationstjetpack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplicationstjetpack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ViewModelWithLiveData viewModelWithLiveData;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModelWithLiveData = new ViewModelProvider(this).get(ViewModelWithLiveData.class);
        binding.setData(viewModelWithLiveData);
        binding.setLifecycleOwner(this);
    }
}