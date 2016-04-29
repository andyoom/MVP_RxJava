package com.andy.ui.base;

import com.andy.di.component.AppComponent;

/**
 * 类描述：Component需要AppComponent对象时 需实现此方法来获得AppComponent对象
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/22 11:13
 * 修改备注：
 */
public interface ISetupComponent {
    void setupComponent(AppComponent appComponent);
}
