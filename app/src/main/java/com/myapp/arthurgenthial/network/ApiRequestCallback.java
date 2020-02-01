package com.myapp.arthurgenthial.network;

public class ApiRequestCallback<T> {
    public void onSuccess(T result) {}
    public void onError(ApiError error) {}
}
