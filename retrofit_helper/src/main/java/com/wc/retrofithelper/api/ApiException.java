package com.wc.retrofithelper.api;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * @author wangchuan
 * 异常处理
 */

public class ApiException extends Exception {

    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;
    /**
     * 返回数据错误
     */
    public static final int DATA_ERROE = 1001;
    /**
     * android6.0时候的权限异常
     */
    public static final int PERMISSION_DENY = 1003;
    /**
     * 连接超时异常
     */
    public static final int SOCKET_TIMEOUT_EXCEPTION = 1004;
    /**
     * 连接异常
     */
    public static final int CONNECT_EXCEPTION = 1005;
    /**
     * 未知的服务器
     */
    public static final int UNKNOWNHOST_EXCEPTION = 1006;


    private int errorCode;
    private String errorMsg;

    public ApiException() {

    }

    public ApiException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = message;
    }



    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            this.errorCode = SOCKET_TIMEOUT_EXCEPTION;
            this.errorMsg = "连接超时,请检查您的网络";
        } else if (e instanceof ConnectException) {
            this.errorCode = CONNECT_EXCEPTION;
            this.errorMsg = "无法连接,请检查您的网络";
        } else if (e instanceof UnknownHostException) {
            this.errorCode = UNKNOWNHOST_EXCEPTION;
            this.errorMsg = "无法连接,请检查您的网络";
        } else if (e instanceof HttpException) {
            this.errorCode = ((HttpException) e).code();
            this.errorMsg = e.getMessage();
        } else if (e instanceof SecurityException) {
            this.errorCode = PERMISSION_DENY;
            this.errorMsg = e.getMessage();
        } else {
            this.errorCode = UNKNOWN;
            this.errorMsg = "未知错误";
        }
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
