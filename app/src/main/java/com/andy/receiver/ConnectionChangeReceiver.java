package com.andy.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.andy.AppApplication;
import com.andy.common.utils.NetWorkUtils;
import com.socks.library.KLog;

/**
 * 类描述：实时监听网络状态
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/26 15:58
 * 修改备注：
 */
public class ConnectionChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        AppApplication.isNetAvailable= NetWorkUtils.isNetAvailable(context);
        KLog.e(AppApplication.isNetAvailable);
    }
}
