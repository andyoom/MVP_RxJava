package com.andy.modle.domain;

import com.andy.modle.api.ApiService;
import com.andy.modle.bean.ShowBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                List<ShowBean> list = new ArrayList<>();
                for (int i = 0; i < response.body().getList().size(); i++) {
                    ShowBean showBean = response.body();
                    list.add(showBean);
                }
                onLoadLisenter.onSuccess(list);
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {

                onLoadLisenter.onFail(t.getMessage());
            }
        });
    }

}
