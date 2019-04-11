package com.example.mvp.model.app;

import com.example.mvp.model.bean.GoodsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("commodity/v1/commodityList")
    Observable<GoodsBean> getGoods();
}
