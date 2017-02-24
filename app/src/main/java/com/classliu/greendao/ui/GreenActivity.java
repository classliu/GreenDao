package com.classliu.greendao.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.classliu.greendao.R;
import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.dao.TestDataEntityDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据库 test
 * Created by ji_cheng on 2017/2/24.
 */
public class GreenActivity  extends AppCompatActivity{

    private ListView listView;
    private TestDataEntityDao testDataEntityDao;

    private List<TestData> dataList = new ArrayList<>();
    private long id = 0;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green);
        mContext = this;

        initView();
        initData();
    }

    private int creat_id = 0;

    private void initView(){
        listView = (ListView) findViewById(R.id.lv);
    }


    private void initData(){
        testDataEntityDao = new TestDataEntityDao();

        List<TestData> list = testDataEntityDao.queryEntities("where CREAT_ID != ?", "*");
        dataList.addAll(list);
        id = dataList.size();
        creat_id =dataList.size();
    }

    public void add(View v) {
        TestData testData = new TestData();
        testData.setId(id);
        testData.setCreatId(creat_id);
        testData.setTestBoolean(false);
        testData.setTestDate(new Date(System.currentTimeMillis()));
        testData.setTestInt(0);
        testData.setReader("testString " + creat_id);
        testData.setTestLong(System.currentTimeMillis());
        testDataEntityDao.insertEntity(testData);
        id++;
        creat_id++;
        Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
    }


    public void add1000(View v){
        long startTime = System.currentTimeMillis();

        for (int i =0;i<1000 ;i++){
            TestData testData = new TestData();
            testData.setId(id);
            testData.setCreatId(creat_id);
            testData.setTestBoolean(false);
            testData.setTestDate(new Date(System.currentTimeMillis()));
            testData.setTestInt(i);
            testData.setReader("testString," +
                    "关关雎鸠，在河之洲。窈窕淑女，君子好逑。\n" +
                    "参差荇菜，左右流之。窈窕淑女，寤寐求之。\n" +
                    "求之不得，寤寐思服。悠哉悠哉，辗转反侧。\n" +
                    "参差荇菜，左右采之。窈窕淑女，琴瑟友之。\n" +
                    "参差荇菜，左右芼之。窈窕淑女，钟鼓乐之。" + creat_id);
            testData.setTestLong(System.currentTimeMillis());
            testDataEntityDao.insertEntity(testData);
            id++;
            creat_id++;
        }

        Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
        Log.e("----add1000time----", String.valueOf(System.currentTimeMillis() - startTime));
    }

    public void delete(View v) {
        testDataEntityDao.deleteEntityByKey(id - 1);
        id--;
        creat_id--;
        Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
    }

    public void deleteall(View v){
        testDataEntityDao.deleteAll();
        id=0;creat_id=0;
    }

    public void refresh(View v) {
        dataList.clear();
        List<TestData> list = testDataEntityDao.queryEntities("where CREAT_ID != ?", String.valueOf(-1));
        dataList.addAll(list);
        listView.setAdapter(new TestDataAdapter());
        Toast.makeText(this, "refresh", Toast.LENGTH_SHORT).show();
    }


    class TestDataAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(mContext);
            TestData data = dataList.get(position);
            textView.setText(data.getReader());
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(20);
            return textView;
        }
    }
}
