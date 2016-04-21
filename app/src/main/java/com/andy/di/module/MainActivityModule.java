package com.andy.di.module;

import com.andy.di.scope.ActivityScope;
import com.andy.presenter.api.MainPresenter;
import com.andy.presenter.impl.MainPresentImpl;
import com.andy.ui.iview.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.ui.module
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 15:17
 * 修改人：andy
 * 修改时间：2016/4/15 15:17
 * 修改备注：
 */
@Module
public class MainActivityModule {
    private MainView mainView;

    public MainActivityModule(MainView mainView) {
        this.mainView = mainView;
    }

    @ActivityScope
    @Provides
    MainView provideImainView(){
        return mainView;
    }

    @ActivityScope
    @Provides
    MainPresenter ProvideMainActivityPresenter(MainView mainView){
        return new MainPresentImpl(mainView);
    }
}
