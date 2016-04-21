package com.andy;

import android.app.Application;
import android.content.Context;

import com.andy.common.utils.CrashHandler;
import com.andy.di.component.AppComponent;
import com.andy.di.component.DaggerAppComponent;
import com.andy.di.module.AppModule;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 15:55
 * 修改人：andy
 * 修改时间：2016/4/15 15:55
 * 修改备注：
 */
public class AppApplication extends Application{

    private AppComponent appComponent;
    public static AppApplication get(Context context){
        return (AppApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
