package com.example.adjs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView my_webview;
    private Button btn_callJS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_webview = findViewById(R.id.my_webview);
        btn_callJS = findViewById(R.id.btn_callJS);

        WebSettings webSettings = my_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        my_webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("安卓的警告框")
                        .setMessage(message)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                   dialogInterface.cancel();
                                   result.confirm();
                            }
                        }).create();
                alertDialog.show();
                return true;
            }
        });


        my_webview.loadUrl("file:///android_asset/test.html");
        my_webview.addJavascriptInterface(new JStoAndroid(MainActivity.this), "android");
        my_webview.addJavascriptInterface(new Jump(MainActivity.this), "jump");

        btn_callJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 第一种方法
//                my_webview.loadUrl("javascript:callJS()");

                // 第二种方法
                my_webview.evaluateJavascript(
                        "javascript:callJS()",
                        new ValueCallback<String>() {
                            @Override
                            public void onReceiveValue(String s) {
//                                Log.e("MainActivity", "s = " + s);
//                                Toast.makeText(MainActivity.this,
//                                        "圆的面积是"  + s, Toast.LENGTH_SHORT)
//                                        .show();
                            }
                        });
            }
        });
    }
}
