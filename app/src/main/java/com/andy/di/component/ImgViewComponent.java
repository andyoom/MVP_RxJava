package com.andy.di.component;

import com.andy.di.module.ImgViewModule;
import com.andy.di.scope.FragmentScope;
import com.andy.presenter.api.ImgPresenter;
import com.andy.ui.fragment.PicContentFrament;

import dagger.Component;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.ui.component
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 15:16
 * 修改人：andy
 * 修改时间：2016/4/15 15:16
 * 修改备注：
 */
@FragmentScope
@Component( modules= ImgViewModule.class,dependencies = AppComponent.class)
public interface ImgViewComponent {

    void inject(PicContentFrament imgView);

    ImgPresenter presenter();
}
