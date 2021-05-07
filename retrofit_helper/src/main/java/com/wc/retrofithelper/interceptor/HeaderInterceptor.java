package com.wc.retrofithelper.interceptor;

import com.wc.retrofithelper.retrofit.RetrofitConfig;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder();
        Map<String, Object> map = RetrofitConfig.getInstance().getMap();
        requestBuilder.header("User-Agent", "Android");
        if (map != null) {
            for (String key : map.keySet()) {
                requestBuilder.header(key, String.valueOf(map.get(key)));
            }
        }
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}