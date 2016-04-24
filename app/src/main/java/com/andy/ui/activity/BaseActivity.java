package com.andy.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.andy.AppApplication;
import com.andy.ui.iview.IActivity;

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
public abstract class BaseActivity extends AppCompatActivity implements IActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(AppApplication.get(this).getAppComponent());

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void loadData() {

    }

    public <T extends View>T findView(int viewId){
        return (T)findViewById(viewId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
