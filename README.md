# retrofithelper
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
