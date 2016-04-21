package com.andy.presenter.impl;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.ShowBean;
import com.andy.modle.domain.ImgDetilModel;
import com.andy.modle.domain.ImgDetilModelImpl;
import com.andy.presenter.api.ImgDatilPresenter;
import com.andy.ui.iview.ImgDatiView;

import java.util.List;

/**
 * Created by tengshuai on 2016/2/26.
 */
public class ImgDatilPresenterImpl implements ImgDatilPresenter, ImgDetilModelImpl.onLoadLisenter {

    ImgDatiView mImgDatiView;
    ImgDetilModel mImgDetilModel;
    ApiService apiService;


    public ImgDatilPresenterImpl(ImgDatiView imgDatiView,ApiService apiService) {
        this.mImgDatiView = imgDatiView;
        this.mImgDetilModel = new ImgDetilModelImpl();
        this.apiService = apiService;
    }

    @Override
    public void loadList(long id) {
        mImgDetilModel.success(apiService,id, this);
    }

    @Override
    public void onSuccess(List<ShowBean> list) {
        mImgDatiView.hideProgress();
        mImgDatiView.loadData(list);
    }

    @Override
    public void onFail(String msg) {

    }
}
