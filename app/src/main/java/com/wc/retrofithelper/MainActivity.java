package com.wc.retrofithelper;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wc.retrofithelper.api.ApiService;
import com.wc.retrofithelper.api.DouBanService;
import com.wc.retrofithelper.api.ResultData;
import com.wc.retrofithelper.api.RetrofitCallback;
import com.wc.retrofithelper.common.CommonTransformer;
import com.wc.retrofithelper.model.BookInfo;

public class MainActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textview);
        ApiService.getService(DouBanService.class).book(0)
                .compose(new CommonTransformer())
                .subscribe(new RetrofitCallback() {
                    @Override
                    public void onSuccess(ResultData resultData) {
                        super.onSuccess(resultData);
                        BookInfo bookInfo = resultData.getData(BookInfo.class);
                        StringBuilder builder = new StringBuilder();
                        for (BookInfo.SubjectBean subjectBean : bookInfo.getSubject()) {
                            builder.append("书名 ：")
                                    .append(subjectBean.getName())
                                    .append("   评分 ：")
                                    .append(subjectBean.getStar())
                                    .append("\n");
                        }
                        textview.setText(builder);
                    }
                });
    }
}
