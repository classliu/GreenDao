package com.classliu.greendao.db;

import android.app.Application;

/**
 * 数据库工具管理类
 * Created by ji_cheng on 2016/12/1.
 */
public class DatabaseManager {

    public static final String DB_NAME = "test.db";
    public static final int SCHEMA_VERSION = 1;

    public DatabaseManager() {
    }

    private static MySQLiteOpenHelper mySQLiteOpenHelper;
    private static DaoMaster sDaoMaster;

    public static void initDB(Application app) {
        mySQLiteOpenHelper = new MySQLiteOpenHelper(app, DB_NAME, null);
        sDaoMaster = new DaoMaster(mySQLiteOpenHelper.getWritableDatabase());
    }

    public static DaoSession newSession() {
        if (sDaoMaster == null) {
            throw new RuntimeException("sDaoMaster is null.");
        }
        return sDaoMaster.newSession();
    }


    public static void destroy() {
        try {
            if (sDaoMaster != null) {
                sDaoMaster.getDatabase().close();
                sDaoMaster = null;
            }

            if (mySQLiteOpenHelper != null) {
                mySQLiteOpenHelper.close();
                mySQLiteOpenHelper = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
