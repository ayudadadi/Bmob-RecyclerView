package com.example.yls.demoa;

import android.app.Application;

import cn.bmob.v3.Bmob;



public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "d58af2cbe7fc5b7110933a081305a2a2");
    }
}
