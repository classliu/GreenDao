package com.classliu.greendao;

import android.app.Application;

import com.classliu.greendao.db.DatabaseManager;
import com.facebook.stetho.Stetho;

/**
 * 添加数据库管理工具 facebook
 * Created by ji_cheng on 2017/2/24.
 */
public class GreenApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.initDB(this);
        Stetho.initializeWithDefaults(this); //facebook 开源工具
    }

}
