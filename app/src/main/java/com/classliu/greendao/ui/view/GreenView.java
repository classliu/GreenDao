package com.classliu.greendao.ui.view;

import com.classliu.greendao.base.BaseIView;
import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.bean.TestData2;

import java.util.List;

/**
 * Created by ji_cheng on 2017/8/7.
 */

public interface GreenView extends BaseIView {

    //增加1000条数据
    void add10000(List<TestData> testDatas);

    //异步增加1000条数据
    void asyncadd10000(List<TestData2> testDatas);

    //删除所有
    void deleteall();

    //刷新数据
    void refresh();

    //刷新数据
    void refresh2();
}
