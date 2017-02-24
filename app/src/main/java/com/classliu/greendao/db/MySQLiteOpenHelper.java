package com.classliu.greendao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.classliu.greendao.dao.DaoMaster;
import com.classliu.greendao.dao.TestData2Dao;
import com.classliu.greendao.dao.TestData3Dao;
import com.classliu.greendao.dao.TestDataDao;
import com.classliu.greendao.utils.MigrationHelper;

/**
 *  更新升级数据库 操作类
 * Created by ji_cheng on 2017/2/24.
 */
public class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, TestDataDao.class, TestData2Dao.class, TestData3Dao.class);//, TestData4Dao.class);
    }
}
