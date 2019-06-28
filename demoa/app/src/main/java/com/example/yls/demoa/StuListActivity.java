package com.example.yls.demoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class StuListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentApdater studentApdater;
    private ArrayList<Student> studentArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_list);

        recyclerView = findViewById(R.id.stu_list);
        studentApdater = new StudentApdater(studentArrayList);
        recyclerView.setAdapter(studentApdater);
        recyclerView.setLayoutManager(new LinearLayoutManager(StuListActivity.this));
        getDataFromBmob();
    }

    private void getDataFromBmob() {
        BmobQuery<Student> studentBmobQuery = new BmobQuery<>();
//        studentBmobQuery.addWhereEqualTo("age", 20);
        studentBmobQuery.findObjects(new FindListener<Student>() {
            @Override
            public void done(List<Student> list, BmobException e) {
                if(e == null){
                    Log.e("Bmob", "size =" + list.size());
                    studentArrayList.addAll(list);
                    studentApdater.notifyDataSetChanged();
                }else {
                    Log.e("Bmob", e.getMessage());
                }
            }
        });
    }
}
