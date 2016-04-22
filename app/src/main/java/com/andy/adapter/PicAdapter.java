package com.andy.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andy.R;
import com.andy.modle.bean.BaseUrl;
import com.andy.modle.bean.TngouEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tengshuai on 2016/2/23.
 */
public class PicAdapter extends RecyclerView.Adapter<PicAdapter.PicViewHolder> {
    List<TngouEntity> mList;
    Context mContext;
    PicOnItemClickListener mListener;

    public PicAdapter(Context context) {
        this.mContext = context;
    }

    public void setOnitemClickLisenter(PicOnItemClickListener picOnItemClickListener) {
        this.mListener = picOnItemClickListener;

    }


    //刷新时获取数据
    public void setDatas(List<TngouEntity> list) {
        this.mList = list;
        this.notifyDataSetChanged();
    }


    @Override
    public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_pic_classitfy, null);
        return new PicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PicViewHolder holder, final int position) {
        final TngouEntity tngouEntity = mList.get(position);
        Uri uri = Uri.parse(BaseUrl.PIC_URL_Base + tngouEntity.getImg());
//        Log.e("image",uri.toString());
        Glide.with(mContext).load(uri).into(holder.mView);
        //图片封面

        //图片张数
        holder.tv_picClassIftyNum.setText(tngouEntity.getSize() + "张");

        //item点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.picOnItemClickListener(v, position, tngouEntity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    static class PicViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.sv_picClassitfy)
        ImageView mView;
        @Bind(R.id.tv_picClassiftyNum)
        TextView tv_picClassIftyNum;

        public PicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }

    public interface PicOnItemClickListener {
        void picOnItemClickListener(View view, int pos, TngouEntity bean);
    }
}


