package com.wc.retrofithelper;


import android.app.Application;

import com.wc.retrofithelper.retrofit.RetrofitConfig;

import java.util.HashMap;
import java.util.Map;


public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        设置url
        RetrofitConfig.getInstance().init("http://106.55.173.177:8081/index.php/");
//        设置请求头参数
        Map<String, Object> map = new HashMap<>(50);
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value1");
        map.put("key4", "value1");
        map.put("key5", "value1");
        RetrofitConfig.getInstance().setMap(map);
    }
}
