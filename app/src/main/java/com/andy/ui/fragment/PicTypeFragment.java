package com.andy.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.andy.R;
import com.andy.adapter.PicAdapter;
import com.andy.common.adapter.OnItemClickListener;
import com.andy.modle.bean.TngouEntity;
import com.andy.presenter.api.ImgPresenter;
import com.andy.ui.activity.ImageDatilActivity;
import com.andy.ui.base.BaseFragment;
import com.andy.ui.iview.ImgView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * 类描述：
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/22 13:12
 * 修改备注：
 */
public abstract class PicTypeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, ImgView {
    private int classItfyId = 1;

    @Bind(R.id.swipe_layout_pic)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.recly_view)
    RecyclerView mRecyclerView;

    StaggeredGridLayoutManager mGridLayoutManager;
    PicAdapter mPicAdapter;

    List<TngouEntity> mList;
    @Inject
    ImgPresenter mPresenter;

    @Override
    public int bindLayout() {
        return R.layout.frament_pic;
    }

    @Override
    public void initVariables() {
        super.initVariables();
        mList = new ArrayList<>();
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mPicAdapter = new PicAdapter(getActivity(),R.layout.item_pic_classitfy,mList);
        mRecyclerView.setAdapter(mPicAdapter);
        mPicAdapter.setOnItemClickListener(new OnItemClickListener<TngouEntity>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, TngouEntity tngouEntity, int position) {
                toImageDatilActivity(position,tngouEntity);
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, TngouEntity tngouEntity, int position) {
                return false;
            }
        });
    }

    @Override
    public void loadData() {
        super.loadData();
        mSwipeRefreshLayout.setRefreshing(true);
        onRefresh();
    }

    private void toImageDatilActivity(int pos, TngouEntity bean){
        Intent intent = new Intent(getActivity(), ImageDatilActivity.class);
        long id = bean.getId();
        String title = bean.getTitle();
        intent.putExtra("id", id);
        intent.putExtra("title", title);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        if (mList != null) {
            mPicAdapter.notifyDataSetChanged();
        }
        mPresenter.loadList(classItfyId);
    }

    @Override
    public void loadImgDatas(List<TngouEntity> mlist) {
        mList.clear();
        mList.addAll(mlist);
        mPicAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void setClassItfyId(int id){
        classItfyId=id;
    }
}
