package com.andy.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andy.AppApplication;
import com.andy.di.component.AppComponent;
import com.andy.ui.iview.IOnCreate;

import butterknife.ButterKnife;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.ui.activity
 * 类描述：所有子Activity的基类
 * 创建人：andy
 * 创建时间：2016/4/15 19:30
 * 修改人：andy
 * 修改时间：2016/4/15 19:30
 * 修改备注：
 */
public abstract class BaseActivity extends AppCompatActivity implements IOnCreate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(AppApplication.get(this).getAppComponent());

        beforeContentView();
        if(bindLayout()!=0){
            setContentView(bindLayout());

            ButterKnife.bind(this);

            initVariables();
            initViews(savedInstanceState);
            loadData();
        }
    }


    @Override
    public void beforeContentView() {

    }

    public <T extends View>T findView(int viewId){
        return (T)findViewById(viewId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);
}
