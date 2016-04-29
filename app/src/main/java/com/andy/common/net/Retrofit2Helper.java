package com.andy.common.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.modle.net
 * 类描述：retrofit辅助网络通讯类
 * 创建人：andy
 * 创建时间：2016/4/15 16:36
 * 修改人：andy
 * 修改时间：2016/4/15 16:36
 * 修改备注：
 */

public class Retrofit2Helper {

    public Retrofit.Builder getBuilder(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return builder;
    }

    public Retrofit getRetrofit(Retrofit.Builder builder,String baseUrl) {
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .build();
        return retrofit;
    }
}
