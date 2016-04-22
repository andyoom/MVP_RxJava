package com.andy.ui.fragment;

import com.andy.di.component.AppComponent;
import com.andy.di.component.DaggerImgView5Component;
import com.andy.di.module.ImgViewModule;

/**
 * Created by tengshuai on 2016/2/22.
 */
public class PicContentFiveFrament extends PicTypeFragment {

    private final int CLASSITFY_ID = 5;

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerImgView5Component.builder()
                .imgViewModule(new ImgViewModule(this))
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initVariables() {
        super.initVariables();
        setClassItfyId(CLASSITFY_ID);
    }
}
