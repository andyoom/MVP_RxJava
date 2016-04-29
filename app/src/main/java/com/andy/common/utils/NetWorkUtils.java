package com.andy.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 类描述：网络判断
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/26 15:40
 * 修改备注：
 */
public class NetWorkUtils {
    public static boolean isNetAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return (info != null && info.isAvailable());
    }
}
