package com.myhome.service.api.components.impl;

import com.myhome.Application;
import com.myhome.other.API;
import com.myhome.other.Api;
import com.myhome.other.Session;
import com.myhome.service.api.callback.CallbackEntity;
import com.myhome.service.api.components.GsonRequest;
import com.myhome.service.api.components.IFetchAccountService;
import com.myhome.util.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FetchAccountService implements IFetchAccountService {

    private final String BASE_ACCOUNT = API.URL_BASE.value() +  API.URL_ACCOUNT.value();

    @Override
    public void login(String email, String password, CallbackEntity<String> callback) {
        Map<String, String> headers = new HashMap<>();
        headers.put(API.FIELD_EMAIL.value(), email);
        headers.put(API.FIELD_PASSWORD.value(), password);

        String loginURL = BASE_ACCOUNT + API.URL_LOGIN;

        GsonRequest<String> loginAccountRequest = new GsonRequest<>(
                loginURL, String.class, headers,
                callback::handleResponse,
                error -> Logger.log("", "", "")
        );
        Application.queue.add(loginAccountRequest);
    }

    @Override
    public void register(String email, String password, CallbackEntity<String> callback) {
        Map<String, String> headers = new HashMap<>();
        headers.put(API.FIELD_EMAIL.value(), email);
        headers.put(API.FIELD_PASSWORD.value(), password);

        String registerURL = BASE_ACCOUNT + API.URL_REGISTER;

        GsonRequest<String> registerAccountRequest = new GsonRequest<>(
                registerURL, String.class, headers,
                callback::handleResponse,
                error -> Logger.log("", "", "")
        );
        Application.queue.add(registerAccountRequest);
    }

    @Override
    public void update(String email, String password, CallbackEntity<Boolean> callback) {
        Map<String, String> headers = new HashMap<>(Session.Factory.getAuth().getHeaders());
        headers.put(API.FIELD_NEW_EMAIL.value(), email);
        headers.put(API.FIELD_NEW_PASSWORD.value(), email);

        String updateAccountURL = BASE_ACCOUNT + API.URL_UPDATE;

        GsonRequest<Boolean> updateAccountRequest = new GsonRequest<>(
                updateAccountURL, Boolean.class, headers,
                callback::handleResponse,
                error -> Logger.log("", "", "")
        );
        Application.queue.add(updateAccountRequest);
    }

    @Override
    public void delete(Long accountId, CallbackEntity<Boolean> callback) {
        Map<String, String> headers = new HashMap<>(Session.Factory.getAuth().getHeaders());
        headers.put(API.FIELD_ACCOUNT_ID.value(), String.valueOf(accountId));

        String deleteAccountURL = BASE_ACCOUNT + API.URL_DELETE;

        GsonRequest<Boolean> deleteAccountRequest = new GsonRequest<>(
                deleteAccountURL, Boolean.class, headers,
                callback::handleResponse,
                error -> Logger.log("", "", "")
        );
        Application.queue.add(deleteAccountRequest);
    }

    @Override
    public void forgottenPW(String email, CallbackEntity<Boolean> callback) {
        Map<String, String> headers = new HashMap<>();
        headers.put(API.FIELD_EMAIL.value(), email);

        String forgottenPwURL = BASE_ACCOUNT + API.URL_FORGOTTEN_PW;

        GsonRequest<Boolean> registerAccountRequest = new GsonRequest<>(
                forgottenPwURL, Boolean.class, headers,
                callback::handleResponse,
                error -> Logger.log("", "", "")
        );
        Application.queue.add(registerAccountRequest);
    }
}
