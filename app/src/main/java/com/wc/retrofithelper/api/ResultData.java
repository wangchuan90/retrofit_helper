package com.wc.retrofithelper.api;

import com.wc.retrofithelper.common.CommonResultData;

public class ResultData extends CommonResultData {
    private int status;
    private String message;
    private Object data;

    @Override
    public Object getJsonData() {
        return data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
