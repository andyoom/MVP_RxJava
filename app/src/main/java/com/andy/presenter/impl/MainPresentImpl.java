package com.andy.presenter.impl;

import com.andy.R;
import com.andy.presenter.api.MainPresenter;
import com.andy.ui.iview.MainView;

/**
 * Created by tengshuai on 2016/2/17.
 */
public class MainPresentImpl implements MainPresenter {

    private MainView mMainView;

    public MainPresentImpl(MainView mainView) {
        this.mMainView = mainView;
    }

    @Override
    public void switchNavigation(int id) {

        switch (id) {
            case R.id.navigation_picture:
                mMainView.switchPicture();
                break;
            case R.id.navigation_about:
                mMainView.switchAbout();
                break;
            default:
                break;
        }
    }
}
