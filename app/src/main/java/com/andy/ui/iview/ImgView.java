package com.andy.ui.iview;


import com.andy.modle.bean.ClassifyBean;

import java.util.List;

/**
 * Created by tengshuai on 2016/2/24.
 */
public interface ImgView {
    void loadImgDatas(List<ClassifyBean> mlist);

    void showProgress();

    void hideProgress();
}
