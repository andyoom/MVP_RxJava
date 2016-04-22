package com.andy.modle.domain;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.ClassifyBean;
import com.andy.modle.bean.TngouEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
                ClassifyBean classifyBean=response.body();
                //成功拿到数据
                onloadImgListener.success(classifyBean.getTngou());
            }

            @Override
            public void onFailure(Call<ClassifyBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadSuccessRx(ApiService apiService, int id, final OnloadImgListener onloadImgListener) {
        Subscription mSubscription=apiService
                .getPicClassifyRx(id)
                .map(new Func1<ClassifyBean, List<TngouEntity>>() {
                    @Override
                    public List<TngouEntity> call(ClassifyBean classifyBean) {
                        return classifyBean.getTngou();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<TngouEntity>>() {
                    @Override
                    public void call(List<TngouEntity> tngouEntities) {
                        onloadImgListener.success(tngouEntities);
                    }
                });
    }
}


