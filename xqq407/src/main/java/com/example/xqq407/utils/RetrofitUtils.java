package com.example.xqq407.utils;

import com.example.xqq407.api.Api;
import com.example.xqq407.network.MyService;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitUtils {

    private final MyService myService;

    private RetrofitUtils(){
        //日志拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //okHttpClient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        //retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.BASE)
                .client(okHttpClient)
                .build();

        myService = retrofit.create(MyService.class);
    }
    //单例
    public static RetrofitUtils getInstance() {
        return RetrofitHolder.UTIL;
    }
    private static class RetrofitHolder{
        private static final RetrofitUtils UTIL=new RetrofitUtils();
    }
    //get方法
    public RetrofitUtils doGet(String url, Map<String,String> map,String userId,String sessionId){
        myService.doGet(url, map, userId, sessionId).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
        return RetrofitUtils.getInstance();
    }

    private Observer observer=new Observer<ResponseBody>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            if (httpListener!=null){
                httpListener.failure(e.getMessage());
            }
        }

        @Override
        public void onNext(ResponseBody responseBody) {
            if (httpListener!=null){
                try {
                    httpListener.success(responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    public interface HttpListener{
        void success(String result);
        void failure(String error);
    }

    public HttpListener httpListener;

    public void setHttpListener(HttpListener httpListener){
        this.httpListener=httpListener;
    }
}
