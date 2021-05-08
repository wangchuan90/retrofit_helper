package com.wc.retrofithelper.api;


import android.text.TextUtils;
import android.util.Log;

import com.wc.retrofithelper.callback.CommonCallback;

/**
 * @author wangchuan
 * @date 2018/5/18 21:12
 */
public class RetrofitCallback extends CommonCallback<ResultData> {


    public static final int SUCCESSFUL = 200;

    @Override
    public void onNext(ResultData resultData) {
        if (resultData == null) {
            onFailed(new ApiException(ApiException.DATA_ERROE, "返回数据错误"));
        } else {
            if (SUCCESSFUL == resultData.getCode()) {
                onSuccess(resultData);
            } else if (!TextUtils.isEmpty(resultData.getMsg())) {
                Log.e("RetrofitCallback", resultData.getMsg());
            }
            onRequestCompleted();
        }

    }

    /**
     * 请求成功
     */
    @Override
    public void onSuccess(ResultData resultData) {

    }

    /**
     * 请求完成
     */
    @Override
    public void onRequestCompleted() {

    }

    /**
     * 公共失败处理
     */
    @Override
    public void onFailed(ApiException ex) {
        Log.e("RetrofitCallback", ex.getErrorMsg());
    }


}
