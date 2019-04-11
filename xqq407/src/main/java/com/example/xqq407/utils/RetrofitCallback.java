package com.example.xqq407.utils;

public interface RetrofitCallback<T> {
    void success(T result);
    void failure(T error);
}
