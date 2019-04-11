package com.example.mvp.presenter;

public class BasePresenter<V> {
    private V view;
    public V getView(){
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }
    public void detachView(){
        this.view=null;
    }
}
