package com.andy.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.andy.R;
import com.andy.di.component.AppComponent;
import com.andy.di.component.DaggerMainActivityComponent;
import com.andy.di.module.MainActivityModule;
import com.andy.presenter.api.MainPresenter;
import com.andy.ui.fragment.AboutFragment;
import com.andy.ui.fragment.PicFragment;
import com.andy.ui.iview.MainView;

import javax.inject.Inject;

import butterknife.Bind;


public class MainActivity extends BaseActivity implements MainView {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;

    @Inject
    MainPresenter mMainPresenter;

    private PicFragment mPicFragment;
    private AboutFragment mAboutFragment;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mToggle.syncState();
        mDrawerLayout.setDrawerListener(mToggle);

        setupDrawerContent(mNavigationView);
        switchPicture();
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mMainPresenter.switchNavigation(item.getItemId());
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public void switchPicture() {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        if(mPicFragment==null) {
            mPicFragment = new PicFragment();
            tx.add(R.id.frame_layout, mPicFragment);
        }else{
            tx.hide(mAboutFragment);
            tx.show(mPicFragment);
        }
        tx.commit();
        mToolbar.setTitle(R.string.picture);
    }

    @Override
    public void switchAbout() {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.hide(mPicFragment);
        if(mAboutFragment==null) {
            mAboutFragment = new AboutFragment();
            tx.add(R.id.frame_layout, mAboutFragment);
        }else{
            tx.show(mAboutFragment);
        }
        tx.commit();
        mToolbar.setTitle(R.string.about);
    }
}
