package com.example.mvp.view.interfaces;

public interface MainInterface<T> {
    void onSuccess(T t,int isWhat);
    void onError(String err);
}
