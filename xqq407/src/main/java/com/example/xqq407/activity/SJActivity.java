package com.example.xqq407.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xqq407.R;
import com.example.xqq407.adapter.ShowAdapter;
import com.example.xqq407.api.Api;
import com.example.xqq407.entity.ShowBean;
import com.example.xqq407.presenter.ShowPresenter;
import com.example.xqq407.view.DataView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SJActivity<T> extends AppCompatActivity implements DataView<T>, XRecyclerView.LoadingListener{

    @BindView(R.id.xrv)
    XRecyclerView xrv;
    @BindView(R.id.ll)
    TextView ll;
    private ShowPresenter showPresenter;
    private ShowAdapter showAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sj);
        //ButterKnife
        ButterKnife.bind(this);
        //数据
        initData();
        //加载更多
        xrv.setLoadingMoreEnabled(true);

        xrv.setLoadingListener(this);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SJActivity.this, WebActivity.class);
                startActivity(intent);
            }
        });
    }

    //数据
    private void initData() {
        /**
         * p层
         */
        showPresenter = new ShowPresenter(this);
        //内存泄漏
        showPresenter.attchView(this);
        //HashMap集合
        HashMap<String, String> map = new HashMap<>();
        map.put("page", "1");
        map.put("count", "20");
        showPresenter.getData(Api.USER, map, 1, "11249", "155056366467311249");
    }

    //成功
    @Override
    public void success(T result) {
        //判断
        if (result instanceof ShowBean) {
            //bean类
            ShowBean showBean = (ShowBean) result;
            //adapter适配器
            showAdapter = new ShowAdapter(this, showBean.getResult());
            xrv.setAdapter(showAdapter);
            //布局管理器
            xrv.setLayoutManager(new GridLayoutManager(this, 2));

        }
    }

    @Override
    public void failure(T error) {

    }

    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.detachView();
    }

    @Override
    public void onRefresh() {
        xrv.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        xrv.loadMoreComplete();
        Toast.makeText(this, "已无更多数据", Toast.LENGTH_SHORT).show();
    }
}
