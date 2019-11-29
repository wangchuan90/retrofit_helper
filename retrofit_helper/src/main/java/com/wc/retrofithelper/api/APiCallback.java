package com.wc.retrofithelper.api;


/**
 * @author wangchuan
 * 请求回调
 */

public interface APiCallback<T> {
    /**
     * 请求成功
     */
    void onSuccess(T body);

    /**
     * 请求完成
     */
    void onRequestCompleted();

    /**
     * 请求失败
     */
    void onFailed(Object o);

}
