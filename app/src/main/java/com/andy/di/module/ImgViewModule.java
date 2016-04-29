package com.andy.di.module;

import com.andy.di.scope.FragmentScope;
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
public class ImgViewModule implements IModule<ImgView,ImgPresenter>{
    private ImgView imgView;

    public ImgViewModule(ImgView imgView) {
        this.imgView = imgView;
    }

    @FragmentScope
    @Provides
    @Override
    public ImgView provideView(){
        return imgView;
    }

    @FragmentScope
    @Provides
    @Override
    public ImgPresenter ProvidePresenter(ImgView iview, ApiService apiService){
        return new ImgPresenterImpl(iview,apiService);
    }
}
