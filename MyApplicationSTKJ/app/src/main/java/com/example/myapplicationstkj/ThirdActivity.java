package com.example.myapplicationstkj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.myapplicationstkj.adapter.StudentAdapter2;
import com.example.myapplicationstkj.dao.Student;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        List<Student> list = new ArrayList<>();
        list.add(new Student("a", 1987));
        list.add(new Student("a", 1987));
        list.add(new Student("a", 1987));
        list.add(new Student("a", 1987));
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        StudentAdapter2 studentAdapter2 = new StudentAdapter2(list);
        recyclerView.setAdapter(studentAdapter2);
    }
}