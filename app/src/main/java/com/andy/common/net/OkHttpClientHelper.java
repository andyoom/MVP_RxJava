package com.andy.common.net;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.modle.net
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 19:46
 * 修改人：andy
 * 修改时间：2016/4/15 19:46
 * 修改备注：
 */
public class OkHttpClientHelper {

    public OkHttpClient getOkHttpClient(Interceptor interceptor) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }

}
