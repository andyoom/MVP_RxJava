package com.andy.ui.iview;


import com.andy.modle.bean.ListEntity;

import java.util.List;

/**
 * Created by tengshuai on 2016/2/26.
 */
public interface ImgDatiView {
    void loadData(List<ListEntity> list);
    void hideProgress();
}
