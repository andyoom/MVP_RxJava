package com.andy.modle.net;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.modle.net
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 19:43
 * 修改人：andy
 * 修改时间：2016/4/15 19:43
 * 修改备注：
 */
public class HttpLoggingInterceptorHelper {

    public HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor
                = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

}
