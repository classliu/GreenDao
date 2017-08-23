package com.classliu.greendao.base;

/**
 * 视图 基类
 * Created by ji_cheng on 2017/6/19.
 */
public interface BaseIView {
    //显示网络的case

    /**
     * 用于网络的中断
     */
    void showNetError();

    /**
     * 用于网络的加载过程中
     */
    void showNetLoading();
}
