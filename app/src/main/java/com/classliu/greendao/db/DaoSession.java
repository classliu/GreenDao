package com.classliu.greendao.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.bean.TestData2;
import com.classliu.greendao.bean.TestData3;
import com.classliu.greendao.bean.TestData4;
import com.classliu.greendao.dao.TestData2Dao;
import com.classliu.greendao.dao.TestData3Dao;
import com.classliu.greendao.dao.TestData4Dao;
import com.classliu.greendao.dao.TestDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig testDataDaoConfig;
    private final DaoConfig testData2DaoConfig;
    private final DaoConfig testData3DaoConfig;
    private final DaoConfig testData4DaoConfig;

    private final TestDataDao testDataDao;
    private final TestData2Dao testData2Dao;
    private final TestData3Dao testData3Dao;
    private final TestData4Dao testData4Dao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        testDataDaoConfig = daoConfigMap.get(TestDataDao.class).clone();
        testDataDaoConfig.initIdentityScope(type);

        testData2DaoConfig = daoConfigMap.get(TestData2Dao.class).clone();
        testData2DaoConfig.initIdentityScope(type);

        testData3DaoConfig = daoConfigMap.get(TestData3Dao.class).clone();
        testData3DaoConfig.initIdentityScope(type);

        testData4DaoConfig = daoConfigMap.get(TestData4Dao.class).clone();
        testData4DaoConfig.initIdentityScope(type);

        testDataDao = new TestDataDao(testDataDaoConfig, this);
        testData2Dao = new TestData2Dao(testData2DaoConfig, this);
        testData3Dao = new TestData3Dao(testData3DaoConfig, this);
        testData4Dao = new TestData4Dao(testData4DaoConfig, this);

        registerDao(TestData.class, testDataDao);
        registerDao(TestData2.class, testData2Dao);
        registerDao(TestData3.class, testData3Dao);
        registerDao(TestData4.class, testData4Dao);
    }
    
    public void clear() {
        testDataDaoConfig.clearIdentityScope();
        testData2DaoConfig.clearIdentityScope();
        testData3DaoConfig.clearIdentityScope();
        testData4DaoConfig.clearIdentityScope();
    }

    public TestDataDao getTestDataDao() {
        return testDataDao;
    }

    public TestData2Dao getTestData2Dao() {
        return testData2Dao;
    }

    public TestData3Dao getTestData3Dao() {
        return testData3Dao;
    }

    public TestData4Dao getTestData4Dao() {
        return testData4Dao;
    }

}