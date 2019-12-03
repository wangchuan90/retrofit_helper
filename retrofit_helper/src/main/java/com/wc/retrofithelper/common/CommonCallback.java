package com.wc.retrofithelper.common;

import android.widget.Toast;

import com.wc.retrofithelper.api.ApiException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * @author wangchuan
 * @date 2018/5/18 21:12
 */
public abstract class CommonCallback<T extends CommonResultData> implements Observer<T> {
    /**
     * 请求成功
     */
    public abstract void onSuccess(T body);

    /**
     * 请求完成
     */
    public abstract void onRequestCompleted();

    /**
     * 请求失败
     */
    public abstract void onFailed(ApiException ex);

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        ApiException ex = new ApiException();
        ex.onError(e);
        onFailed(ex);
        onRequestCompleted();
    }

    @Override
    public void onComplete() {

    }
}
