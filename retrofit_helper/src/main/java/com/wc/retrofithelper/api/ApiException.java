package com.wc.retrofithelper.api;

import java.io.IOException;

/**
 * @author wangchuan
 * 异常处理
 */

public class ApiException extends IOException {

    public static final String UNKNOWN_STRING = "未知错误";
    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;
    /**
     * 加密数据解析错误
     */
    public static final int PARSE_ENCRYPT_DATA_ERROR = 1001;
    /**
     * 无效格式的返回数据
     */
    public static final int INVALID_FORMAT_RESPONSE = 1002;
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

    public ApiException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
