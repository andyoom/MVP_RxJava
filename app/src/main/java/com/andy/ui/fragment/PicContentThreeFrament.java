package com.andy.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andy.AppApplication;
import com.andy.R;
import com.andy.adapter.PicAdapter;
import com.andy.di.component.DaggerImgView3Component;
import com.andy.di.module.ImgViewModule;
import com.andy.modle.bean.ClassifyBean;
import com.andy.presenter.api.ImgPresenter;
import com.andy.ui.activity.ImageDatilActivity;
import com.andy.ui.iview.ImgView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tengshuai on 2016/2/22.
 */
public class PicContentThreeFrament extends Fragment implements SwipeRefreshLayout.OnRefreshListener, ImgView {

    private int CLASSITFY_ID = 3;

    @Bind(R.id.swipe_layout_pic)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.recly_view)
    RecyclerView mRecyclerView;

    StaggeredGridLayoutManager mGridLayoutManager;
    PicAdapter mPicAdapter;

    List<ClassifyBean> mClassifyBeanList;
    @Inject
    ImgPresenter mPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DaggerImgView3Component.builder()
                .imgViewModule(new ImgViewModule(this))
                .appComponent(AppApplication.get(getActivity()).getAppComponent())
                .build()
                .inject(this);

        View view = inflater.inflate(R.layout.frament_pic, null);
        ButterKnife.bind(this, view);
        mSwipeRefreshLayout.setRefreshing(true);
        onRefresh();
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSwipeRefreshLayout.setOnRefreshListener(this);

        mGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mPicAdapter = new PicAdapter(getActivity());
        mRecyclerView.setAdapter(mPicAdapter);
        mPicAdapter.setOnitemClickLisenter(new PicAdapter.PicOnItemClickListener() {
            @Override
            public void picOnItemClickListener(View view, int pos, ClassifyBean bean) {
                //TODO
                Intent intent = new Intent(getActivity(), ImageDatilActivity.class);

                long id = bean.getTngou().get(pos).getId();
                String title = bean.getTngou().get(pos).getTitle();

                intent.putExtra("id", id);
                intent.putExtra("title", title);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onRefresh() {
        if (mClassifyBeanList != null) {
//            mClassifyBeanList.clear();
        }
        mPresenter.loadList(CLASSITFY_ID);
    }

    @Override
    public void loadImgDatas(List<ClassifyBean> mlist) {

        if (mClassifyBeanList == null) {
            mClassifyBeanList = new ArrayList<>();
        }
        mClassifyBeanList.addAll(mlist);
        mPicAdapter.setDatas(mClassifyBeanList);
    }

    @Override
    public void showProgress() {

        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);

    }
}
