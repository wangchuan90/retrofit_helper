package com.wc.retrofithelper.api;

import com.wc.retrofithelper.common.CommonResultData;

public class ResultData extends CommonResultData {
    private int code;
    private String msg;
    private Object data;

    @Override
    public Object getJsonData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
