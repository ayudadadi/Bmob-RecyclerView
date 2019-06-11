package com.example.adjs;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;



public class JStoAndroid {
    private Context context;

    public JStoAndroid(Context context){
        this.context = context;
    }

    @JavascriptInterface
    public void hello(String str){
        Log.e("JStoAndroid", "hello " + str);
        Toast.makeText(context, "hello " + str,
                Toast.LENGTH_SHORT).show();
    }
}
