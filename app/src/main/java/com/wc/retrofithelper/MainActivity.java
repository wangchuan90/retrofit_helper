package com.wc.retrofithelper;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.gson.Gson;
import com.wc.retrofithelper.api.ResultData;
import com.wc.retrofithelper.api.RetrofitCallback;
import com.wc.retrofithelper.api.WeatherService;
import com.wc.retrofithelper.common.CommonTransformer;
import com.wc.retrofithelper.common.StringCallback;
import com.wc.retrofithelper.model.WeatherInfo;
import com.wc.retrofithelper.retrofit.RetrofitClient;
import com.wc.retrofithelper.retrofit.RetrofitConfig;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textview);
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
    }
}
