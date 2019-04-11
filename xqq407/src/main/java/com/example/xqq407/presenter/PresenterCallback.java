package com.example.xqq407.presenter;

import java.util.Map;

public interface PresenterCallback {
    void getData(String url, Map<String,String> map,int type,String userId,String sessionId);
}
