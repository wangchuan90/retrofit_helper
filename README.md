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

百度云下载地址：https://pan.baidu.com/s/150fiAmTplVPRdD2KFrTsCg

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

异常处理：

```
/**
 * 公共失败处理
 */
@Override
public void onFailed(ApiException ex) {
    Toast.makeText(MainApplication.getInstance(), ex.getErrorMsg(), Toast.LENGTH_SHORT).show();
}
```

ApiException

```
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
```