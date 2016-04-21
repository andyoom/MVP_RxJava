package com.andy.di.component;

import com.andy.di.module.ImgDatilModule;
import com.andy.di.scope.ActivityScope;
import com.andy.presenter.api.ImgDatilPresenter;
import com.andy.ui.activity.ImageDatilActivity;

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
@ActivityScope
@Component( modules= ImgDatilModule.class,dependencies = AppComponent.class)
public interface ImgDatilComponent {

    void inject(ImageDatilActivity imgView);

    ImgDatilPresenter presenter();
}
