package com.andy.modle.domain;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.TngouEntity;

import java.util.List;

/**
 * Created by tengshuai on 2016/2/24.
 */
public interface ImgClassitfyModel {

    //借口需要传递id
    void loadSuccess(ApiService apiService, int id,OnloadImgListener onloadImgListener);

    void loadSuccessRx(ApiService apiService, int id,OnloadImgListener onloadImgListener);

    public interface OnloadImgListener {
        void success(List<TngouEntity> list);
    }

}
