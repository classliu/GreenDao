package com.classliu.greendao.entityDao;

import com.classliu.greendao.bean.TestData2;
import com.classliu.greendao.dao.TestData2Dao;
import com.classliu.greendao.db.DatabaseManager;

/**
 * Created by ji_cheng on 2016/12/6.
 */
public class TestData2EntityDao extends BaseEntityDao<TestData2Dao, TestData2, Long> {

    @Override
    protected TestData2Dao initEntityDao() {
        return DatabaseManager.newSession().getTestData2Dao();
    }


}
