package com.example.mvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mvp.R;
import com.example.mvp.model.bean.GoodsBean;
import com.example.mvp.presenter.MainPresenter;
import com.example.mvp.view.adapter.ShowAdapter;
import com.example.mvp.view.interfaces.MainInterface;

import java.util.List;

public class MainActivity extends BaseActivity implements MainInterface {

    private MainPresenter mainPresenter;
    private RecyclerView rv;

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);

        mainPresenter.getGoods();
    }

    @Override
    protected void initView() {
        rv=bindView(R.id.rv);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o, int isWhat) {
        GoodsBean goodsBean= (GoodsBean) o;
        List<GoodsBean.ResultBean.MlssBean.CommodityListBeanXX> list = goodsBean.getResult().getMlss().getCommodityList();
        ShowAdapter showAdapter = new ShowAdapter(this,list);
        rv.setAdapter(showAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onError(String err) {

    }
}
