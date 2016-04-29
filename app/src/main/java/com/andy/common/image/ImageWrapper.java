package com.andy.common.image;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * 类描述：
 * 项目名称：MVP_RxJava
 * 创建人：andy
 * 创建时间：2016/4/25 14:10
 * 修改备注：
 */
public class ImageWrapper{

    public static void display(Context context, Uri uri, ImageView imageView){
        Glide.with(context)
                .load(uri)
//                .fitCenter()
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
