package com.classliu.greendao.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.classliu.greendao.bean.TestData;
import com.classliu.greendao.bean.TestData2;

import java.util.List;


public class TestDataAdapter<T> extends BaseAdapter {

    private List<T> dataList;
    private Context mContext;


    public TestDataAdapter(Context mContext, List<T> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

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
        String str = "";
        T data = dataList.get(position);
        if (data instanceof TestData) {
            str = ((TestData) data).getReader();
        } else {
            str = ((TestData2) data).getTestString();
        }
        textView.setText(str);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        return textView;
    }
}