package com.andy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andy.AppApplication;
import com.andy.ui.iview.IFragment;

import butterknife.ButterKnife;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.ui.fragment
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 15:16
 * 修改人：andy
 * 修改时间：2016/4/15 15:16
 * 修改备注：
 */
public abstract class BaseFragment extends Fragment implements IFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupComponent(AppApplication.get(getActivity()).getAppComponent());

        initVariables();

        View view = inflater.inflate(bindLayout(), null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(savedInstanceState);

        loadData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void loadData() {

    }
}
