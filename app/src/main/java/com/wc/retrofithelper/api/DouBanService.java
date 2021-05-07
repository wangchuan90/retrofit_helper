package com.wc.retrofithelper.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DouBanService {
    @GET("search")
    Observable<ResultData> q(@Query("q") String q, @Query("page") int page);

    /**
     * book/top250?page=0
     */
    @GET("book/top250")
    Observable<ResultData> book( @Query("page") int page);
}
