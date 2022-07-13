package com.myhome.service.api.components.impl;

import com.myhome.Application;
import com.myhome.blueprint.Account;
import com.myhome.other.ApiConstants;
import com.myhome.other.Logger;
import com.myhome.other.Session;
import com.myhome.service.api.callback.CallbackEntity;
import com.myhome.service.api.components.GsonRequest;
import com.myhome.service.api.components.IFetchAccountService;
import com.myhome.service.api.constants.HttpStatus;
import com.myhome.util.ResponseEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FetchAccountService implements IFetchAccountService {

    String urlLogin = "/login";

    @Override
    public void login(CallbackEntity<String> callback) {

        Map<String, String> headers = new HashMap<>(Session.Factory.getAuth().getHeaders());

        GsonRequest<JSONObject> loginRequest = new GsonRequest<>(
                urlLogin, JSONObject.class, headers,
                response -> {
                    try {
                        callback.handleResponse(response.getString(ApiConstants.TOKEN_FIELD));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> Logger.log("", "", "")
        );

        Application.queue.add(loginRequest);
    }

    @Override
    public ResponseEntity<String> register(Account account) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> update(Account account) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> delete(Account account) {
        return null;
    }

    @Override
    public ResponseEntity<Account> forgottenPW(Account account) {
        return null;
    }
}
