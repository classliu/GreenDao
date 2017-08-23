package com.classliu.greendao.ui.presenter;

import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.bean.TestData2;
import com.classliu.greendao.listener.OnNetDataListener;
import com.classliu.greendao.ui.model.GreenModel;
import com.classliu.greendao.ui.model.GreenModelImpl;
import com.classliu.greendao.ui.view.GreenView;

import java.util.List;

/**
 * Created by ji_cheng on 2017/8/23.
 */

public class GreenPresenterImpl extends GreenPresenter {
    private GreenModel model;
    private GreenView view;

    public GreenPresenterImpl(GreenView view) {
        this.model = new GreenModelImpl();
        this.view = view;
    }

    @Override
    public void add1000() {
        model.requestTestData(0, 0, new OnNetDataListener<List<TestData>>() {
            @Override
            public void backData(List<TestData> data) {
                view.add10000(data);
            }
        });
    }

    @Override
    public void asyncadd1000() {
        model.requestTest2Data(0, 0, new OnNetDataListener<List<TestData2>>() {
            @Override
            public void backData(List<TestData2> data) {
                view.asyncadd10000(data);
            }
        });
    }

    @Override
    public void onDestroy() {
        model = null;
    }


}
