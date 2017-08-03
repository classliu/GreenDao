package com.classliu.greendao.async;

import android.util.Log;

import com.classliu.greendao.entityDao.BaseEntityDao;
import com.classliu.greendao.db.DatabaseManager;

import org.greenrobot.greendao.async.AsyncSession;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 异步多线程操作数据库 greenDao
 * Created by ji_cheng on 2017/6/15.
 */

public class SaveDBSync<T> implements Runnable {

    private List<T> tempList;
    private BaseEntityDao mDao;

    public SaveDBSync(List<T> tempList, BaseEntityDao baseEntityDao) {
        this.tempList = tempList;
        this.mDao = baseEntityDao;
    }

    public void insertTODB(){
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(this);

        executorService.shutdown();
        while (true){
            if (executorService.isTerminated()) {
                break;
            }
            try {
                executorService.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.e("---add1000time--async--", String.valueOf(System.currentTimeMillis() - startTime));
    }


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        if (tempList != null && tempList.size() > 0){
            AsyncSession asyncSession =  DatabaseManager.newSession().startAsyncSession();
            asyncSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    mDao.getEntityDao().insertOrReplaceInTx(tempList);
                    mDao.getEntityDao().detachAll();
                }
            });
        }
        Log.e("----add1000time--sync--", String.valueOf(System.currentTimeMillis() - startTime));
    }
}
