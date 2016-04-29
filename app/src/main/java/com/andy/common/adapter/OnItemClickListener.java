package com.andy.common.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * 类描述：
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/29 11:22
 * 修改备注：
 */
public interface OnItemClickListener<T>
{
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}
