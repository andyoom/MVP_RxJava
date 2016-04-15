package com.andy;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 15:48
 * 修改人：andy
 * 修改时间：2016/4/15 15:48
 * 修改备注：
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }
}
