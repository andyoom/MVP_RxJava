package com.andy.di.module;

import com.andy.di.scope.ActivityScope;
import com.andy.modle.api.ApiService;
import com.andy.presenter.api.ImgPresenter;
import com.andy.presenter.impl.ImgPresenterImpl;
import com.andy.ui.iview.ImgView;

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
public class ImgViewModule {
    private ImgView imgView;

    public ImgViewModule(ImgView imgView) {
        this.imgView = imgView;
    }

    @ActivityScope
    @Provides
    ImgView provideImainView(){
        return imgView;
    }

    @ActivityScope
    @Provides
    ImgPresenter ProvideMainActivityPresenter(ImgView imgView, ApiService apiService){
        return new ImgPresenterImpl(imgView,apiService);
    }
}
