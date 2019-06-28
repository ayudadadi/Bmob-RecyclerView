package com.example.usejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button b1;
    private Button b2;
    private Button b3;
    private String jsonstr ="[\n" +
            "    { \"id\":\"1\",\"name\":\"张三\",\"age\":\"18\" },\n" +
            "    { \"id\":\"2\",\"name\":\"李四\",\"age\":\"18\"  },\n" +
            "    { \"id\":\"3\",\"name\":\"王五\",\"age\":\"18\" }\n" +
            "]";
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;
    private ArrayAdapter<String> adapter3;
    private List<String> shengji = new ArrayList<>();
    private List<String> chengshi = new ArrayList<>();
    private List<String> quyu = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = findViewById(R.id.s1);
        spinner2 = findViewById(R.id.s2);
        spinner3 = findViewById(R.id.s3);



        findViewById(R.id.b4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSpinnerJson();
            }
        });


        findViewById(R.id.b1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJson();
            }
        });

        findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonObject();
            }
        });
        findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJsonArray();
            }
        });

    }

    private void getSpinnerJson() {
        try {
            InputStream inputStream = getResources().getAssets().open("data.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String line = bufferedReader.readLine();
            while(line!=null){
                stringBuffer.append(line);
                line = bufferedReader.readLine();
            }
            Log.e(TAG,"data = "+stringBuffer.toString());
            JSONArray jsonArray = new JSONArray(stringBuffer.toString());
            ArrayList<String> listProvince = new ArrayList<>();
            for (int i = 0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String province = jsonObject.getString("name");
                listProvince.add(province);
                adapter1 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,listProvince);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);


                spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        adapter2 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                if(province.equals("广东省")){
                    JSONArray cityArray = jsonObject.getJSONArray("city");
                    for(int j =0;j<cityArray.length();j++){
                        JSONObject cityObject = cityArray.getJSONObject(j);
                        String cityName = cityObject.getString("name");
                        Log.e(TAG,"cityName = "+ cityName);
                        if(cityName.equals("广州市")){
                            JSONArray areaArray = cityObject.getJSONArray("area");
                            for(int k = 0;k<areaArray.length();k++){
                                String areaName = areaArray.getString(k);
                                Log.e(TAG,"areaName = " +areaName);
                            }
                            return;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void getJsonArray() {
        final Student s1 = new Student("张三", 20, "17001");
        final Student s2 = new Student("张四", 21, "17002");
        final Student s3 = new Student("张五", 22, "17003");
        final ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        try{
            JSONArray jsonArray = new JSONArray();
            for (Student student : studentArrayList){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name",student.getName());
                jsonObject.put("age",student.getAge());
                jsonObject.put("stuNo",student.getStuNo());
                jsonArray.put(jsonObject);
            }
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("stuList",jsonArray);
            Log.e(TAG,"jsObject = "+jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonObject() {
        final Student s1 = new Student("张三", 20, "17001");
        final Student s2 = new Student("张四", 21, "17002");
        final Student s3 = new Student("张五", 22, "17003");
        final ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", s1.getName());
            jsonObject.put("age", s2.getAge());
            jsonObject.put("stuNo", s3.getStuNo());
            Log.e(TAG, "jsObject = " + jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJson() {
        try {
            JSONArray jsonArray = new JSONArray(jsonstr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = null;
                jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String age = jsonObject.getString("age");
                Log.e(TAG,"id = "+id+" name ="+name+" age = "+age);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
