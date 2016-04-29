package com.andy.di.module;

import com.andy.di.scope.ActivityScope;
import com.andy.modle.api.ApiService;
import com.andy.presenter.api.ImgDatilPresenter;
import com.andy.presenter.impl.ImgDatilPresenterImpl;
import com.andy.ui.iview.ImgDatiView;

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
public class ImgDatilModule implements IModule<ImgDatiView,ImgDatilPresenter>{
    private ImgDatiView imgView;

    public ImgDatilModule(ImgDatiView imgView) {
        this.imgView = imgView;
    }

    @ActivityScope
    @Provides
    @Override
    public ImgDatiView provideView(){
        return imgView;
    }

    @ActivityScope
    @Provides
    @Override
    public ImgDatilPresenter ProvidePresenter(ImgDatiView iview, ApiService apiService){
        return new ImgDatilPresenterImpl(iview,apiService);
    }
}
