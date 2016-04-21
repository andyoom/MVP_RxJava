package com.andy.modle.net;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.BaseUrl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.modle.net
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 19:48
 * 修改人：andy
 * 修改时间：2016/4/15 19:48
 * 修改备注：
 */
@Module
public class NetRetrofitHelper {

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptorHelper().getHttpLoggingInterceptor();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClientHelper().getOkHttpClient(httpLoggingInterceptor);
    }

    @Provides
    @Singleton
    Retrofit.Builder provideBuilder(OkHttpClient okHttpClient) {
        return new Retrofit2Helper().getBuilder(okHttpClient);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Retrofit.Builder builder) {
        return new Retrofit2Helper().getRetrofit(builder, BaseUrl.BASE_HTTP_URL);
    }

    @Provides
    @Singleton
    ApiService provideApi(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
