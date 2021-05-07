package com.wc.retrofithelper.api;

import com.wc.retrofithelper.retrofit.RetrofitClient;

public class ApiService {

    public static <T> T getService(final Class<T> service) {
        return RetrofitClient.getInstanceRetrofit().create(service);
    }
}
