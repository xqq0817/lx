package com.example.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mvp.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class HandlerActivity extends BaseActivity {

    private SimpleDraweeView simp_qsy;
    private TextView times;

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        simp_qsy = bindView(R.id.simp_qsy);
        times = bindView(R.id.times);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_handler;
    }
}
