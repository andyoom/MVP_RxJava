package com.andy.di.module;

import com.andy.di.scope.ActivityScope;
import com.andy.modle.api.ApiService;
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
public class MainActivityModule implements IModule<MainView,MainPresenter>{

    private MainView mMainView;

    public MainActivityModule(MainView mainView) {
        mMainView = mainView;
    }

    @ActivityScope
    @Provides
    @Override
    public MainView provideView() {
        return mMainView;
    }

    @ActivityScope
    @Provides
    @Override
    public MainPresenter ProvidePresenter(MainView iview, ApiService apiService) {
        return new MainPresentImpl(iview);
    }
}
