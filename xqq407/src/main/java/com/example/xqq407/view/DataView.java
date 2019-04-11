package com.example.xqq407.view;

public interface DataView<T> {
    void success(T result);
    void failure(T error);
}
