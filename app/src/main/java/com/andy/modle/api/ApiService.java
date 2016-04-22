package com.andy.modle.api;

import com.andy.modle.bean.ClassifyBean;
import com.andy.modle.bean.ShowBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.modle.api
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/15 15:02
 * 修改人：andy
 * 修改时间：2016/4/15 15:02
 * 修改备注：
 */
public interface ApiService {
    //各大分类列表 ps：七类
    @GET("tnfs/api/list")
    Call<ClassifyBean> getPicClassify(@Query("id") int id);

    @GET("tnfs/api/list")
    Observable<ClassifyBean> getPicClassifyRx(@Query("id") int id);

    //分类中图片详细内容列表
    @GET("tnfs/api/show")
    Call<ShowBean> getPicShow(@Query("id") long id);

    @GET("tnfs/api/show")
    Observable<ShowBean> getPicShowRx(@Query("id") long id);
}
