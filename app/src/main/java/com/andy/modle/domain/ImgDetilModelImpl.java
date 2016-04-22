package com.andy.modle.domain;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.ListEntity;
import com.andy.modle.bean.ShowBean;

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
 * Created by tengshuai on 2016/2/26.
 */
public class ImgDetilModelImpl implements ImgDetilModel {

    @Override
    public void success(ApiService apiService, long id, final onLoadLisenter onLoadLisenter) {
        Call<ShowBean> call = apiService.getPicShow(id);
        call.enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
                ShowBean showBean = response.body();
                onLoadLisenter.onSuccess(showBean.getList());
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {
                onLoadLisenter.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void successRx(ApiService apiService, long id, final onLoadLisenter onLoadLisenter) {
        Subscription mSubscription=apiService
                .getPicShowRx(id)
                .map(new Func1<ShowBean, List<ListEntity>>() {
                    @Override
                    public List<ListEntity> call(ShowBean bean) {
                        return bean.getList();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ListEntity>>() {
                    @Override
                    public void call(List<ListEntity> listEntities) {
                        onLoadLisenter.onSuccess(listEntities);
                    }
                });
    }

}
