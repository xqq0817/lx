package com.example.xqq407.model;

import com.example.xqq407.utils.RetrofitCallback;

import java.util.Map;

public interface ModelCallback {
    void setData(String url, Map<String,String> map,int type, String userId, String sessionId, RetrofitCallback retrofitCallback);
}
