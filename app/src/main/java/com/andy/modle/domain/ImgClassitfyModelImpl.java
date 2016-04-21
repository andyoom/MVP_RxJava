package com.andy.modle.domain;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.ClassifyBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tengshuai on 2016/2/24.
 */
public class ImgClassitfyModelImpl implements ImgClassitfyModel {

    @Override
    public void loadSuccess(ApiService apiService, int id, final OnloadImgListener onloadImgListener) {
        Call<ClassifyBean> call = apiService.getPicClassify(id);
        call.enqueue(new Callback<ClassifyBean>() {
            @Override
            public void onResponse(Call<ClassifyBean> call, Response<ClassifyBean> response) {
                List<ClassifyBean> list = new ArrayList<ClassifyBean>();
                for (int i = 0; i < response.body().getTngou().size(); i++) {
                    ClassifyBean bean = response.body();
                    list.add(bean);
                }
                //成功拿到数据
                onloadImgListener.success(list);
            }

            @Override
            public void onFailure(Call<ClassifyBean> call, Throwable t) {

            }
        });
    }
}


