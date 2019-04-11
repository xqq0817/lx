package com.example.xqq407.model;

import com.example.xqq407.entity.ShowBean;
import com.example.xqq407.utils.RetrofitCallback;
import com.example.xqq407.utils.RetrofitUtils;
import com.google.gson.Gson;

import java.util.Map;

public class ShowModel implements ModelCallback{
    @Override
    public void setData(String url, Map<String, String> map, int type, String userId, String sessionId, RetrofitCallback retrofitCallback) {
        switch (type){
            case 1:
                getShow(url,map,userId,sessionId,retrofitCallback);
                break;
        }
    }
    //显示数据
    private void getShow(String url, Map<String, String> map, String userId, String sessionId, final RetrofitCallback retrofitCallback) {
        RetrofitUtils.getInstance().doGet(url, map, userId, sessionId).setHttpListener(new RetrofitUtils.HttpListener() {
            //成功
            @Override
            public void success(String result) {
                //gson解析
                ShowBean showBean = new Gson().fromJson(result, ShowBean.class);
                retrofitCallback.success(showBean);
            }
            //失败
            @Override
            public void failure(String error) {
                retrofitCallback.failure(error);
            }
        });
    }
}
