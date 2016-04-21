package com.andy.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.andy.AppApplication;
import com.andy.R;
import com.andy.di.component.DaggerMainActivityComponent;
import com.andy.di.module.MainActivityModule;
import com.andy.presenter.api.MainPresenter;
import com.andy.ui.fragment.AboutFragment;
import com.andy.ui.fragment.PicFragment;
import com.andy.ui.iview.MainView;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainView {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Inject
    MainPresenter mMainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainActivityComponent.builder()
                .appComponent(AppApplication.get(this).getAppComponent())
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);

        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mToggle.syncState();

        mDrawerLayout.setDrawerListener(mToggle);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

        setupDrawerContent(mNavigationView);
        switchPicture();
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
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new PicFragment()).commit();
        mToolbar.setTitle(R.string.picture);

    }

    @Override
    public void switchAbout() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new AboutFragment()).commit();
        mToolbar.setTitle(R.string.about);

    }
}
