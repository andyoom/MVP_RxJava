package com.andy.adapter;

import android.content.Context;
import android.net.Uri;

import com.andy.R;
import com.andy.common.adapter.CommonAdapter;
import com.andy.common.adapter.ViewHolder;
import com.andy.modle.bean.BaseUrl;
import com.andy.modle.bean.ListEntity;

import java.util.List;

public class ImgDetailAdapter extends CommonAdapter<ListEntity> {

    public ImgDetailAdapter(Context context, int layoutId, List<ListEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(ViewHolder holder, ListEntity listEntity) {
        Uri uri = Uri.parse(BaseUrl.PIC_URL_Base + listEntity.getSrc());
        holder.setImageFromNet(mContext,uri,R.id.iv_pic);
    }
}
