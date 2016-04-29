package com.andy.common.net;

import okhttp3.Interceptor;
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
public class InterceptorHelper {

    private final int DEFAULT = 0;
    private final int KLOG = 1;

    public Interceptor getInterceptor() {
        return builderInterceptor(KLOG);
    }

    private Interceptor builderInterceptor(int type){
        if(type==KLOG){
            return new HttpKLogInterceptor();
        }else {
            HttpLoggingInterceptor httpLoggingInterceptor
                    = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            return  httpLoggingInterceptor;
        }
    }

}
