package com.myhome.service.api.components;

import com.myhome.blueprint.Account;
import com.myhome.service.api.callback.CallbackEntity;
import com.myhome.util.ResponseEntity;

import org.json.JSONObject;

public interface IFetchAccountService {

    void login(CallbackEntity<String> callback);

    ResponseEntity<String> register(Account account);

    ResponseEntity<Boolean> update(Account account);

    ResponseEntity<Boolean> delete(Account account);

    ResponseEntity<Account> forgottenPW(Account account);
}
