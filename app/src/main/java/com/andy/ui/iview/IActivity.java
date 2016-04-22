package com.andy.ui.iview;

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
public interface IActivity extends ISetupComponent,IOnCreate{
    /**
     * setContentView方法调用前的一些设置
     */
    void beforeContentView();

}
