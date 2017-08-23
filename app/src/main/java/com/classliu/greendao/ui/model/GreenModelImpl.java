package com.classliu.greendao.ui.model;

import android.os.Looper;

import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.bean.TestData2;
import com.classliu.greendao.listener.OnNetDataListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ji_cheng on 2017/8/23.
 */

public class GreenModelImpl implements GreenModel {

    public static final int TEST_DATA_SIZE = 10000;   //添加数据的大小

    @Override
    public void requestTestData(int creat_id, int ids, final OnNetDataListener<List<TestData>> listener) {
        //子线程请求网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                List<TestData> list = new ArrayList<>();
                for (int i = 0; i < TEST_DATA_SIZE; i++) {
                    TestData testData = new TestData();
                    testData.setId(Long.valueOf(i));
                    testData.setCreatId(i);
                    testData.setTestBoolean(false);
                    testData.setTestDate(new Date(System.currentTimeMillis()));
                    testData.setTestInt(i);
                    testData.setReader("testString," +
                            "关关雎鸠，在河之洲。窈窕淑女，君子好逑。\n" +
                            "参差荇菜，左右流之。窈窕淑女，寤寐求之。\n" +
                            "求之不得，寤寐思服。悠哉悠哉，辗转反侧。\n" +
                            "参差荇菜，左右采之。窈窕淑女，琴瑟友之。\n" +
                            "参差荇菜，左右芼之。窈窕淑女，钟鼓乐之。" + i);
                    testData.setTestLong(System.currentTimeMillis());
                    list.add(testData);
                }
                listener.backData(list);
                Looper.loop();
            }
        }).start();

    }

    @Override
    public void requestTest2Data(int creat_id, int id, final OnNetDataListener<List<TestData2>> listener) {
        //子线程请求网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                List<TestData2> list = new ArrayList<>();
                for (int i = 0; i < TEST_DATA_SIZE; i++) {
                    TestData2 testData = new TestData2();
                    testData.setId(Long.valueOf(i));
                    testData.setTestBoolean(false);
                    testData.setTestDate(new Date(System.currentTimeMillis()));
                    testData.setTestInt(i);
                    testData.setTestString("testString," +
                            "关关雎鸠，在河之洲。窈窕淑女，君子好逑。\n" +
                            "参差荇菜，左右流之。窈窕淑女，寤寐求之。\n" +
                            "求之不得，寤寐思服。悠哉悠哉，辗转反侧。\n" +
                            "参差荇菜，左右采之。窈窕淑女，琴瑟友之。\n" +
                            "参差荇菜，左右芼之。窈窕淑女，钟鼓乐之。" + i);
                    testData.setTestLong(System.currentTimeMillis());
                    list.add(testData);
                }
                listener.backData(list);
                Looper.loop();
            }
        }).start();
    }

    @Override
    public void requestNetData() {

    }
}
