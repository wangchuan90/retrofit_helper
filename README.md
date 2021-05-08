# retrofithelper
二次封装retrofit，提高开发效率

### Gradle

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

```
implementation 'com.github.wangchuan90:retrofithelper:v1.0.0'
```

### 使用

1.新建ResultData继承CommonResultData

2.新建RetrofitCallback继承extends CommonCallback<ResultData>

3.配置接口

```java
    @GET("search")
    Observable<ResultData> q(@Query("q") String q, @Query("page") int page);

    /**
     * book/top250?page=0
     */
    @GET("book/top250")
    Observable<ResultData> book( @Query("page") int page);
```

4.application：

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
```

请求：

```java
 ApiService.getService(DouBanService.class).book(0)
                .compose(new CommonTransformer())
                .subscribe(new RetrofitCallback() {
                    @Override
                    public void onSuccess(ResultData resultData) {
                        super.onSuccess(resultData);
                        BookInfo bookInfo = resultData.getData(BookInfo.class);
                       ...
                    }
                });
```



