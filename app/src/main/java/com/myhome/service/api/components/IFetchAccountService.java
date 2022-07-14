package com.myhome.service.api.components;

import com.myhome.blueprint.Account;
import com.myhome.service.api.callback.CallbackEntity;
import com.myhome.util.ResponseEntity;

import org.json.JSONObject;

public interface IFetchAccountService {

    void login(String email, String password, CallbackEntity<String> callback);

    void register(String email, String password, CallbackEntity<String> callback);

    void update(String email, String password, CallbackEntity<Boolean> callback);

    void delete(Long accountId, CallbackEntity<Boolean> callback);

    void forgottenPW(String email, CallbackEntity<Boolean> callback);
}
