package com.wc.retrofithelper.common;


import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author wangchuan
 * 公共返回处理
 */
public abstract class CommonResultData {

    /**
     * 要解析的json数据
     */
    public abstract Object getJsonData();

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public <D> D getData(Class<? extends D> clazz) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(getJsonData());
            return gson.fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public <D> List<D> getListData(Class<? extends D> clazz, String key) {
        try {
            Map<String, Object> map = new Gson().fromJson(new Gson().toJson(getJsonData()), Map.class);
            if (map.containsKey(key)) {
                String jsonString = new Gson().toJson(map.get(key));
                Type type = new ParameterizedTypeImpl(clazz);
                List<D> list = new Gson().fromJson(jsonString, type);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <D> List<D> getListData(Class<? extends D> clazz) {
        Gson gson = new Gson();
        try {
            String jsonString = gson.toJson(getJsonData());
            Type type = new ParameterizedTypeImpl(clazz);
            List<D> list = new Gson().fromJson(jsonString, type);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
