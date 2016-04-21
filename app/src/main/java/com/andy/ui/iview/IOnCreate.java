package com.andy.ui.iview;

import android.os.Bundle;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.ui.iview
 * 类描述：针对activity中的onCreate方法重新规划生命周期
 * 创建人：andy
 * 创建时间：2016/4/15 19:23
 * 修改人：andy
 * 修改时间：2016/4/15 19:23
 * 修改备注：
 */
public interface IOnCreate {
    /**
     * setContentView方法调用前的一些设置
     */
    void beforeContentView();

    /**
     * 返回layout的布局文件ID
     */
    int bindLayout();

    /**
     * 初始化变量，包括Intent带的数据和Activity内的变量
     */
    void initVariables();

    /**
     * 初始化控件，为控件挂上事件方法
     */
    void initViews(Bundle savedInstanceState);

    /**
     * 调用MobileAPI获取初始化数据
     */
    void loadData();
}
