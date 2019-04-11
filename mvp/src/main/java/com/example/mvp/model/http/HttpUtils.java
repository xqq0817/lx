package com.example.mvp.model.http;

import com.example.mvp.model.app.Api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {

    public final Api api;
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    //私有
    private HttpUtils(){
        //okhttp
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Response proceed = chain.proceed(request);
                        return proceed;
                    }
                })
                .build();
        //Retrofit
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://172.17.8.100/small/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }
    //静态内部类
    public static HttpUtils getInstance() {
        return HttpUtilsInstance.httpUtils;
    }
    private static class HttpUtilsInstance{
        private static HttpUtils httpUtils=new HttpUtils();
    }
}
