package com.wc.retrofithelper.retrofit;

import java.util.Map;

import okhttp3.logging.HttpLoggingInterceptor;

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
    private HttpLoggingInterceptor.Logger logger;

    public void init(String url) {
        this.url = url;
    }

    public void init(String url, HttpLoggingInterceptor.Logger logger) {
        this.url = url;
        this.logger = logger;
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

    /**
     * 添加http请求log  包括请求url 请求参数  返回的参数 等信息。
     *
     * @return
     */
    public HttpLoggingInterceptor httpLog() {

        if (logger == null) {
            logger = HttpLoggingInterceptor.Logger.DEFAULT;
        }
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger);
        //日志显示级别
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
