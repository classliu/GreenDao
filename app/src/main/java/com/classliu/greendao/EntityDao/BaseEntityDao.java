package com.classliu.greendao.entityDao;


import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;


@SuppressWarnings("unchecked")
public abstract class BaseEntityDao<DAO extends AbstractDao<E, K>, E, K> {
    public static final boolean DEBUG = true;
    private DAO mDao;

    private boolean forCurThread = false;

    static {
        if (DEBUG) {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        }
    }

    public BaseEntityDao() {
        mDao = initEntityDao();
    }

    public void setForCurThread(boolean curThread) {
        this.forCurThread = curThread;
    }

    protected abstract DAO initEntityDao();

    public DAO getEntityDao() {
        return mDao;
    }

    public void insertEntity(E entity) {
        mDao.insert(entity);
    }

    public void deleteEntity(E entity) {
        mDao.delete(entity);
    }

    public void deleteAll() {
        mDao.deleteAll();
    }


    public void deleteEntityByKey(K key) {
        mDao.deleteByKey(key);
    }

    public void replaceEntity(E entity) {
        mDao.insertOrReplace(entity);
    }

    public void updateEntity(E entity) {
        mDao.updateInTx(entity);
    }

    public void updateByEntity(E entity) {
        mDao.updateInTx(entity);
    }

    public List<E> queryEntitiesByKey(K key, boolean asc) {
        QueryBuilder<E> qb = mDao.queryBuilder().where(mDao.getPkProperty().eq(key), (WhereCondition) null);
        if (asc) {
            qb.orderAsc(mDao.getPkProperty());
        } else {
            qb.orderDesc(mDao.getPkProperty());
        }
        if (forCurThread) {
            return qb.build().forCurrentThread().list();
        } else {
            return qb.list();
        }
    }

    /**
     * 检查 数据是否存在
     *
     * @param where
     * @param selectionArg
     * @return
     */
    public boolean queryByEntity(String where, String... selectionArg) {
        boolean flag = false;
        List<E> list = mDao.queryRaw(where, selectionArg);
        if (list.size() > 0) {
            flag = true;
        }
        return flag;
    }


    /**
     * 检查 数据是否存在
     *
     * @param where
     * @param selectionArg
     * @return
     */
    public E queryEntityExist(String where, String... selectionArg) {
        E e = null;
        List<E> list = mDao.queryRaw(where, selectionArg);
        if (list.size() > 0) {
            e = list.get(0);
        }
        return e;
    }


    public E queryEntityByEntity(E e) {
        QueryBuilder<E> qb = mDao.queryBuilder().where(mDao.getPkProperty().eq(e), (WhereCondition) null);
        if (forCurThread) {
            return qb.build().forCurrentThread().unique();
        }
        return qb.unique();
    }


    public E queryEntityByKey(K key) {
        QueryBuilder<E> qb = mDao.queryBuilder().where(mDao.getPkProperty().eq(key), (WhereCondition) null);
        if (forCurThread) {
            return qb.build().forCurrentThread().unique();
        }
        return qb.unique();
    }

    public E queryEntityByWhere(String where, String... selectionArg) {
        E ef = null;
        try {
            List<E> list = mDao.queryRaw(where, selectionArg);
            if (null != list && list.size() > 0) {
                ef = list.get(0);
            } else {
                ef = null;
            }
        } catch (Exception e) {
            ef = null;
            e.printStackTrace();
        }
        return ef;
    }


    public List<E> queryEntitiesByArgs(WhereCondition... whereCondition) {
        if (whereCondition == null || whereCondition.length == 0) {
            if (forCurThread) {
                return mDao.queryBuilder().build().forCurrentThread().list();
            }
            return mDao.queryBuilder().list();
        }
        if (forCurThread) {
            return mDao.queryBuilder().where(null, whereCondition).build().forCurrentThread().list();
        }
        return mDao.queryBuilder().where(null, whereCondition).list();
    }

    public List<E> queryEntities(String where, String... selectionArg) {
        return mDao.queryRaw(where, selectionArg);
    }
}
