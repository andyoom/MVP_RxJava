package com.andy.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.andy.R;
import com.andy.modle.bean.BaseUrl;
import com.andy.modle.bean.ShowBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tengshuai on 2016/2/25.
 */
public class ImgDetailAdapter extends RecyclerView.Adapter<ImgDetailAdapter.ViewHolder> {

    Context mContext;
    List<ShowBean> mList;
    ShowBean mShowBean;

    public ImgDetailAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<ShowBean> list) {
        this.mList = list;
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_imgdetail, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mShowBean = mList.get(position);
        Uri uri = Uri.parse(BaseUrl.PIC_URL_Base + mShowBean.getList().get(position).getSrc());
        Log.e("image",uri.toString());
        Glide.with(mContext).load(uri).into(holder.iv_detail);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_pic)
        ImageView iv_detail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
