package com.andy.modle.domain;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.ShowBean;

import java.util.List;

/**
 * Created by tengshuai on 2016/2/26.
 */
public interface ImgDetilModel {
    void success(ApiService apiService, long id, onLoadLisenter onLoadLisenter);

    public interface onLoadLisenter {

        void onSuccess(List<ShowBean> list);

        void onFail(String msg);

    }
}
