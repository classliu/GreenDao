package com.classliu.greendao.ui.model;

import com.classliu.greendao.base.BaseModel;
import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.bean.TestData2;
import com.classliu.greendao.listener.OnNetDataListener;

import java.util.List;


/**
 * Created by ji_cheng on 2017/8/7.
 */

public interface GreenModel extends BaseModel {

    void requestTestData(int creat_id, int id, OnNetDataListener<List<TestData>> listener);

    void requestTest2Data(int creat_id,int id, OnNetDataListener<List<TestData2>> listener);

}
