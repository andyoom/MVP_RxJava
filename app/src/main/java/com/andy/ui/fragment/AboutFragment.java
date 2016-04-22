package com.andy.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.andy.R;
import com.andy.di.component.AppComponent;

import butterknife.Bind;

/**
 * Created by tengshuai on 2016/2/27.
 */
public class AboutFragment extends BaseFragment {
    @Bind(R.id.tv_content)
    TextView mTextView;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setupComponent(AppComponent appComponent) {

    }

    @Override
    public int bindLayout() {
        return R.layout.about_layout;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mTextView.setText("MVP+Retrofit+Material Design,旨在学习,还有很多不足的地方,还请多多交流.新浪微博:@RtSunoath");
    }

}
