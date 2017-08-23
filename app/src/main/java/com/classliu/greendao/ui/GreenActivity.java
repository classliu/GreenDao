package com.classliu.greendao.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.classliu.greendao.R;
import com.classliu.greendao.adapter.TestDataAdapter;
import com.classliu.greendao.async.SaveDBSync;
import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.bean.TestData2;
import com.classliu.greendao.entityDao.TestData2EntityDao;
import com.classliu.greendao.entityDao.TestDataEntityDao;
import com.classliu.greendao.ui.presenter.GreenPresenter;
import com.classliu.greendao.ui.presenter.GreenPresenterImpl;
import com.classliu.greendao.ui.view.GreenView;

import java.util.List;

/**
 * greendao 实例分析
 * Created by ji_cheng on 2017/2/24.
 */
public class GreenActivity extends AppCompatActivity implements GreenView, View.OnClickListener {

    private ListView listView;
    private TestDataEntityDao testDataEntityDao;
    private TestData2EntityDao testData2EntityDao;


    private Button add;
    private Button add1000;
    private Button delete;
    private Button deleteall;
    private Button refresh;
    private Button refresh2;
    private Button async;

    private GreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullScreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green);
        presenter = createPresenter();
        initView();
        initData();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.lv);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);
        add1000 = (Button) findViewById(R.id.add1000);
        add1000.setOnClickListener(this);
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);
        deleteall = (Button) findViewById(R.id.deleteall);
        deleteall.setOnClickListener(this);
        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(this);
        refresh2 = (Button) findViewById(R.id.refresh2);
        refresh2.setOnClickListener(this);
        async = (Button) findViewById(R.id.async);
        async.setOnClickListener(this);
    }


    private void initData() {
        testDataEntityDao = new TestDataEntityDao();
        testData2EntityDao = new TestData2EntityDao();
    }


    @Override
    public void showNetError() {

    }

    @Override
    public void showNetLoading() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:

                break;
            case R.id.add1000:
                presenter.add1000();
                break;
            case R.id.delete:

                break;
            case R.id.deleteall:
                deleteall();
                break;
            case R.id.refresh:
                refresh();
                break;
            case R.id.refresh2:
                refresh2();
                break;
            case R.id.async:
                presenter.asyncadd1000();
                break;
        }
    }


    @Override
    public void add10000(List<TestData> testDatas) {
        long startTime = System.currentTimeMillis();
        testDataEntityDao.getEntityDao().insertOrReplaceInTx(testDatas);
        Toast.makeText(this, "add" + String.valueOf(System.currentTimeMillis() - startTime), Toast.LENGTH_SHORT).show();
        Log.e("----add1000time----", String.valueOf(System.currentTimeMillis() - startTime));
    }

    @Override
    public void asyncadd10000(List<TestData2> testDatas) {
        long startTime = System.currentTimeMillis();
        new SaveDBSync<>(testDatas, testData2EntityDao).insertTODB();
        Toast.makeText(this, "add" + String.valueOf(System.currentTimeMillis() - startTime), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deleteall() {
        testDataEntityDao.deleteAll();
        testData2EntityDao.deleteAll();
    }


    @Override
    public void refresh() {
        List<TestData> list = testDataEntityDao.getEntityDao().loadAll();
        listView.setAdapter(new TestDataAdapter<TestData>(this, list));
        Toast.makeText(this, "refresh" + list.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refresh2() {
        List<TestData2> list = testData2EntityDao.getEntityDao().loadAll();
        listView.setAdapter(new TestDataAdapter<TestData2>(this, list));
        Toast.makeText(this, "refresh" + list.size(), Toast.LENGTH_SHORT).show();
    }


    private void setFullScreen() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public GreenPresenter createPresenter() {
        return new GreenPresenterImpl(this);
    }
}
