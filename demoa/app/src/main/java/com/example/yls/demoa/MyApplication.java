package com.example.yls.demoa;

import android.app.Application;

import cn.bmob.v3.Bmob;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "f77f54dc95756514ce1c4341755802e9");
    }
}
