package com.andy.adapter;

import android.content.Context;
import android.net.Uri;

import com.andy.R;
import com.andy.common.adapter.CommonAdapter;
import com.andy.common.adapter.ViewHolder;
import com.andy.modle.bean.BaseUrl;
import com.andy.modle.bean.TngouEntity;

import java.util.List;

public class PicAdapter extends CommonAdapter<TngouEntity> {

    public PicAdapter(Context context, int layoutId, List<TngouEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(final ViewHolder holder, final TngouEntity tngouEntity) {
        Uri uri = Uri.parse(BaseUrl.PIC_URL_Base + tngouEntity.getImg());

        holder.setText(R.id.tv_picClassiftyNum,tngouEntity.getSize() + "张")
                .setImageFromNet(mContext,uri,R.id.sv_picClassitfy);
    }
}


