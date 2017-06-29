package com.example.hppc.rest;

public interface RestDelegate {

    void onSuccess(Object object);

    void onError(int code, String error);

    void forbidden();
}
