package com.example.xqq407.presenter;

import com.example.xqq407.activity.SJActivity;
import com.example.xqq407.model.ShowModel;
import com.example.xqq407.utils.RetrofitCallback;
import com.example.xqq407.view.DataView;

import java.lang.ref.WeakReference;
import java.util.Map;

public class ShowPresenter<T> implements PresenterCallback{
    private DataView dataView;
    private ShowModel showModel=new ShowModel();
    private WeakReference<T> tWeakReference;

    public ShowPresenter(DataView dataView) {
        this.dataView=dataView;
    }

    @Override
    public void getData(String url, Map<String, String> map, int type, String userId, String sessionId) {
        showModel.setData(url, map, type, userId, sessionId, new RetrofitCallback() {
            //成功
            @Override
            public void success(Object result) {
                dataView.success(result);
            }
            //失败
            @Override
            public void failure(Object error) {
                dataView.failure(error);
            }
        });
    }

    public void attchView(T t){
        tWeakReference = new WeakReference<>(t);
    }

    public void detachView(){
        if (tWeakReference.get()!=null){
            tWeakReference.clear();
            tWeakReference=null;
        }
    }
}
