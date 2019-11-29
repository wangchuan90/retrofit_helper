package com.wc.retrofithelper.retrofit;

import java.util.Map;

/**
 * @author wangchuan
 */
public class RetrofitConfig {


    private static RetrofitConfig retrofitConfig;

    public static RetrofitConfig getInstance() {
        if (retrofitConfig == null) {
            retrofitConfig = new RetrofitConfig();
        }
        return retrofitConfig;
    }

    private String url;
    private Map<String, Object> map;
    private RetrofitHander retrofitHander;

    public void init(String url) {
        this.url = url;
    }


    public String getUrl() {
        return url;
    }


    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }


    public RetrofitHander getRetrofitHander() {
        return retrofitHander;
    }

    public void setRetrofitHander(RetrofitHander retrofitHander) {
        this.retrofitHander = retrofitHander;
    }

    public interface RetrofitHander {
        boolean handlerError(String code);
    }
}
