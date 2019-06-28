package com.example.volleyweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button b1;
    private TextView t1;
    private Button b2;
    private Button b3;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "13242005659";
                useVolleyStringRequest(phone);
            }
        });
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "13242005659";
                useVolleyStringRequestPost(phone);
            }
        });
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                useVolleyJSONRequest();
            }
        });
    }

    private void useVolleyJSONRequest() {
        String weatherUrl = "http://t.weather.sojson.com/api/weather/city/101280101";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(weatherUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e(TAG, jsonObject.toString());
                try {
                    String wendu = jsonObject.getJSONObject("data").getString("wendu");
                    String quality = jsonObject.getJSONObject("data").getString("quality");
                    int pm25 = jsonObject.getJSONObject("data").getInt("pm25");
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("温度:").append(wendu).append("\n");
                    stringBuffer.append("空气质量:").append(quality).append("\n");
                    stringBuffer.append("PM2.5含量:").append(pm25).append("\n");
                    t1.setText(stringBuffer.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void useVolleyStringRequestPost(final String phone) {

        String url = "https://gz.fang.com/";
        String baseUrl = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
/*
        String phoneUrl = baseUrl.concat("?mobileCode=").concat(phone).concat("&userID=");
*/
        StringRequest stringRequest = new StringRequest(Request.Method.POST, baseUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e(TAG, s);
                t1.setText(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.toString());
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("mobileCode", phone);
                map.put("userID", "");
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void useVolleyStringRequest(String phone) {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://gz.fang.com/";
        String baseUrl = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo";
        String phoneUrl = baseUrl.concat("?mobileCode=").concat(phone).concat("&userID=");
        StringRequest stringRequest = new StringRequest(phoneUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.e(TAG, s);
                t1.setText(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.toString());
            }
        });
        requestQueue.add(stringRequest);
    }
}
