package com.wc.retrofithelper.common;

import com.wc.retrofithelper.api.ApiException;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author wangchuan
 * @date 2018/5/18 21:12
 */
public abstract class CommonCallback<T> implements Observer<T> {
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
