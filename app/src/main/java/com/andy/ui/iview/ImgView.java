package com.andy.ui.iview;


import com.andy.modle.bean.TngouEntity;
import com.andy.ui.base.IView;

import java.util.List;

/**
 * Created by tengshuai on 2016/2/24.
 */
public interface ImgView extends IView {
    void loadImgDatas(List<TngouEntity> mlist);

    void showProgress();

    void hideProgress();
}
