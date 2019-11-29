package com.wc.retrofithelper.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("weather/city/{cityId}")
    Observable<ResultData> getWeatherInfo(@Path("cityId") long cityId);
}
