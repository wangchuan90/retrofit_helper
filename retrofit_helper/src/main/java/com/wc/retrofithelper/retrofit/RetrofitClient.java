package com.wc.retrofithelper.retrofit;

import com.socks.library.KLog;
import com.wc.retrofithelper.common.CommonCallback;
import com.wc.retrofithelper.common.CommonResultData;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author wangchuan
 * @date 2018/5/18 20:24
 */
public class RetrofitClient {

    private volatile static RetrofitClient instance;

    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }


    public static Retrofit getInstanceRetrofit() {
        return getInstance().getRetrofit();
    }

    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public Retrofit getRetrofit() {
        return retrofit;
    }


    private RetrofitClient() {
        okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(addHttpLog())
                .hostnameVerifier(new MyHostnameVerifier())
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .baseUrl(RetrofitConfig.getInstance().getUrl())
                .build();
    }


    /**
     * 添加http请求log  包括请求url 请求参数  返回的参数 等信息。
     *
     * @return
     */
    public HttpLoggingInterceptor addHttpLog() {
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                KLog.i(message);
            }
        });
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }

    private static class MyHostnameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }


    private class HeaderInterceptor implements Interceptor {

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

    public class NullOnEmptyConverterFactory extends Converter.Factory {

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return new Converter<ResponseBody, Object>() {
                @Override
                public Object convert(ResponseBody body) throws IOException {
                    if (body == null || body.contentLength() == 0) {
                        return null;
                    }
                    return delegate.convert(body);
                }
            };
        }
    }

    public <T extends CommonResultData> void compose(Observable<T> observable, CommonCallback callback) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(callback);
    }

}
