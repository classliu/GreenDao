package com.classliu.greendao.ui.presenter;

import com.classliu.greendao.base.BasePresenter;
import com.classliu.greendao.ui.view.GreenView;

/**
 * Created by ji_cheng on 2017/8/7.
 */

public abstract class GreenPresenter extends BasePresenter<GreenView> {
    public abstract void add1000();

    public abstract void asyncadd1000();
}
