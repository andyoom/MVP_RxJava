package com.andy.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.andy.R;
import com.andy.di.component.AppComponent;
import com.andy.ui.base.BaseFragment;

import butterknife.Bind;

/**
 * Created by tengshuai on 2016/2/22.
 */
public class PicFragment extends BaseFragment {

    @Bind(R.id.viewPager_content)
    ViewPager mViewPager;
    @Bind(R.id.tabLayout)
    TabLayout mTableLayout;

    private String[] title;

    @Override
    public void setupComponent(AppComponent appComponent) {
        //KLog.e("setupComponent");
    }

    @Override
    public int bindLayout() {
        return R.layout.pic_layout;
    }

    @Override
    public void initVariables() {
        super.initVariables();
        title = new String[]{"性感美女", "日韩美女", "丝袜美腿", "美女照片"
                , "美女写真", "清纯美女", "性感车模"};
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        //setting
        mViewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 1) return new PicContentTwoFrament();
                if (position == 2) return new PicContentThreeFrament();
                if (position == 3) return new PicContentFourFrament();
                if (position == 4) return new PicContentFiveFrament();
                if (position == 5) return new PicContentSixFrament();
                if (position == 6) return new PicContentSevenFrament();
                return new PicContentFrament();
            }

            @Override
            public int getCount() {
                return title.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        //关联
        mTableLayout.setupWithViewPager(mViewPager);
    }
}
