# retrofithelper
二次封装retrofit，提高开发效率

### 配置

基本依赖

```
api 'com.squareup.retrofit2:retrofit:2.6.2'
api 'com.squareup.retrofit2:converter-gson:2.6.2'
api 'com.squareup.retrofit2:adapter-rxjava2:2.6.2'
api 'com.squareup.okhttp3:logging-interceptor:4.2.2'
api 'io.reactivex.rxjava2:rxandroid:2.1.1'
```

导入retrofit_helper.jar

百度云下载地址：https://pan.baidu.com/s/1kp0qdKw1I-ioj8UZ2Bto2w

### 使用

application：

```java
//        设置url
        RetrofitConfig.getInstance().init("http://t.weather.sojson.com/api/");
//        设置请求头参数
        Map<String, Object> map = new HashMap<>(50);
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value1");
        map.put("key4", "value1");
        map.put("key5", "value1");
        RetrofitConfig.getInstance().setMap(map);
//        设置日志
        KLog.init(false);
```

新建ResultData继承CommonResultData

新建RetrofitCallback继承extends CommonCallback<ResultData>

```java
public interface WeatherService {
    @GET("weather/city/{cityId}")
    Observable<ResultData> getWeatherInfo(@Path("cityId") long cityId);
}
```

请求：

```java
RetrofitClient.getInstanceRetrofit().create(WeatherService.class).getWeatherInfo(101030100)
        .compose(new CommonTransformer()).subscribe(new RetrofitCallback() {
    @Override
    public void onSuccess(ResultData resultData) {
        super.onSuccess(resultData);
        WeatherInfo weatherInfo = resultData.getData(WeatherInfo.class);
        if (weatherInfo == null) {
            return;
        }
        textview.setText(new Gson().toJson(weatherInfo));
    }
});
```
