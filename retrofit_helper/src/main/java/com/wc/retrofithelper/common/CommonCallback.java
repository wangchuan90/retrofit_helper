package com.wc.retrofithelper.common;


import com.wc.retrofithelper.api.APiCallback;
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
public abstract class CommonCallback<T extends CommonResultData> implements Observer<T>, APiCallback<T> {

    public void onHttpError(ApiException ex) {// 链接超时等别的错误
        onRequestCompleted();
    }


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }


    @Override
    public void onError(Throwable e) {
        ApiException ex;
        if (e instanceof SocketTimeoutException) {
            ex = new ApiException(ApiException.SOCKET_TIMEOUT_EXCEPTION, "连接超时,请检查您的网络");
            onHttpError(ex);
        } else if (e instanceof ConnectException) {
            ex = new ApiException(ApiException.CONNECT_EXCEPTION, "无法连接,请检查您的网络");
            onHttpError(ex);
        } else if (e instanceof UnknownHostException) {
            ex = new ApiException(ApiException.UNKNOWNHOST_EXCEPTION, "无法连接,请检查您的网络");
            onHttpError(ex);
        } else if (e instanceof HttpException) {//其他网络错误,统一处理网络错误
            ex = new ApiException(((HttpException) e).code(), e.getMessage());
            onHttpError(ex);
        }
//        else if (e instanceof ResultException) {//服务器返回数据错误
//            ex = new ApiException(((ResultException) e).getErrorCode(), e.getMessage());
//            onHttpError(ex);
//        } else if (e instanceof ApiException) {//服务器接口调用非200错误
//            //退出App的code判断，需要退出app或者重启操作,需要重新登录
//            int errCode = ((ApiException) e).getErrorCode();
//            ex = new ApiException(errCode, e.getMessage());
//            onHttpError(ex);
//        }
        else if (e instanceof SecurityException) {//android代码执行时候权限异常，没有该权限执行
            ex = new ApiException(ApiException.PERMISSION_DENY, e.getMessage());
            onHttpError(ex);
        } else {//其他未知错误
            ex = new ApiException(ApiException.UNKNOWN, ApiException.UNKNOWN_STRING);
            onHttpError(ex);
        }
        onComplete();
    }

}
