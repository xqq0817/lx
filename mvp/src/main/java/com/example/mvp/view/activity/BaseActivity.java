package com.example.mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        //视图
        initView();
        //数据
        initData();
        //监听
        bindEvent();
    }
    //监听
    protected abstract void bindEvent();
    //数据
    protected abstract void initData();
    //视图
    protected abstract void initView();
    //主布局
    protected abstract int bindLayout();

    protected <T extends View > T bindView(int resId){
        return (T) findViewById(resId);
    }
    public void ToastData(String arg){
        Toast.makeText(this,arg,Toast.LENGTH_SHORT).show();
    }
}
