package com.example.yls.demoa;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private String animalStr = "{\n" +
            "\t\"animals\":{\n" +
            "\t\"dog\":[\n" +
            "\t\t{\"name\":\"Rufus\",\"breed\":\"labrador\",\"count\":1,\"twoFeet\":false},\n" +
            "\t\t{\"name\":\"Marty\",\"breed\":\"whippet\",\"count\":1,\"twoFeet\":false}\n" +
            "\t],\n" +
            "\t\"cat\":{\"name\":\"Matilda\"}\n" +
            "}\n" +
            "}";

    private String weatherStr = "{\n" +
            "\t\"time\": \"2019-03-25 09:00:00\",\n" +
            "\t\"cityInfo\": {\n" +
            "\t\t\"city\": \"广州市\",\n" +
            "\t\t\"cityId\": \"101280101\",\n" +
            "\t\t\"parent\": \"广东\",\n" +
            "\t\t\"updateTime\": \"08:39\"\n" +
            "\t},\n" +
            "\t\"date\": \"20190325\",\n" +
            "\t\"message\": \"Success !\",\n" +
            "\t\"status\": 200,\n" +
            "\t\"data\": {\n" +
            "\t\t\"shidu\": \"99%\",\n" +
            "\t\t\"pm25\": 5.0,\n" +
            "\t\t\"pm10\": 6.0,\n" +
            "\t\t\"quality\": \"优\",\n" +
            "\t\t\"wendu\": \"13\",\n" +
            "\t\t\"ganmao\": \"各类人群可自由活动\",\n" +
            "\t\t\"yesterday\": {\n" +
            "\t\t\t\"date\": \"24\",\n" +
            "\t\t\t\"sunrise\": \"06:29\",\n" +
            "\t\t\t\"high\": \"高温 17.0℃\",\n" +
            "\t\t\t\"low\": \"低温 12.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:39\",\n" +
            "\t\t\t\"aqi\": 15.0,\n" +
            "\t\t\t\"ymd\": \"2019-03-24\",\n" +
            "\t\t\t\"week\": \"星期日\",\n" +
            "\t\t\t\"fx\": \"无持续风向\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"中雨\",\n" +
            "\t\t\t\"notice\": \"记得随身携带雨伞哦\"\n" +
            "\t\t},\n" +
            "\t\t\"forecast\": [{\n" +
            "\t\t\t\"date\": \"25\",\n" +
            "\t\t\t\"sunrise\": \"06:28\",\n" +
            "\t\t\t\"high\": \"高温 19.0℃\",\n" +
            "\t\t\t\"low\": \"低温 14.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:40\",\n" +
            "\t\t\t\"aqi\": 18.0,\n" +
            "\t\t\t\"ymd\": \"2019-03-25\",\n" +
            "\t\t\t\"week\": \"星期一\",\n" +
            "\t\t\t\"fx\": \"无持续风向\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"小雨\",\n" +
            "\t\t\t\"notice\": \"雨虽小，注意保暖别感冒\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"26\",\n" +
            "\t\t\t\"sunrise\": \"06:27\",\n" +
            "\t\t\t\"high\": \"高温 24.0℃\",\n" +
            "\t\t\t\"low\": \"低温 16.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:40\",\n" +
            "\t\t\t\"aqi\": 69.0,\n" +
            "\t\t\t\"ymd\": \"2019-03-26\",\n" +
            "\t\t\t\"week\": \"星期二\",\n" +
            "\t\t\t\"fx\": \"无持续风向\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"27\",\n" +
            "\t\t\t\"sunrise\": \"06:26\",\n" +
            "\t\t\t\"high\": \"高温 26.0℃\",\n" +
            "\t\t\t\"low\": \"低温 20.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:41\",\n" +
            "\t\t\t\"aqi\": 52.0,\n" +
            "\t\t\t\"ymd\": \"2019-03-27\",\n" +
            "\t\t\t\"week\": \"星期三\",\n" +
            "\t\t\t\"fx\": \"无持续风向\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"28\",\n" +
            "\t\t\t\"sunrise\": \"06:25\",\n" +
            "\t\t\t\"high\": \"高温 27.0℃\",\n" +
            "\t\t\t\"low\": \"低温 20.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:41\",\n" +
            "\t\t\t\"aqi\": 55.0,\n" +
            "\t\t\t\"ymd\": \"2019-03-28\",\n" +
            "\t\t\t\"week\": \"星期四\",\n" +
            "\t\t\t\"fx\": \"无持续风向\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"29\",\n" +
            "\t\t\t\"sunrise\": \"06:24\",\n" +
            "\t\t\t\"high\": \"高温 25.0℃\",\n" +
            "\t\t\t\"low\": \"低温 18.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:41\",\n" +
            "\t\t\t\"aqi\": 52.0,\n" +
            "\t\t\t\"ymd\": \"2019-03-29\",\n" +
            "\t\t\t\"week\": \"星期五\",\n" +
            "\t\t\t\"fx\": \"无持续风向\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"小雨\",\n" +
            "\t\t\t\"notice\": \"雨虽小，注意保暖别感冒\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"30\",\n" +
            "\t\t\t\"sunrise\": \"06:23\",\n" +
            "\t\t\t\"high\": \"高温 25.0℃\",\n" +
            "\t\t\t\"low\": \"低温 19.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:42\",\n" +
            "\t\t\t\"aqi\": 57.0,\n" +
            "\t\t\t\"ymd\": \"2019-03-30\",\n" +
            "\t\t\t\"week\": \"星期六\",\n" +
            "\t\t\t\"fx\": \"无持续风向\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"31\",\n" +
            "\t\t\t\"sunrise\": \"06:22\",\n" +
            "\t\t\t\"high\": \"高温 24.0℃\",\n" +
            "\t\t\t\"low\": \"低温 18.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:42\",\n" +
            "\t\t\t\"ymd\": \"2019-03-31\",\n" +
            "\t\t\t\"week\": \"星期日\",\n" +
            "\t\t\t\"fx\": \"无持续风向\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"01\",\n" +
            "\t\t\t\"sunrise\": \"06:21\",\n" +
            "\t\t\t\"high\": \"高温 26.0℃\",\n" +
            "\t\t\t\"low\": \"低温 18.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:42\",\n" +
            "\t\t\t\"ymd\": \"2019-04-01\",\n" +
            "\t\t\t\"week\": \"星期一\",\n" +
            "\t\t\t\"fx\": \"东北风\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"02\",\n" +
            "\t\t\t\"sunrise\": \"06:20\",\n" +
            "\t\t\t\"high\": \"高温 26.0℃\",\n" +
            "\t\t\t\"low\": \"低温 18.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:43\",\n" +
            "\t\t\t\"ymd\": \"2019-04-02\",\n" +
            "\t\t\t\"week\": \"星期二\",\n" +
            "\t\t\t\"fx\": \"东南风\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"晴\",\n" +
            "\t\t\t\"notice\": \"愿你拥有比阳光明媚的心情\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"03\",\n" +
            "\t\t\t\"sunrise\": \"06:19\",\n" +
            "\t\t\t\"high\": \"高温 27.0℃\",\n" +
            "\t\t\t\"low\": \"低温 20.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:43\",\n" +
            "\t\t\t\"ymd\": \"2019-04-03\",\n" +
            "\t\t\t\"week\": \"星期三\",\n" +
            "\t\t\t\"fx\": \"南风\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"小雨\",\n" +
            "\t\t\t\"notice\": \"雨虽小，注意保暖别感冒\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"04\",\n" +
            "\t\t\t\"sunrise\": \"06:18\",\n" +
            "\t\t\t\"high\": \"高温 30.0℃\",\n" +
            "\t\t\t\"low\": \"低温 22.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:43\",\n" +
            "\t\t\t\"ymd\": \"2019-04-04\",\n" +
            "\t\t\t\"week\": \"星期四\",\n" +
            "\t\t\t\"fx\": \"南风\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"05\",\n" +
            "\t\t\t\"sunrise\": \"06:18\",\n" +
            "\t\t\t\"high\": \"高温 31.0℃\",\n" +
            "\t\t\t\"low\": \"低温 22.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:44\",\n" +
            "\t\t\t\"ymd\": \"2019-04-05\",\n" +
            "\t\t\t\"week\": \"星期五\",\n" +
            "\t\t\t\"fx\": \"南风\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"06\",\n" +
            "\t\t\t\"sunrise\": \"06:17\",\n" +
            "\t\t\t\"high\": \"高温 30.0℃\",\n" +
            "\t\t\t\"low\": \"低温 22.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:44\",\n" +
            "\t\t\t\"ymd\": \"2019-04-06\",\n" +
            "\t\t\t\"week\": \"星期六\",\n" +
            "\t\t\t\"fx\": \"南风\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"多云\",\n" +
            "\t\t\t\"notice\": \"阴晴之间，谨防紫外线侵扰\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"07\",\n" +
            "\t\t\t\"sunrise\": \"06:16\",\n" +
            "\t\t\t\"high\": \"高温 29.0℃\",\n" +
            "\t\t\t\"low\": \"低温 23.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:45\",\n" +
            "\t\t\t\"ymd\": \"2019-04-07\",\n" +
            "\t\t\t\"week\": \"星期日\",\n" +
            "\t\t\t\"fx\": \"东南风\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"小雨\",\n" +
            "\t\t\t\"notice\": \"雨虽小，注意保暖别感冒\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"date\": \"08\",\n" +
            "\t\t\t\"sunrise\": \"06:15\",\n" +
            "\t\t\t\"high\": \"高温 29.0℃\",\n" +
            "\t\t\t\"low\": \"低温 23.0℃\",\n" +
            "\t\t\t\"sunset\": \"18:45\",\n" +
            "\t\t\t\"ymd\": \"2019-04-08\",\n" +
            "\t\t\t\"week\": \"星期一\",\n" +
            "\t\t\t\"fx\": \"东南风\",\n" +
            "\t\t\t\"fl\": \"<3级\",\n" +
            "\t\t\t\"type\": \"小雨\",\n" +
            "\t\t\t\"notice\": \"雨虽小，注意保暖别感冒\"\n" +
            "\t\t}]\n" +
            "\t}\n" +
            "}";



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 快速解析广州天气
        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                Weather weather = gson.fromJson(weatherStr, Weather.class);
                String type = weather.getData().getForecast().get(0).getType();
                String low = weather.getData().getForecast().get(0).getLow();
                String high = weather.getData().getForecast().get(0).getHigh();
                Log.e(TAG, "天气" + type  + low + high);
            }
        });
        // 使用GsonFormat生成了AnimalData类型
        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                AnimalData animalData = gson.fromJson(animalStr, AnimalData.class);
                String dogName =  animalData.getAnimals().getDog().get(0).getName();
                String catName = animalData.getAnimals().getCat().getName();
                Log.e(TAG, "dog = " + dogName + " cat = " + catName);
            }
        });
        // 通过http://www.bejson.com/json2javapojo/new/ 接口
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                JsonRootBean jsonRootBean = gson.fromJson(animalStr, JsonRootBean.class);
                String dogName =  jsonRootBean.getAnimals().getDog().get(0).getName();
                String catName = jsonRootBean.getAnimals().getCat().getName();
                Log.e(TAG, "dog = " + dogName + " cat = " + catName);
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new Gson();
                String str1 = gson.toJson(1234);
                String str2  =gson.toJson("hello");
                String str3 = gson.toJson(false);
                String[] arr = {"hello", "world","welcome"};
                String str4 = gson.toJson(arr);
                Log.e(TAG,"str1 = " + str1 + " str2 = " + str2 + " str3 = " + str3
                +" str4 = " + str4);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student =  new Student("张三", 20);
                Gson gson = new Gson();
                String str = gson.toJson(student);
                Log.e(TAG, "str = " + str);
                // 回顾上一次课 使用JSONObject转json
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("name", student.getName());
                    jsonObject.put("age", student.getAge());
                    Log.e(TAG, "jsonObject = " + jsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = "{\"name\":\"张三\",\"age\":20}";
                Gson gson = new Gson();
                Student student = gson.fromJson(str, Student.class);
                Log.e(TAG, "student = " + student);
            }
        });
    }
}
