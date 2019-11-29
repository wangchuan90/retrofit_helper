package com.wc.retrofithelper;


import android.app.Application;

import androidx.multidex.MultiDex;

import com.socks.library.KLog;
import com.wc.retrofithelper.retrofit.RetrofitConfig;

import java.util.HashMap;
import java.util.Map;


public class MainApplication extends Application {

    public static MainApplication mainApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
        MultiDex.install(this);
//        设置url
        RetrofitConfig.getInstance().init("http://t.weather.sojson.com/api/");
//        设置请求头参数
        Map<String, Object> map = new HashMap<>(50);
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value1");
        map.put("key4", "value1");
        map.put("key5", "value1");
        RetrofitConfig.getInstance().setMap(map);
//        设置日志
        KLog.init(false);
    }

    public static MainApplication getInstance() {
        return mainApplication;
    }
}
