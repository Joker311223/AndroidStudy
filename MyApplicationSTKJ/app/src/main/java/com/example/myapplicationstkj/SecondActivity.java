package com.example.myapplicationstkj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationstkj.adapter.StudentAdapter;
import com.example.myapplicationstkj.dao.Student;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActionBar supportActionBar = getSupportActionBar();
        Button button = findViewById(R.id.to3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(SecondActivity.this, ThirdActivity.class));
            }
        });
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        String[] strings = {"a", "sa", "sad", "s"};
//        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strings);
        List<Student> list = new ArrayList<>();
        list.add(new Student("a", 1987));
        list.add(new Student("a", 1987));
        list.add(new Student("a", 1987));
        list.add(new Student("a", 1987));
        StudentAdapter studentAdapter = new StudentAdapter(this, R.layout.student_item, list);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(studentAdapter);


    }
}