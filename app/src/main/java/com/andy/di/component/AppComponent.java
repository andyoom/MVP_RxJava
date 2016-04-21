package com.andy.di.component;

import android.app.Application;

import com.andy.di.module.AppModule;
import com.andy.modle.api.ApiService;
import com.andy.modle.net.NetRetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 15:47
 * 修改人：andy
 * 修改时间：2016/4/15 15:47
 * 修改备注：
 */

@Singleton
@Component(modules = {AppModule.class, NetRetrofitHelper.class})
public interface AppComponent {
    Application getApplication();
    ApiService getApiService();
}
