package com.example.yls.demoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;

public class MainActivity extends AppCompatActivity {
    private Button btn_info;
    private Button btn_reg;
    private Button btn_log;
    private Button btn_add;
    private Button btn_query;
    private Button btn_del;
    private Button btn_list;
    private ImageView iv_head;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBtns();
    }

    private void initBtns() {
        btn_info = findViewById(R.id.btn_info);
        btn_reg = findViewById(R.id.btn_reg);
        btn_log = findViewById(R.id.btn_log);
        btn_add = findViewById(R.id.btn_add);
        btn_query = findViewById(R.id.btn_query);
        btn_del = findViewById(R.id.btn_del);
        iv_head = findViewById(R.id.iv_head);
        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StuListActivity.class);
                startActivity(intent);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filePath = "/mnt/shared/Image/dog4.jpg";
                final BmobFile headimg = new BmobFile(new File(filePath));
                headimg.upload(new UploadFileListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e == null){
                            Log.e("Bmob","文件上传成功");
                            Student student = new Student();
                            student.setName("梁敏怡");
                            student.setAge(20);
                            student.setProfession("软件");
                            student.setScore(100);
                            student.setHeadimg(headimg);
                            student.save(new SaveListener<String>() {
                                @Override
                                public void done(String s, BmobException e) {
                                    if(e == null){
                                        toast("保存成功 " + s);
                                    }else{
                                        toast("保存失败 " + e.getMessage());
                                    }
                                }
                            });
                        }else{
                            Log.e("Bmob","文件上传失败");
                        }
                    }
                });
            }
        });
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobQuery<Student> studentBmobQuery = new BmobQuery<>();
//                studentBmobQuery.addWhereEqualTo("profession","软件");
//                studentBmobQuery.addWhereEqualTo("age",21);
                studentBmobQuery.addWhereEqualTo("name","梁敏怡");
                studentBmobQuery.findObjects(new FindListener<Student>() {
                    @Override
                    public void done(List<Student> list, BmobException e) {
                        if(e == null){
                            StringBuffer stringBuffer = new StringBuffer();
                            for(Student student: list){
                                stringBuffer.append(student).append("\n");
                                BmobFile headimg = student.getHeadimg();
                                Log.e("Bmob", "fileUrl = " + headimg.getFileUrl());
                                Log.e("Bmob", "url = " + headimg.getUrl());
                                Glide.with(MainActivity.this).load(headimg.getUrl()).into(iv_head);
                            }
                            toast(stringBuffer.toString());
                        }
                    }
                });

            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobQuery<Student> studentBmobQuery = new BmobQuery<>();
                studentBmobQuery.addWhereEqualTo("profession","软件");
                studentBmobQuery.addWhereEqualTo("age",18);
                studentBmobQuery.findObjects(new FindListener<Student>() {
                    @Override
                    public void done(List<Student> list, BmobException e) {
                        if(e == null){
                            for(Student student: list){
                                student.delete(new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        if(e == null){
                                            toast("删除成功 " );
                                        }else{
                                            toast("删除失败 " + e.getMessage());
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                useBmobUserReg();
                useMyUserReg();
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BmobUser bmobUser = new BmobUser();
                bmobUser.setUsername("王源");
                bmobUser.setPassword("123456");
                bmobUser.login(new SaveListener<BmobUser>() {
                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e == null){
                            toast("登录成功 " + bmobUser.getUsername());
                        }else{
                            toast("登录失败 " + e.getMessage());
                        }
                    }
                });
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyUser myUser = BmobUser.getCurrentUser(MyUser.class);
                myUser.setSex("男");
                myUser.setAge(18);
                myUser.update(new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if(e == null){
                            toast("更新成功 " );
                        }else{
                            toast("更新失败 " + e.getMessage());
                        }
                    }
                });
            }
        });
    }

    private void useMyUserReg() {
        MyUser myUser = new MyUser();
        myUser.setUsername("周杰伦");
        myUser.setPassword("123456");
        myUser.setAge(40);
        myUser.setSex("男");
        myUser.signUp(new SaveListener<MyUser>() {
            @Override
            public void done(MyUser myUser, BmobException e) {
                if(e == null){
                    toast("注册成功 " + myUser.getUsername());
                }else{
                    toast("注册失败 " + e.getMessage());
                }
            }
        });

    }

    private void useBmobUserReg() {
        BmobUser bmobUser = new BmobUser();
        bmobUser.setUsername("杨超越");
        bmobUser.setPassword("12345678");
        bmobUser.signUp(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e == null){
                    toast("注册成功 " + bmobUser.getUsername());
                }else{
                    toast("注册失败 " + e.getMessage());
                }
            }
        });
    }

    private void toast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }
}
