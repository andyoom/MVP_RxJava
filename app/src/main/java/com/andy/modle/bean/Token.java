package com.andy.modle.bean;

/**
 * 项目名称：MVP_RxJava
 * 所属包名：com.andy.modle.bean
 * 类描述：Token 唯一识别码类
 * 创建人：andy
 * 创建时间：2016/4/15 16:33
 * 修改人：andy
 * 修改时间：2016/4/15 16:33
 * 修改备注：
 */
public class Token {
    public String token;
    public boolean expired;

    public Token() {

    }

    public Token(boolean expired) {

        this.expired = expired;
    }
}
