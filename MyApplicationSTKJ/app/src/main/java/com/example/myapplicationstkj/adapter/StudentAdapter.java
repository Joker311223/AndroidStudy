package com.example.myapplicationstkj.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplicationstkj.R;
import com.example.myapplicationstkj.dao.Student;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    int resourceId;

    public StudentAdapter(@NonNull Context context, int resource, List<Student> lists) {
        super(context, resource, lists);
        resourceId = resource;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student item = getItem(position);
        View view = convertView == null ? LayoutInflater.from(getContext()).inflate(resourceId, parent, false) : convertView;
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.student_name);
        textView.setText(item.getName());
        imageView.setImageResource(R.drawable.test1);
        return view;
    }
}
