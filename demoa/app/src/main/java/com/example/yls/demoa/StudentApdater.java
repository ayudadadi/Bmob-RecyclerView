package com.example.yls.demoa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


class StudentApdater extends RecyclerView.Adapter<StudentViewHolder>{
    private ArrayList<Student> studentArrayList;

    public StudentApdater(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.list_item, viewGroup, false);
        StudentViewHolder studentViewHolder =new StudentViewHolder(view);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
        Student student = studentArrayList.get(i);
        studentViewHolder.nameView.setText(student.getName());
        studentViewHolder.ageView.setText(String.valueOf(student.getAge()));
        Glide.with(studentViewHolder.ivHead.getContext()).load(student.getHeadimg().getUrl())
                .into(studentViewHolder.ivHead);
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }
}
