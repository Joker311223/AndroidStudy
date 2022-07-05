package com.example.myapplicationstpicasso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.button);
        ImageView iv = findViewById(R.id.imageView);
        bt.setOnClickListener(v -> {
            Picasso.with(MainActivity.this).load("https://w.wallhaven.cc/full/y8/wallhaven-y8622k.jpg").into(iv);
        });

    }
}