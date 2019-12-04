package com.wc.retrofithelper.common;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public abstract class FastJsonResultData {
    /**
     * 要解析的json数据
     */
    public abstract Object getJsonData();

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public <D> D getData(Class<? extends D> clazz) {
        try {
            return JSON.parseObject(JSON.toJSONString(getJsonData()), clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public <D> List<D> getListData(Class<? extends D> clazz, String key) {
        try {
            Map<String, Object> map = JSON.parseObject(JSON.toJSONString(getJsonData()), Map.class);
            if (map.containsKey(key)) {
                String jsonString = JSON.toJSONString(map.get(key));
                Type type = new ParameterizedTypeImpl(clazz);
                List<D> list = JSON.parseObject(jsonString, type);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <D> List<D> getListData(Class<? extends D> clazz) {
        try {
            Type type = new ParameterizedTypeImpl(clazz);
            List<D> list = JSON.parseObject(JSON.toJSONString(getJsonData()), type);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
