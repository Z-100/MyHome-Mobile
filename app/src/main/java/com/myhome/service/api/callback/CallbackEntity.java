package com.myhome.service.api.callback;

public interface CallbackEntity<T> {

    void handleResponse(T result);
}
