package com.classliu.greendao.entityDao;

import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.dao.TestDataDao;
import com.classliu.greendao.db.DatabaseManager;

/**
 * Created by ji_cheng on 2016/12/6.
 */
public class TestDataEntityDao extends BaseEntityDao<TestDataDao, TestData, Long> {

    @Override
    protected TestDataDao initEntityDao() {
        return DatabaseManager.newSession().getTestDataDao();
    }


}
