package com.andy.modle.bean;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.modle.bean
 * 类描述：
 * 创建人：andy
 * 创建时间：2016/4/16 17:10
 * 修改人：andy
 * 修改时间：2016/4/16 17:10
 * 修改备注：
 */
public class ListEntity {
    /**
     * gallery : 10
     * id : 187
     * src : /ext/150714/832903f1079ad2a74867e5cbd9dcf1a2.jpg
     */
    private int gallery;
    private int id;
    private String src;

    public void setGallery(int gallery) {
        this.gallery = gallery;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getGallery() {
        return gallery;
    }

    public int getId() {
        return id;
    }

    public String getSrc() {
        return src;
    }
}