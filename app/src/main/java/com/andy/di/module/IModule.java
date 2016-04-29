package com.andy.di.module;

import com.andy.modle.api.ApiService;
import com.andy.presenter.api.IPresenter;
import com.andy.ui.base.IView;

/**
 * 类描述：Dagger中 view(activity或fragment) 与 Presenter关联的Module接口基类
 *        V 代表 view    , P  代表 Presenter
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/25 15:10
 * 修改备注：
 */

public interface IModule<V extends IView, P extends IPresenter> {

    // @ActivityScope or @FragmentScope
    // @Provides
    V provideView();

    // @ActivityScope or @FragmentScope
    // @Provides
    P ProvidePresenter(V iview, ApiService apiService);
}
