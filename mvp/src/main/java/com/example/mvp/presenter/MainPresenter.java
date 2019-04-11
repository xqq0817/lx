package com.example.mvp.presenter;

import com.example.mvp.model.bean.GoodsBean;
import com.example.mvp.model.http.HttpUtils;
import com.example.mvp.view.interfaces.MainInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainInterface>{

    private final HttpUtils instance;

    public MainPresenter(){
        instance = HttpUtils.getInstance();
    }

    public void getGoods() {
        instance.api.getGoods()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GoodsBean>() {
                    @Override
                    public void accept(GoodsBean goodsBean) throws Exception {
                        getView().onSuccess(goodsBean,0);
                    }
                });
    }
}
