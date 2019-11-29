package com.wc.retrofithelper.api;


import android.text.TextUtils;
import android.widget.Toast;
import com.wc.retrofithelper.MainApplication;
import com.wc.retrofithelper.common.CommonCallback;
import com.wc.retrofithelper.retrofit.RetrofitConfig;

import io.reactivex.disposables.Disposable;

/**
 * @author wangchuan
 * @date 2018/5/18 21:12
 */
public class RetrofitCallback extends CommonCallback<ResultData> {


    public static final int SUCCESSFUL = 200;

    @Override
    public void onSuccess(ResultData resultData) {

    }

    @Override
    public void onRequestCompleted() {

    }


    @Override
    public void onFailed(Object o) {

//        公共失败处理
    }


    @Override
    public void onHttpError(ApiException ex) {// 链接超时等别的错误
        onRequestCompleted();
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ResultData resultData) {
        if (resultData != null && SUCCESSFUL == resultData.getStatus()) {
            onSuccess(resultData);
        } else if (resultData != null) {
            if (resultData != null && !TextUtils.isEmpty(resultData.getMessage())) {
                Toast.makeText(MainApplication.getInstance(), resultData.getMessage(), Toast.LENGTH_SHORT).show();
            }
            if (handlerError(String.valueOf(resultData.getStatus()))) {
                return;
            }
            onFailed(resultData);
        }
        onRequestCompleted();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        Toast.makeText(MainApplication.getInstance(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete() {

    }

    private boolean handlerError(String code) {
        return RetrofitConfig.getInstance().getRetrofitHander().handlerError(code);
    }
}
