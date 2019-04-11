package com.example.xqq407.network;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface MyService {
    @GET
    Observable<ResponseBody> doGet(@Url String url, @QueryMap Map<String,String> map,
                                   @Header("userId") String userId,
                                   @Header("sessionId") String sessionId);
}
