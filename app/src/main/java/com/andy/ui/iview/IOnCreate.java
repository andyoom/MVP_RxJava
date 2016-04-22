package com.andy.ui.iview;

import android.os.Bundle;

/**
 * 类描述：
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/22 11:08
 * 修改备注：
 */
public interface IOnCreate {

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
