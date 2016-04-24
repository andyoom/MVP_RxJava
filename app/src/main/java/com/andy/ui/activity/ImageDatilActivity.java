package com.andy.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.andy.R;
import com.andy.adapter.ImgDetailAdapter;
import com.andy.di.component.AppComponent;
import com.andy.di.component.DaggerImgDatilComponent;
import com.andy.di.module.ImgDatilModule;
import com.andy.modle.bean.ListEntity;
import com.andy.presenter.api.ImgDatilPresenter;
import com.andy.ui.iview.ImgDatiView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by tengshuai on 2016/2/25.
 */
public class ImageDatilActivity extends BaseActivity implements ImgDatiView, SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.recly_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Inject
    ImgDatilPresenter mPresenter;
    private ImgDetailAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private long id;
    private String title;

    List<ListEntity> mList;

    @OnClick(R.id.iv_back)
    void setBack() {
        finish();
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerImgDatilComponent.builder()
                .appComponent(appComponent)
                .imgDatilModule(new ImgDatilModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.imgdetail_layout;
    }

    @Override
    public void initVariables() {
        super.initVariables();
        Intent intent = getIntent();
        id = intent.getExtras().getLong("id");
        title = intent.getExtras().getString("title");
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        tv_title.setText(title);

        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new ImgDetailAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void loadData() {
        super.loadData();
        onRefresh();
    }

    @Override
    public void loadData(List<ListEntity> list) {
        if (mList == null) {
            mList = new ArrayList<>();
        }
//        Log.i("RT", list.size() + "");
        mList.addAll(list);
        mAdapter.setData(list);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onRefresh() {
        if (mList != null) {
            mList.clear();
        }
        mPresenter.loadList(id);
    }
}
